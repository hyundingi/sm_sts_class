package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.BoardDto;
import com.java.repository.BoardRepository;

@Transactional
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardRepository boardRepository;
	
	@Override
	public Page<BoardDto> findAll(Pageable pageable) {
		// sort 다중정렬을 사용해서 검색
//		Sort sort = Sort.by(
//				Sort.Order.desc("bgroup"),
//				Sort.Order.asc("bstep")
//				);
//		List<BoardDto> list = boardRepository.findAll(sort);
		
		// nativeQuery
		Page<BoardDto> list = boardRepository.findAll(pageable);
		return list;
	}

	@Override
	public BoardDto findById(int bno) {
		BoardDto boardDto = boardRepository.findById(bno).orElseThrow(
				()->{ // 람다식
					return new IllegalArgumentException("데이터 처리 시 에러.");
				});
		boardDto.setBhit(boardDto.getBhit()+1); // 게시글 조회수가 1 증가
		// boardRepository.save(boardDto); - 트렌직션 때문에 따로 안 해도 저장됨
		
		return boardDto;
	}

	@Override
	public List<BoardDto> findByBtitleContaining(String search) {
		List<BoardDto> list = boardRepository.findByBtitleContaining(search);
		return list;
	}

}
