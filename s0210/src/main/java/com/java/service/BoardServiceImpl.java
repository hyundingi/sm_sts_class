package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardDao;
import com.java.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardDao boardDao;
	
	@Override //게시글 전체 리스트
	public ArrayList<BoardDto> blist() {
		ArrayList<BoardDto> list = boardDao.selectAll();
		return list;
	}

	@Override
	public void boardWrite(BoardDto bdto) {
		boardDao.boardWrite(bdto);
		
	}

}
