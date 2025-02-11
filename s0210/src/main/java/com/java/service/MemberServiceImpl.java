package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberDao;
import com.java.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired MemberDao memberdao;
	
	@Override // 로그인 확인 메소드
	public MemberDto login (String id, String pw) {
		//dao로 보냄
		MemberDto memberDto = memberdao.selectLogin(id, pw);
		return memberDto;
	}

	@Override // 회원가입 데이터 전송 메소드
	public void member(MemberDto mdto) {
		int result = memberdao.insertMember(mdto);
		System.out.println("결과 : "+result);
		
	}

}
