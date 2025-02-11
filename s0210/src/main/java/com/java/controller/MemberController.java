package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	// 회원가입 페이지 오픈
		@GetMapping("/member/member")
		public String member() {
			return "member";
		}
		
		// 회원가입 체크
		@PostMapping("/member/member")
		public String member(MemberDto mdto) {
			// 받을게 없고 보낼 거만 있으니까 이렇게 하면 됨
			memberService.member(mdto);
			return "redirect:/";
		}
		
		// 로그인 페이지 오픈
		@GetMapping("/member/login")
		public String login() {
			return "login";
		}
		
		// 로그아웃 페이지 오픈
		@GetMapping("/member/logout")
		public String logout(Model model) {
			session.invalidate();
			model.addAttribute("chkLogin","0");
			return "logout";
		}
		
		// 로그인 체크
		@PostMapping("/member/login")
		public String login(String id, String pw, Model model) {
			MemberDto memberDto = memberService.login(id,pw);
			if (memberDto == null) { // 로그인 실패
				model.addAttribute("chkLogin","0");
			}else { // 로그인 성공
				model.addAttribute("chkLogin","1");
				session.setAttribute("session_id", id);
				session.setAttribute("session_name", memberDto.getName());
			}
			return "login";
		}
		

}
