package com.teum.dao;

import java.util.List;

import com.teum.entity.Event2;

public interface EventDao {

	int insert(Event2 event);
	int update(Event2 event);
	int delete(int id);
	
	Event2 get(int id);
	List<Event2> getList();
}
