package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
public class BController {
	
	@Autowired BoardService boardService;
	
	// 게시글 불러오기
	@GetMapping("/board/blist")
	public String blist(Model model, String category, String searchW) {
		ArrayList<BoardDto> list = boardService.blist(category, searchW);
		model.addAttribute("list",list);
		return "blist";
	}
	
	

}
