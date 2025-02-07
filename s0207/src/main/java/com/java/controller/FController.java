package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//front controller
public class FController {
	
	@GetMapping("/?chk=")
	public String index(String chk) {
		
		return "index";
	}

}
