package com.teum.service;

import java.util.List;

import com.teum.entity.Event;

public interface EventServiceI {
	public List<Event> getList();
	public List<Event> getList(int page);
	public List<Event> getList(String search);
	
	public List<Event> getList(int page, String search);
	
	public Event getPrev(int id);
	public Event getNext(int id);
	
	public int openAll(int[] ids);
	public int deleteAll(int[] ids);
	
	public int insert(Event event);
	public int update(Event event);
	public int delete(int id);
}
