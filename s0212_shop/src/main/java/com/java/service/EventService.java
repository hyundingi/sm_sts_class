package com.java.service;

import java.util.ArrayList;

import com.java.dto.CboardDto;
import com.java.dto.EventDto;

public interface EventService {

	// 이벤트글 전체
	ArrayList<EventDto> event();

	// 이벤트글 상세
	EventDto eview(int eno);

	// 이벤트글 상세 > 댓글
	ArrayList<CboardDto> clist(int eno);

	CboardDto cwrite(CboardDto cdto);

}
