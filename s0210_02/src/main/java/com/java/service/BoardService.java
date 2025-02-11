package com.java.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.dto.BoardDto;

public interface BoardService {

	// 게시글 전체 불러오기
	Map<String, Object> blist(int page, String category, String searchW);

	// 글쓰기 저장
	void bwrite(BoardDto bdto);
	
	// 게시글 하나만 불러오기
	Map<String, Object> bview(int bno);

	// 게시글 삭제
	void bdelete(int bno);

	// 게시글 수정 저ㅏ자ㅣㅇ
	void bmodify(BoardDto modib);

	// 게시글 수정페이지
	BoardDto bmodify(int bno);

	// 답변달기 페이지
	BoardDto breply(int bno);

	// 답변 전송
	void breply(BoardDto bdto);

}
