package com.java.controller;

import java.util.ArrayList;
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

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired MemberService memberService;
	@Autowired HttpSession session;

	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/mlist")
	public String mlist(Model model) {
		// 전체 회원리스트 
		List<MemberDto> list = memberService.findAll();
		model.addAttribute("list",list);
		return "mlist";
	}
	
	
	
	@GetMapping("/memInfo")
	public String memInfo(String id, Model model) {
		// 회원 상세보기
		MemberDto member = memberService.findById(id);
		model.addAttribute("member",member);
		return "memInfo";
	}
	
	@GetMapping("/memUpdate") // 회원정보 수정 페이지
	public String memUpdate(String id, Model model) {
		// 회원 상세보기
		MemberDto member = memberService.findById(id);
		model.addAttribute("member",member);
		return "memUpdate";
	}
	
	@PostMapping("/memUpdate") // 회원정보 수정 저장
	public String memUpdate(MemberDto mdto, Model model) {
		// 회원 상세보기
		MemberDto member = memberService.findById(mdto.getId());
		member.setPw(mdto.getPw());
		member.setPhone(mdto.getPhone());
		member.setGender(mdto.getGender());
		member.setHobby(mdto.getHobby());
		model.addAttribute("member",member);
		memberService.save(mdto); // primary key 가 존재하면 update실행, 존재하지 않으면 save 실행
		return "redirect:/mlist";
	}
	
	@PostMapping("/member")
	public String member(MemberDto mdto) {
		memberService.save(mdto);
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(String id, String pw) {
		MemberDto memberDto = memberService.findByIdAndPw(id,pw);
		if(memberDto != null) {
			System.out.println("로그인 되었습니다.");
			session.setAttribute("session_id", id);
			return "redirect:/";
		}else {
			System.out.println("로그인 실패");
			return "redirect:/login?loginchk=0";		}
	}
	
	@ResponseBody
	@PostMapping("/memDelete")
	public String memDelete(String id) {
		System.out.println("id : "+id);
		memberService.deleteById(id);
		return "1";
	}
}
