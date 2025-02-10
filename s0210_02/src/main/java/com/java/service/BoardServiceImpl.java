package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardDao;
import com.java.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired BoardDao boardDao;

	// 게시글 전체 가져오기
	@Override
	public ArrayList<BoardDto> blist() {
		ArrayList<BoardDto> list = boardDao.selectAll();
		
		return list;
	}
	
	// 글쓰기 저장
	@Override
	public void bwrite(BoardDto bdto) {
		boardDao.bwrite(bdto);
		
	}
	
	// 게시글 1개 가져오기
	@Override
	public BoardDto bview(int bno) {
		// 조회수 증가
		boardDao.updateBhit(bno);
		
		BoardDto boardDto = boardDao.selectOne(bno);
		
		return boardDto;
	}
	
	// 게시글 삭제
	@Override
	public void bdelete(int bno) {
		boardDao.deleteBoard(bno);
		
	}

	// 게시글 수정
	@Override
	public void bmodify(BoardDto modib) {
		boardDao.boardmodify(modib);
		
	}

}
