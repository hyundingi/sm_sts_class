package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.CboardDto;
import com.java.service.EventService;

import jakarta.servlet.http.HttpSession;

@RestController
public class ReController {
	
	@Autowired HttpSession session;
	@Autowired EventService eventService;
	
	@PostMapping("/event/cwrite")
	public CboardDto cwrite(CboardDto cdto) {
		System.out.println(cdto.getCpw());
//		String id = (String) session.getAttribute("session_id");
		cdto.setId("aaa");
		// 댓글저장
		CboardDto cboardDto = eventService.cwrite(cdto);
		return cboardDto; // 데이터를 전달함, 페이지 오픈 x
	}

}
