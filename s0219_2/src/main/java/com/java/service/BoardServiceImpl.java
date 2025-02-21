package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardDao;
import com.java.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired BoardDao boardDao;

	@Override
	public void bwrite(BoardDto bdto) {
		boardDao.insertBoard(bdto);
		
	}

	@Override
	public ArrayList<BoardDto> blist() {
		ArrayList<BoardDto> list = boardDao.selectAll();
		return list;
	}

	@Override
	public BoardDto bview(int bno) {
		BoardDto boardDto = boardDao.selectOne(bno);
		return boardDto;
	}

}
