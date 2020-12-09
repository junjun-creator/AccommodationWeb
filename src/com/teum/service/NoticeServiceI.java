package com.teum.service;

import java.util.List;

import com.teum.entity.Notice;

public interface NoticeServiceI {

	List<Notice> getList(int id, String search);
	
	int openAll(int[] ids);
	
	int deleteAll(int[] ids);
	
	int update(int id);
	
	int delete(int id);
	
	int insert(Notice notice);
	
}
