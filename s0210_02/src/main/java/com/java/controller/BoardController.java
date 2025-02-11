package com.java.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	@Autowired HttpServletRequest request;
	
	// 게시글 전체보기 + 검색
	// 받을 곳 = 받기 위한 호출
	@GetMapping("/board/blist")
	public String blist(@RequestParam(value="page", defaultValue="1") int page,
			String category, String searchW, Model model) {
		Map<String, Object> map = boardService.blist(page, category, searchW);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("page", map.get("page"));
		model.addAttribute("category", map.get("category"));
		model.addAttribute("searchW", map.get("searchW"));
		model.addAttribute("maxPage", map.get("maxPage"));
		model.addAttribute("endpage", map.get("endpage"));
		model.addAttribute("startpage", map.get("startpage"));
		return "blist";
	}
	
	// 글쓰기 페이지 열기
	@GetMapping("/board/bwrite")
	public String bwrite() {
		return "bwrite";
	}
	
	// 글쓰기 전송
	// 받을게 없기 때문에 호출에 보낼거를 담아 보냄
	@PostMapping("/board/bwrite")
	public String bwrite(BoardDto bdto) {
		boardService.bwrite(bdto);
		System.out.println("잘 받았음 " + bdto.getBtitle());
		return "redirect:/?chkBwrite=1";
	}
	
	// 글보기 페이지 열기
	@GetMapping("/board/bview")
	public String bview(@RequestParam(defaultValue = "1") int bno, int page, Model model) {
		// 1개의 게시글 가져오기
		// 주소에서 가지고 오는 값은 모두 string / int로 형변환을 해주면서 디폴트값 1로 설정
		Map<String, Object> map = boardService.bview(bno);
		model.addAttribute("list",map.get("boardDto"));
		model.addAttribute("pdto",map.get("prevDto"));
		model.addAttribute("ndto",map.get("nextDto"));
		 model.addAttribute("page", page);
		
		return "bview";
	}
	
	// 게시글 삭제
	@GetMapping("/board/bdelete")
	public String bdelete(int bno, int page) {
		boardService.bdelete(bno);
		return "redirect:/board/blist?page="+page;
	}
	
	// 게시글 수정창 열림
	@GetMapping("/board/bmodify")
	public String bmodify(int bno, int page, Model model) {
		BoardDto boardDto = boardService.bmodify(bno);
		model.addAttribute("list",boardDto);
		model.addAttribute("page",page);
		return "bmodify";
	}
	
	// 게시글 수정 전송
	@PostMapping("/board/bmodify")
	public String bmodify(BoardDto modib, int page) {
		System.out.println("넘어오나"+modib.getBtitle());
		System.out.println("넘어오나"+modib.getBno());
		boardService.bmodify(modib);
		return "redirect:/board/blist?page="+page;
	}
	
	// 답변달기 페이지
	@GetMapping("/board/breply")
	public String breply(int bno, int page, Model model) {
		BoardDto boardDto = boardService.breply(bno);
		model.addAttribute("bdto",boardDto);
		return "breply";
	}
	
	// 답변달기 전송
	@PostMapping("/board/breply")
	public String breply(BoardDto bdto, int page) {
		boardService.breply(bdto);
		return "redirect:/board/blist?page="+page;
	}

}
