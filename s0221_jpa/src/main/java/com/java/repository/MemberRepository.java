package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.dto.MemberDto;

// JpaRepository<MemberDto, String> <리턴타입, primary key의 타입>
public interface MemberRepository extends JpaRepository<MemberDto, String>{

	// select * from memberdto where id=#{id} and pw=#{pw}
	MemberDto findByIdAndPw(String id, String pw);

}
