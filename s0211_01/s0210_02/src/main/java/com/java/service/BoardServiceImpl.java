package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.BoardDao;
import com.java.dto.BoardDto;

@Transactional
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired BoardDao boardDao;
	int rowPerPage = 10; // 한페이지당 게시글 수 

	// 게시글 전체 가져오기
	@Override
	public Map<String, Object> blist(int page, String category, String searchW) {
		// 마지막 페이지 넘버링
		int maxPage = (int) Math.ceil((double)boardDao.countAll()/rowPerPage);
		// 첫번째 페이지 넘버링
		int startpage = (int)((page-1)/10)*10+1;
		// 마지막 번호 넘버링
		int endpage = startpage+10-1;
		if(endpage>maxPage) endpage = maxPage;
		
		// 요청 페이지별 검색 번호
		int startrow = (page-1)*rowPerPage+1;
		int endrow = startrow+rowPerPage-1;
		
		// 전체리스트 - 시작번호, 끝번호, 카테고리, 검색어
		ArrayList<BoardDto> list = boardDao.selectAll(startrow, endrow,category, searchW);
		
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);
		map.put("category", category);
		map.put("searchW", searchW);
		map.put("startpage", startpage);
		map.put("endpage", endpage);
		map.put("maxPage", maxPage);
		map.put("list", list);
		return map;
	}
	
	// 글쓰기 저장
	@Override
	public void bwrite(BoardDto bdto) {
		boardDao.bwrite(bdto);
		
	}
	
	// 게시글 1개 가져오기
	@Override
	public Map<String, Object> bview(int bno) {
		// 조회수 증가
		boardDao.updateBhit(bno);
		
		Map<String, Object> map = new HashMap<>();
		// 현재 게시글 정보
		BoardDto boardDto = boardDao.selectOne(bno);
		// 이전 게시글 정보
		BoardDto prevDto = boardDao.selectOnePrev(bno);
		// System.out.println("이전게시글 : "+prevDto.getBtitle());
		// 다음 게시글 정보
		BoardDto nextDto = boardDao.selectOneNext(bno);
		
		map.put("boardDto", boardDto);
		map.put("prevDto", prevDto);
		map.put("nextDto", nextDto);
		
		return map;
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
	
	// 글 수정 페이지
	@Override
	public BoardDto bmodify(int bno) {
		BoardDto boardDto = boardDao.selectOne(bno);
		return boardDto;
	}
	
	// 답변달기 페이지
	@Override
	public BoardDto breply(int bno) {
		BoardDto boardDto = boardDao.selectOne(bno);
		return boardDto;
	}

	// 답변전송
	@Override
	public void breply(BoardDto bdto) {
		// 그룹 넘버 같음. 스텝이 다름
		// 같은 그룹에서 부모보다 bstep이 높은 게시글을 모두 +1 
		boardDao.bstepUp(bdto);
		
		// 답변달기 저장
		boardDao.InsertBreply(bdto);
		
	}

}
