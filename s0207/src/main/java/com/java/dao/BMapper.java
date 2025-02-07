package com.java.dao;

import java.util.ArrayList;

// import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

// @Repository -- 원ㄹ ㅐ 이거써야하는데 mybatis 라 mapper 사용
@Mapper
public interface BMapper {
	// 게시판 리스트
	ArrayList<BoardDto> blist();

}
