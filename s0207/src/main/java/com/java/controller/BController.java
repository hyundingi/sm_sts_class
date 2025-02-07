package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.BoardDto;
import com.java.service.BService;


@Controller
// board controller
public class BController {
	
//	BService bService = new BServiceImpl();
	@Autowired
	BService bService;
	
	@GetMapping("/board/blist")
	public String blist(Model model) {
		// 게시판리스트 게시글 여러개가 존재
		// 게시글 한개만 가져오기 - BoardDto
		// 파일을 받아오는 메소드
		ArrayList<BoardDto> list = bService.blist();
		model.addAttribute("list",list);
		
		return "board/blist";
	}
	

}
