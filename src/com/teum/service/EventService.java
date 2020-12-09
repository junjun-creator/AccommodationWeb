package com.teum.service;

import java.util.List;

import com.teum.dao.EventDao;
import com.teum.dao.jdbc.JdbcEventDao;
import com.teum.entity.Event;;

public class EventService {

	EventDao eventDao;
	
	public EventService() {
		eventDao = new JdbcEventDao();
	}
	
	public List<Event> getList() {
		
	}
	
	public Event getNo(int id) {
		
	}

	public int insert(Event event) {
		
	}

	public int update(Event event) {
		
	}
	
	public int delete(int id) {
		
	}
}
