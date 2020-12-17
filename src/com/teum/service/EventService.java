package com.teum.service;

import java.util.ArrayList;
import java.util.List;

import com.teum.dao.EventDao;
import com.teum.dao.entity.EventListView;
import com.teum.dao.jdbc.JdbcEventDao;
import com.teum.entity.Event;;

public class EventService {

	EventDao eventDao;
	
	public EventService() {
		eventDao = new JdbcEventDao();
	}
	
	public List<Event> getList(int page, int size, String search) {
		int startIndex = 1 + (page - 1) * size; // 1,11,21,31,...
		int endIndex = page * size; 			// 10,20,30,40,...
		return eventDao.getList(startIndex, endIndex, search);
	}
	
	public List<Event> getList(int page, int size) {
		return eventDao.getList(page, size, "");
	}
	
	public List<Event> getList() {
		return eventDao.getList(1, 10, "");
	}
	
	public List<EventListView> getViewList(int page, int size, String search) {
		int startIndex = 1 + (page - 1) * size; // 1,11,21,31,...
		int endIndex = page * size; 			// 10,20,30,40,...
		return eventDao.getViewList(startIndex, endIndex, search);
	}
	
	public List<EventListView> getViewList(int page, int size) {
		int startIndex = 1 + (page - 1) * size; // 1,11,21,31,...
		int endIndex = page * size; 			// 10,20,30,40,...
		return eventDao.getViewList(startIndex, endIndex);
	}

	public List<EventListView> getViewList() {
		return eventDao.getViewList();
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
	
	public int openAll(int[] oIds, int[] cIds) {
		List<String> oIdsList = new ArrayList<>();
		List<String> cIdsList = new ArrayList<>();
		
		for (int i = 0; i < oIds.length; i++)
			oIdsList.add(String.valueOf(oIds[i]));
		
		for (int i = 0; i < cIds.length; i++)
			cIdsList.add(String.valueOf(cIds[i]));
		
		return openAll(oIdsList, cIdsList);
	}
	
	public int openAll(List<String> oIds, List<String> cIds) {
		String oIdsCSV = String.join(",", oIds);
		String cIdsCSV = String.join(",", cIds);
		
		return openAll(oIdsCSV, cIdsCSV);
	}
	
	public int openAll(String oIdsCSV, String cIdsCSV) {
		return eventDao.openAll(oIdsCSV, cIdsCSV);
	}

	public int getLastId() {
		Event event = eventDao.getLast();
		return event.getId();
	}

	public int getCount(String search) {
		return eventDao.getCount(search);
	}

	public int getCount() {
		return eventDao.getCount("");
	}

	public int getId() {
		return eventDao.getId();
	}

	
}
