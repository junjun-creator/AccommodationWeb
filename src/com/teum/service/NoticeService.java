package com.teum.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teum.dao.NoticeDao;
import com.teum.dao.jdbc.JdbcNoticeDao;
import com.teum.entity.Notice;


public class NoticeService {
	
	private NoticeDao noticeDao;
	
	public NoticeService() {
		noticeDao = new JdbcNoticeDao();
	}
	
	public List<Notice> getList() {
		
		return getList(1,"");
			
	}
	public List<Notice> getList(int page) {
		
		
		return  getList(page,"");
	}
	
	public List<Notice> getList(int page,String query) {
		List<Notice> list = new ArrayList<Notice>();
		
		int startIndex = 1+(page-1)*3;
		int endIndex = page*3;
		
		list= noticeDao.getList(startIndex,endIndex,query);
		return list;
	}
	
	public List<Notice> getUserList() {
		return noticeDao.getUserList();
		
	}
	
	public Notice get(int id) {
		
		return noticeDao.get(id);
	}
	public int insert(Notice notice) {
		int result =0;
		
		result = noticeDao.insert(notice);
		
		return result;
		
		
	}
	public int update(Notice notice) {
		int result =0;
		
		result = noticeDao.update(notice);
		return result;
		
		
	}
	public int delete(int id) {
		int result =0;
	
		result = noticeDao.delete(id);
		return result;
	}

	public int getLastId() {
		Notice n =noticeDao.getLast();
		
		return n.getId();
	}

	public int getCount() {
		
		return getCount("");
	}
	
	public int getCount(String query ) {
		int result = 0;
		
		result =noticeDao.getCount(query);
		
		return result;
	}

	
}
