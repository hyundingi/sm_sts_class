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
public class FController {
	
	@Autowired MemberService memberService;
	// MemberService memberService2 = new MemberServiceImpl()
	// 랑 동일한 의미임.
	@Autowired HttpSession session;
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
}
