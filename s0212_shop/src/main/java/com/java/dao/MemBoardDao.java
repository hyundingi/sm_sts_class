package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemBoardDto;

@Mapper
public interface MemBoardDao {

	ArrayList<MemBoardDto> selectAll();

}
