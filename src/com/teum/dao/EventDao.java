package com.teum.dao;

import java.util.List;

import com.teum.dao.entity.EventView;
import com.teum.entity.Event;

// SQL의 자바 함수화(정렬, 그룹핑, 필터링)
// 업무는 모른다.
public interface EventDao {

	int insert(Event event);
	int update(Event event);
	int delete(int id);
	
	Event get(int id);
	List<Event> getList(int startIndex, int endIndex, String query);
	List<Event> getList(int startIndex, int endIndex);
	List<Event> getList();
	
	List<EventView> getViewList(int startIndex, int endIndex, String query);
	List<EventView> getViewList(int startIndex, int endIndex);
	List<EventView> getViewList();
}
