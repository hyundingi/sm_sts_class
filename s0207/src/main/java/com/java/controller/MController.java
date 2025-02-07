package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
// member controller
public class MController {
	
	@Autowired
	HttpSession session; // 섹션 객체 생성
	
	@GetMapping("/member/login")
	public String login() {
		return "member/login"; // jsp페이지를 호출
	}
	
	@PostMapping("/member/login")
	public String login(String id, String pw, Model model) {
		// 아이디와 패스워드를 가지고 db에 접근해서 맞는지 확인
		if(id.equals("aaa") && pw.equals("1111")) {
			// redirect 했을 때 모델은 값을 넘기지 못함 (파라미터, 섹션 사용해야함)
			// model.addAttribute("chk","1");
			session.removeAttribute("logoutchk"); // 섹션 1개 삭제
			session.setAttribute("session_id", id);
			return "redirect:/?chk=1"; 
		}else {
			return "redirect:/member/login?chk=0";
		}
	}
	
	@GetMapping("/member/logout")
	public String logout() {
		session.invalidate(); // 섹션 모두 삭제
		return "redirect:/?outchk=1";
	}
	

}
