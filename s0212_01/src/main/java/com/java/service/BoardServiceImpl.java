package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardDao;
import com.java.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired BoardDao boardDao;

	// 전체 리스트 가져오기
	@Override
	public ArrayList<BoardDto> blist() {
		ArrayList<BoardDto> list = boardDao.selectAll();
		return list;
	}

	// 글 쓰기
	@Override
	public void bwrite(BoardDto bdto) {
		boardDao.insertBoard(bdto);
	}

	// 한개 보기 페이지
	@Override
	public BoardDto bview(int bno) {
		BoardDto boardDto = boardDao.selectOne(bno);
		return boardDto;
	}

}
