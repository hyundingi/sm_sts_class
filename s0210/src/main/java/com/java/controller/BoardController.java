package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	
	// 게시판 이동
	@GetMapping("/board/blist")
	public String blist(Model model) {
		// 2개 이상 받아올 때는 무조건 list 사용해야함.
		ArrayList<BoardDto> list = boardService.blist();
		model.addAttribute("list", list);
		return "blist";
	}
	
	// 글쓰기
	@GetMapping("/board/boardwrite")
	public String boardwrite() {
		return "boardwrite";
	}
	
	// 글쓰기 저장
	@PostMapping("/board/boardwrite")
	public String boardwrite(BoardDto bdto) {
		boardService.boardWrite(bdto);
		return "boardwrite";
	}
	

}
