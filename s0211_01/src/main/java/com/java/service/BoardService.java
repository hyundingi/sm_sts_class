package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BoardService {

	ArrayList<BoardDto> blist(String category, String searchW);

}
