package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface CustomerDao {

	// 게시글 전체 리스트 (검색결과리스트)
	ArrayList<BoardDto> selectAll(String category, String searchW);

	// 게시글 뷰페이지
	BoardDto selectOne(int bno);
	// 뷰페이지 - 이전글 가져오기
	BoardDto selectPrev(int bno);
	// 뷰페이지 - 다음글 가져오기
	BoardDto selectNext(int bno);

}
