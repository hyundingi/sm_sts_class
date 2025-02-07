package com.java.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired MemberService memberService;
	private Timestamp mdate;
	
	@GetMapping("/mlist")
	public String mlist(Model model) {
		ArrayList<MemberDto> list = memberService.mlist();
		model.addAttribute("list", list);
		return "member/mlist";
	}
	
	@GetMapping("/join")
	public String join(Model model) {
		ArrayList<MemberDto> list = memberService.mlist();
		model.addAttribute("list", list);
		return "member/join";
	}
	
	@PostMapping("/join")
	public String join(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String hobby = request.getParameter("hobby");
		String now = "2009-03-20 10:20:30.0";
		Timestamp date =  java.sql.Timestamp.valueOf(now);
		
		model.addAttribute("newmem", new MemberDto(id, pw, name, phone, gender, hobby, mdate));
		
		return "index";
	}

}
