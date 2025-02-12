package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BoardService {

	// 전체 리스트 가져오기
	ArrayList<BoardDto> blist();

	// 글쓰기 페이지
	void bwrite(BoardDto bdto);

	// 글 한개 가져오기
	BoardDto bview(int bno);

}
