package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.EventDao;
import com.java.dto.CboardDto;
import com.java.dto.EventDto;

@Service
public class EventServiceImpl implements EventService {

	@Autowired EventDao eventDao;
	
	// 이벤트글 전체
	@Override
	public ArrayList<EventDto> event() {
		ArrayList<EventDto> list = eventDao.selectAll();
		return list;
	}

	// 이벤트글 상세
	@Override
	public EventDto eview(int eno) {
		EventDto eventDto = eventDao.selectOne(eno);
		return eventDto;
	}

	// 이벤트글 상세 > 댓글
	@Override
	public ArrayList<CboardDto> clist(int eno) {
		ArrayList<CboardDto> clist = eventDao.selectAllCboard(eno);
		return clist;
	}

	@Override
	public CboardDto cwrite(CboardDto cdto) {
		eventDao.insertCboard(cdto);
		CboardDto cboardDto = eventDao.selectOneCboard(cdto.getCno());
		return cboardDto;
	}

}
