package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardDao {

	void insertBoard(BoardDto bdto);

	ArrayList<BoardDto> selectAll();

	BoardDto selectOne(int bno);

}
