package com.teum.dao;

import java.util.List;

import com.teum.entity.Event;

public interface EventDao {

	int insert(Event event);
	int update(Event event);
	int delete(int id);
	
	Event get(int id);
	List<Event> getList();
}
