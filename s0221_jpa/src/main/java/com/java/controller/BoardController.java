package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.data.web.SortDefault.SortDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
public class BoardController {

	@Autowired BoardService boardService;
	
	//pageable 하단 page를 자동으로 계산해서 가져옴
	@GetMapping("/blist")
	//@ResponseBody // 데이터로 리턴
	public String blist(@PageableDefault(page=0,size=5) // 1페이지당 10개 
	@SortDefaults({
			@SortDefault(sort="bgroup", direction=Sort.Direction.DESC),
			@SortDefault(sort="bstep", direction=Sort.Direction.ASC)
	})	Pageable pageable, Model model) {
		// list 타입ㅇ ㅣ아닌 page 객체가 됨 
		
		Page<BoardDto> page = boardService.findAll(pageable);
		List<BoardDto> list = page.getContent();
		
		// 하단 넘버링 생성
		//page 정보를 정리해서 model로 전송
		//page는 0번부터 시작
		int nowpage = page.getPageable().getPageNumber()+1;
		int maxpage = page.getTotalPages();
		int startpage = ((nowpage-1)/10)*10+1;
		int endpage = startpage+10-1;
		endpage = Math.min(maxpage, endpage);
		
		model.addAttribute("list",list);
		model.addAttribute("nowpage",nowpage);
		model.addAttribute("maxpage",maxpage);
		model.addAttribute("startpage",startpage);
		model.addAttribute("endpage",endpage);
		
		System.out.println("nowpage : "+nowpage);
		System.out.println("maxpage : "+maxpage);
		return "blist";
	}
	
	@GetMapping("/bview")
	public String bview(int bno, Model model) {
		BoardDto boardDto = boardService.findById(bno);
		model.addAttribute("bdto",boardDto);
		return "bview";
	}
	
	// 제목/내용 검색
	@GetMapping("/bsearch")
	public String bsearch(String search, Model model) {
		List<BoardDto> list = boardService.findByBtitleContaining(search);
		model.addAttribute("list",list);
		System.out.println("검색어| 컨트롤러 : "+search);
		return "blist";
	}

	
}
