package com.java.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.MemberDto;


@Controller
public class FController {
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/")
	public String index() {
		MemberDto m = new MemberDto();
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
// post 방식 사용해서 로그인
	@PostMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("login post  방식");
		
		model.addAttribute("member", new MemberDto(id, pw));
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		session.setAttribute("session_id", id);
		return "loginInfo";
	}
	
// get 방식 사용해서 로그인
//	@GetMapping("/dologin")
//	public String dologin() {
//		return "index";
//	}
	
	// 로그아웃 웬만하면 안 쓰기(requestmapping)
	@RequestMapping("/logout") // get post 둘 다 사용
	public String logout() {
		session.invalidate(); // 섹션삭제
		return "logout";
	}
	
	// 회원가입 페이지 
	@GetMapping("/join")
	public String join() {
		return "member";
	}
	
	// 회원가입 페이지
	@PostMapping("/join")
	public ModelAndView join(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		String hobby = "";
		for (int i=0;i<hobbys.length;i++) {
			if(i==0) hobby += hobbys[i];
			else hobby += ","+hobbys[i];
		}
		// model 사용 (Model model)
		// model.addAttribute("member", new MemberDto(id, pw, name, tel, gender, hobby));
		
		// modelandview 사용
		ModelAndView mv = new ModelAndView();
		mv.setViewName("memInfo");
		mv.addObject("member", new MemberDto(id, pw, name, tel, gender, hobby));
		return mv;
	}
	
	// 가입회원정보 리스트
	@GetMapping("/memInfo")
	public String memInfo() {
		return "memInfo";
	}
	
	
	

	

}
