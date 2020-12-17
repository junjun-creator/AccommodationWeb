package com.teum.dao;

import java.util.List;

import com.teum.dao.entity.NoticeView;
import com.teum.entity.Notice;

public interface NoticeDao {

	int insert(Notice notice);
	int update(Notice notice);
	int delete(int id);
	
	Notice get(int id);
	Notice getLast();

	int getCount(String query);
	int openAll(String oIdsCSV, String cIdsCSV);
	int closeAll(String oIdsCSV, String cIdsCSV);
	
	List<Notice> getList();
	List<Notice> getList(int startIndex, int endIndex);
	List<Notice> getList(int startIndex, int endIndex, String query);
	
	List<Notice> getUserList();
	List<NoticeView> getViewList();
	List<NoticeView> getViewList(int startIndex,  int endIndex);
	List<NoticeView> getViewList(int startIndex, int endIndex, String query);
}
