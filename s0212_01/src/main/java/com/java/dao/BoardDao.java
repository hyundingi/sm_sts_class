package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardDao {

	// 전체 리스트 가져오기
	ArrayList<BoardDto> selectAll();

	// 글쓰기 
	void insertBoard(BoardDto bdto);

	// 뷰페이지 - 하나만 가져오기
	BoardDto selectOne(int bno);

}
