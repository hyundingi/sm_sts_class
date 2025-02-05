package com.java.controller;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	
	@Autowired HttpSession session;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login(HttpServletRequest request) {
		System.out.println("get방식으로 들어왓음");
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin() {
		System.out.println("post방식으로 들어왔음");
//		HttpSession session = request.getSession();
		session.setAttribute("session_id", "aaa"); // 섹션 추가
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate(); // 섹션 삭제
		return "logout";
	}
	
	

}
