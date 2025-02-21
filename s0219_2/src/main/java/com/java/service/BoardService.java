package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BoardService {

	void bwrite(BoardDto bdto);

	ArrayList<BoardDto> blist();

	BoardDto bview(int bno);

}
