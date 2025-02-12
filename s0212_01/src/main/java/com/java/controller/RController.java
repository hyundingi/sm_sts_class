package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@RestController
public class RController {
	
//	controller > jsp 페이지를 열어달라고 요청함
//	restcontroller > 데이터를 달라고 요청
	
	@Autowired BoardService boardService;
	
	
	@GetMapping("/restpage")
	public ArrayList<BoardDto> restpage() {
		
		// String[] arr = {"가","나","가","라"};
		ArrayList<BoardDto> list = boardService.blist();
		return list;
	}
}
