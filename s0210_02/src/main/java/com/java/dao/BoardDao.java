package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardDao {

	// 게시글 전체 가져오기 - 검색어 포함 (시작번호, 끝번호, 카테고리, 검색어)
	ArrayList<BoardDto> selectAll(int startrow, int endrow, String category, String searchW);

	// 하단 넘버링 - 게시글 총갯수 알아내기
	int countAll();

	// 게시글 저장
	void bwrite(BoardDto bdto);

	// 게시글 1개 보기 (현재게시글)
	BoardDto selectOne(int bno);

	// 이전 게시글 정보
	BoardDto selectOnePrev(int bno);
	
	// 다음 게시글 정보
	BoardDto selectOneNext(int bno);

	// 조회수 1증가
	void updateBhit(int bno);

	// 게시글 삭제
	void deleteBoard(int bno);

	// 게시글 수정
	void boardmodify(BoardDto modib);

	// 답변달기 - 자식게시글 bstep 1 ++
	void bstepUp(BoardDto bdto);

	// 답변달기 - 답변 저장
	void InsertBreply(BoardDto bdto);



}
