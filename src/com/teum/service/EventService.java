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
	
	public List<Event> getList(int page, int size, String query) {
		int startIndex = 1 + (page - 1) * size; // 1,11,21,31,...
		int endIndex = page * size; 			// 10,20,30,40,...
		return eventDao.getList(startIndex, endIndex, query);
	}
	
	public List<Event> getList(int page, int size) {
		return eventDao.getList(page, size, "");
	}
	
	public List<Event> getList() {
		return eventDao.getList(1, 10, "");
	}
	
	public Event get(int id) {
		return eventDao.get(id);
	}

	public int insert(Event event) {
		int result = eventDao.insert(event);
		return result;
	}

	public int update(Event event) {
		int result = eventDao.update(event);
		return result;
	}
	
	public int delete(int id) {
		int result = eventDao.delete(id);
		return result;
	}
	
	public int deleteAll(int[] ids) {
		int result = 0;
		
		for (Integer id : ids)
			result += eventDao.delete(id);
		
		return result;
	}
	
	public int open(int id) {
		return 0;
	}
	
	public int openAll(int[] ids) {
		return 0;
	}
}
