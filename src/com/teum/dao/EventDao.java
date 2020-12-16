package com.teum.dao;

import java.util.List;

import com.teum.dao.entity.EventListView;
import com.teum.entity.Event;

// SQL의 자바 함수화(정렬, 그룹핑, 필터링)
// 업무는 모른다.
public interface EventDao {

	int insert(Event event);
	int update(Event event);
	int delete(int id);
	
	Event get(int id);
	List<Event> getList(int startIndex, int endIndex, String search);
	List<Event> getList(int startIndex, int endIndex);
	List<Event> getList();
	
	List<EventListView> getViewList(int startIndex, int endIndex, String search);
	List<EventListView> getViewList(int startIndex, int endIndex);
	List<EventListView> getViewList();
	Event getLast();
	
	int openAll(String oIdsCSV, String cIdsCSV);
	int getCount(String search);
}
