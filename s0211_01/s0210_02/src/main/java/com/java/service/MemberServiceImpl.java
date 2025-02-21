package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberDao;
import com.java.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired MemberDao memberDao;

	@Override
	public MemberDto login(MemberDto mdto) { 
		// 로그인 확인
		MemberDto memberDto = memberDao.selectLogin(mdto);
		return memberDto;
	}

}
