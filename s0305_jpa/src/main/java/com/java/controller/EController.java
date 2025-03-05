package com.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.CboardDto;
import com.java.dto.EventDto;
import com.java.service.EventService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EController {
	
	@Autowired EventService eventService;

	
	@GetMapping("/event/event")
	public String event(Model model) {
		// 전체 리스트 가져오기
		List<EventDto> list = eventService.findAll();
		model.addAttribute("list",list);
		return "event/event";
	}
	
	@GetMapping("/event/eview")
	public String eview(int eno, Model model) {
		// 전체 리스트 가져오기
		EventDto eventDto = eventService.findByEno(eno);
		model.addAttribute("edto",eventDto);
		return "event/eview";
	}
	
	
	
	
}
