package com.teum.service;

import java.util.List;

import com.teum.dao.EventDao;
import com.teum.dao.jdbc.JdbcEventDao;
import com.teum.entity.Event;
import com.teum.entity.Event;;

public class EventService {

	EventDao eventDao;
	
	public EventService() {
		eventDao = new JdbcEventDao();
	}
	
	public List<Event> getList() {
		eventDao = new JdbcEventDao();
		return null;
	}
	
	public Event get(int id) {
		eventDao = new JdbcEventDao();
		return null;
	}

	public int insert(Event event) {
		int result = 0;
		eventDao = new JdbcEventDao();
		return result;
	}

	public int update(Event event) {
		int result = 0;
		eventDao = new JdbcEventDao();
		return result;
	}
	
	public int delete(int id) {
		int result = 0;
		eventDao = new JdbcEventDao();
		return result;
	}
}
