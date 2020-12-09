package com.teum.entity;

public interface EventDao {

	int insert(Event event);
	int update(Event event);
	int delete(int id);
	
	int get(int id);
	List<Event> getList();
}
