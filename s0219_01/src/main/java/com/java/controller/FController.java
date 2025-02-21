package com.java.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

import jakarta.mail.Multipart;

@Controller
public class FController {
	
	@Autowired BoardService boardService;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/bwrite")
	public String bwrite() {
		return "bwrite";
	}
	
	@PostMapping("/bwrite")
	public String bwrite(BoardDto bdto, 
			@RequestPart MultipartFile file) throws Exception {
		String realFileName = "";
		bdto.setBfile(""); // bfile null 에러 방지
		if(!file.isEmpty()) {
			String origin = file.getOriginalFilename();
			long time = System.currentTimeMillis();
			realFileName = String.format("%d_%s", time, origin);
			System.out.println("파일이름 : "+realFileName);
			String url = "c:/upload/board/";
			File f = new File(url+realFileName); // 파일 객체 생성
			file.transferTo(f); // 파일 올리기
			bdto.setBfile(realFileName);
		}
		
		// boardService.bwrite(bdto);
		System.out.println("bcontent : "+bdto.getBcontent());
		System.out.println("파일입력 완료");
		
		return "redirect:/";
	}
	
	@PostMapping("/bwrite_upload")
	public String bwrite_upload(@RequestPart MultipartFile file) throws Exception {
		String realFileName = "";
		if(!file.isEmpty()) {
			String origin = file.getOriginalFilename();
			long time = System.currentTimeMillis();
			realFileName = String.format("%d_%s", time, origin);
			System.out.println("파일이름 : "+realFileName);
			String url = "c:/upload/board/";
			File f = new File(url+realFileName); // 파일 객체 생성
			file.transferTo(f); // 파일 올리기
		}
		return realFileName;
	}
}
