package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired HttpSession session;
	@Autowired MemberService memberService;
	
	@GetMapping("/member/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/?loginChk=0";
	}
	
	@GetMapping("/member/login")
	public String login(HttpServletResponse response,
			HttpServletRequest request) {
		//쿠키생성
		//Cookie cookie = new Cookie("cook_id", "aaa");
		//cookie.setMaxAge(60*10);
		//response.addCookie(cookie);
		return "member/login";
	}
	
	@PostMapping("/member/login")
	public String login(MemberDto mdto, Model model) {
		System.out.println("controller id : "+mdto.getId());
		MemberDto memberDto = memberService.login(mdto);
		if(memberDto!=null) {
			session.setAttribute("session_id", memberDto.getId());
			return "redirect:/?loginChk=1";
		}else {
			model.addAttribute("loginChk",0);
			return "member/login";
		}
	}
	
	@GetMapping("/member/step01")
	public String step01() {
		return "member/step01";
	}
	
	@GetMapping("/member/step02")
	public String step02() {
		//session.eo
		return "member/step02";
	}
	
	@ResponseBody // 이메일 발송
	@PostMapping("/member/sendEmail")
		public String sendEmail(String email, Model model) {
			System.out.println("sendEmail : "+email);
			//String pwCode = memberService.sendEmail(email);
			String pwCode = memberService.sendEmail2(email);
			model.addAttribute("pwCode",pwCode);
			return email;
		}

	@ResponseBody // 인증코드 확인
	@PostMapping("/member/pwCodeChk")
	public String pwCodeChk(String pwCode) {
		System.out.println("pwcode : "+pwCode);
		//String pwCode = memberService.sendEmail(email);
		String pw = (String)session.getAttribute("pwCode");
		if(pwCode.equals(pw)) {
			return "1";
		}else {
			
			return "0";
		}
	}
	
	
	// 회원 1명 가져오기
		@CrossOrigin // 자바스크립트 접근 해제
		@ResponseBody // 데이터로 받음
		@GetMapping("/mlist2")
		public List<MemberDto> mlist2(Model model) {
			// 전체 회원리스트 
			List<MemberDto> list = memberService.selectAll();
			model.addAttribute("list",list);
			return list;
		}
		
		// 회원 1명 가져오기 
		@CrossOrigin // 자바스크립트 접근 해제
		@ResponseBody // 데이터로 받음
		@GetMapping("/member/memberView")
		public MemberDto memberView(String id) {
			System.out.println("id : "+id);
			MemberDto memberDto = memberService.memberView(id);
			
			return memberDto;
		}
		
		// 회원 전체 가져오기 
		@CrossOrigin // 자바스크립트 접근 해제
		@ResponseBody // 데이터로 받음
		@PostMapping("/member/memberList")
		public List<MemberDto> memberList() {
			List<MemberDto> list = memberService.memberList();
			return list;
		}
	

}
