package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemberDto;

@Mapper
public interface MemberDao {

	MemberDto selectLogin(MemberDto mdto);

	List<MemberDto> selectAll();

	MemberDto selectOne(String id);

}
