package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.MemDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		MemDto m = new MemDto();
		MemDto m1 = MemDto.builder().id("bbb").pw("1111").build();
		model.addAttribute("member",MemDto.builder().id(id).name("홍길동").build());
		
		return "index";
	}
}
