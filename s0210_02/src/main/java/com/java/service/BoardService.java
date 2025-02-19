package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BoardService {

	// 게시글 전체 불러오기
	ArrayList<BoardDto> blist();

	// 글쓰기 저장
	void bwrite(BoardDto bdto);
	
	// 게시글 하나만 불러오기
	BoardDto bview(int bno);

	// 게시글 삭제
	void bdelete(int bno);

	// 게시글 수정
	void bmodify(BoardDto modib);

}
