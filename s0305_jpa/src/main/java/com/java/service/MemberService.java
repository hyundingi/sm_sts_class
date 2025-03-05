package com.java.service;

import java.util.List;

import com.java.dto.MemberDto;

public interface MemberService {

	// jpa 회원 전체 리스트
	List<MemberDto> FindAll();

}
