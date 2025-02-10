package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardDao {

	// 게시글 전체 가져오기
	ArrayList<BoardDto> selectAll();

	// 게시글 저장
	void bwrite(BoardDto bdto);

	// 게시글 1개 보기
	BoardDto selectOne(int bno);

	// 조회수 1증가
	void updateBhit(int bno);

	// 게시글 삭제
	void deleteBoard(int bno);

	// 게시글 수정
	void boardmodify(BoardDto modib);

}
