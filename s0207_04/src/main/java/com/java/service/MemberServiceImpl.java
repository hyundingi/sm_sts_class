package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberDao;
import com.java.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired MemberDao memberDao;
	
	@Override
	public ArrayList<MemberDto> mlist() {
		ArrayList<MemberDto> list = memberDao.selectAll();
		return list;
	}

}
