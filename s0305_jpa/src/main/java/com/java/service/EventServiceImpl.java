package com.java.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.CboardDto;
import com.java.dto.EventDto;
import com.java.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

	@Autowired EventRepository eventRepository;
	
	// 이벤트글 전체
	@Override
	public List<EventDto> findAll() {
		List<EventDto> list = eventRepository.findAll();
		return list;
	}

	@Override
	public EventDto findByEno(int eno) {
		EventDto eventDto = eventRepository.findByEno(eno);
		return eventDto;
	}

	

}
