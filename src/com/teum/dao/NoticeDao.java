package com.teum.dao;

import java.util.List;

import com.teum.entity.Notice;

public interface NoticeDao {

	int insert(Notice notice);
	int update(Notice notice);
	int delete(int id);
	
	Notice get(int id);
	List<Notice> getList();
}
