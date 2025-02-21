package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemBoardDao;
import com.java.dto.MemBoardDto;

@Service
public class MypageServiceImpl implements MypageService {

	@Autowired MemBoardDao memBoardDao;
	
	@Override
	public ArrayList<MemBoardDto> selectAll() {
		ArrayList<MemBoardDto> list = memBoardDao.selectAll();
		return list;
	}

	
}
