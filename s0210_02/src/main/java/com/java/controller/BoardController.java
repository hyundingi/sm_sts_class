package com.java.controller;

import java.util.ArrayList;

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
	
	// 게시글 전체보기
	// 받을 곳 = 받기 위한 호출
	@GetMapping("/board/blist")
	public String blist(Model model) {
		ArrayList<BoardDto> list = boardService.blist();
		model.addAttribute("list", list);
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
	public String bview(@RequestParam(defaultValue = "1") int bno, Model model) {
		// 1개의 게시글 가져오기
		// 주소에서 가지고 오는 값은 모두 string / int로 형변환을 해주면서 디폴트값 1로 설정
		BoardDto boardDto = boardService.bview(bno);
		model.addAttribute("list",boardDto);
		
		return "bview";
	}
	
	// 게시글 삭제
	@GetMapping("/board/bdelete")
	public String bdelete(int bno) {
		// 1개의 게시글 가져오기
		// 주소에서 가지고 오는 값은 모두 string / int로 형변환을 해주면서 디폴트값 1로 설정
		boardService.bdelete(bno);
		return "redirect:/board/blist";
	}
	
	// 게시글 수정창 열림
	@GetMapping("/board/bmodify")
	public String bmodify(int bno, Model model) {
		// 1개의 게시글 가져오기
		// 주소에서 가지고 오는 값은 모두 string / int로 형변환을 해주면서 디폴트값 1로 설정
		//boardService.bmodify(bno);
		BoardDto boardDto = boardService.bview(bno);
		model.addAttribute("list",boardDto);
		return "redirect:/board/bmodify?bno={bno}";
	}
	
	// 게시글 수정 전송
	@PostMapping("/board/bmodify")
	public String bmodify(BoardDto modib) {
		String bno = request.getParameter("bno");
		// boardService.bmodify(modib, bno);
		return "redirect:/board/blist";
	}

}
