package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.CustomerDao;
import com.java.dto.BoardDto;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired CustomerDao customerDao;
	

	// 게시글 뷰페이지
	@Override
	public Map<String, Object> nview(int bno) {
		Map<String, Object> map = new HashMap<>();
		// 현재 게시글 정보
		BoardDto boardDto = customerDao.selectOne(bno);
		// 다음글
		BoardDto prevDto = customerDao.selectPrev(bno);
		// 이전글
		BoardDto nextDto = customerDao.selectNext(bno);
		
		map.put("boardDto", boardDto);
		map.put("prevDto", prevDto);
		map.put("nextDto", nextDto);
		
		return map;
	}
	
	// 게시글 전체 리스트
	@Override
	public Map<String, Object> notice(String category, String searchW) {
		
		// 전체 게시글 리스트
		ArrayList<BoardDto> list = customerDao.selectAll(category, searchW);
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("category", category);
		map.put("searchW", searchW);
		System.out.println("서비스에서 찍용"+category);
		System.out.println("서비스에서 찍용"+searchW);
		
		return map;
	}

}
