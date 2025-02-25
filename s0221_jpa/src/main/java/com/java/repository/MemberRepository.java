package com.java.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.dto.MemberDto;

// JpaRepository<MemberDto, String> <리턴타입, primary key의 타입>
public interface MemberRepository extends JpaRepository<MemberDto, String>{

	// select * from memberdto where id=#{id} and pw=#{pw}
	 MemberDto findByIdAndPw(String id, String pw);
	
	//memberDto 로그인 부분 쿼리
//	@Query(value = "select * from boarddto where id=? and pw=?", nativeQuery = true)
//	Optional<MemberDto> findByIdAndPw(String id, String pw);

}
