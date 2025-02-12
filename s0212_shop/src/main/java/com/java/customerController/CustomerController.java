package com.java.customerController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.dto.BoardDto;
import com.java.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired CustomerService customerService;
	
	
	@GetMapping("/customer/notice")
	public String notice(String category, String searchW, Model model) {
		// 현재 날짜
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(d);
		
		
		Map<String, Object> map = customerService.notice(category, searchW);
		
		model.addAttribute("list",map.get("list"));
		System.out.println("카테고리 ~~~~~"+map.get("category"));
		System.out.println("검색어 ~~~~~"+map.get("searchW"));
		model.addAttribute("today",today);
		return "customer/notice";
	}
	
	@GetMapping("/customer/nview")
	public String nview(int bno, Model model) {
		Map<String, Object> map = customerService.nview(bno);
		model.addAttribute("bdto", map.get("boardDto"));
		model.addAttribute("prev", map.get("prevDto"));
		model.addAttribute("next", map.get("nextDto"));
		return "customer/nview";
	}
}
