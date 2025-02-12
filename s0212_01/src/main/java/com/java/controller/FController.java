package com.java.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FController {
	
	@Autowired BoardService boardService;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@ResponseBody // 데이터를 전해 달라고 요청함
	@GetMapping("/rpage")
	public String rpage() {
		return "rpage";
	}
	
	@GetMapping("/board/bwrite")
	public String bwrite() {
		return "bwrite";
	}

	// 한개 파일 업로드
	@PostMapping("/board/bwrite")
	public String bwrite(BoardDto bdto, 
			@RequestPart MultipartFile files) throws Exception {
		String real_fname = "";
		if(!files.isEmpty()) { // 만약 파일이 있으면
			
			// 파일 최초 이름 > 시간+파일이름 으로 설정 (중복방지)
			String origin_fname = files.getOriginalFilename();
			long time = System.currentTimeMillis();
			real_fname = String.format("%d_%s", time ,origin_fname);
			
			// 랜덤글자 생성해서 파일 이름 만드는 방법
			// UUID uuid = UUID.randomUUID();
			// String uname = uuid+"_"+origin_fname;
			
			// 파일 저장 위치
			//String url = "C:\\worksts\\s0212_01\\src\\main\\resources\\static\\upload\\";
			String url = "C:/upload/board/";
			
			// 파일 저장
			File f = new File(url+real_fname);
			
			// 파일업로드
			files.transferTo(f);
			bdto.setBfile(real_fname);
			
		}else {
			bdto.setBfile("");
		}
		boardService.bwrite(bdto);
		System.out.println("파일 업로드 성공");
		return "redirect:/board/blist";
	}
	
	// 파일 두개 업로드
//	@PostMapping("/board/bwrite")
//	public String bwrite(BoardDto bdto, 
//			List<MultipartFile> files) throws Exception {
//		String real_fname = "";
//		if(!files.isEmpty()) { // 만약 파일이 있으면
//			
//			for(MultipartFile file : files) {
//				
//				// 파일 최초 이름 > 시간+파일이름 으로 설정 (중복방지)
//				String origin_fname = file.getOriginalFilename();
//				long time = System.currentTimeMillis();
//				real_fname = String.format("%d_%s", time ,origin_fname);
//				
//				// 랜덤글자 생성해서 파일 이름 만드는 방법
//				// UUID uuid = UUID.randomUUID();
//				// String uname = uuid+"_"+origin_fname;
//				
//				// 파일 저장 위치
//				//String url = "C:\\worksts\\s0212_01\\src\\main\\resources\\static\\upload\\";
//				String url = "C:/upload/board/";
//				
//				// 파일 저장
//				File f = new File(url+real_fname);
//				
//				// 파일업로드
//				file.transferTo(f);
//			}
//			// bdto에 이름 저장
//			bdto.setBfile(real_fname);
//		}else {
//			bdto.setBfile("");
//		}
//		boardService.bwrite(bdto);
//		System.out.println("파일 업로드 성공");
//		return "redirect:/board/blist";
//	}
	
	@GetMapping("/board/blist")
	public String blist(Model model) {
		ArrayList<BoardDto> list = boardService.blist();
		model.addAttribute("list", list);
		return "blist";
	}
	
	@GetMapping("/board/bview")
	public String bview(int bno, Model model) {
		BoardDto boardDto = boardService.bview(bno);
		model.addAttribute("bdto", boardDto);
		return "bview";
	}
	
}
