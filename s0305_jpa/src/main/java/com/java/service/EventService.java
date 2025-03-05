package com.java.service;

import java.util.List;

import com.java.dto.EventDto;

public interface EventService {

	// 이벤트글 전체
	List<EventDto> findAll();

	EventDto findByEno(int eno);


	
}
