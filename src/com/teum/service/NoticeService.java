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
import com.teum.dao.entity.NoticeView;
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
public List<NoticeView> getViewList() {
		
		return getViewList(1,"");
			
	}
	public List<NoticeView> getViewList(int page) {
		
		
		return  getViewList(page,"");
	}
	
	public List<NoticeView> getViewList(int page,String query) {
		List<NoticeView> list = new ArrayList<NoticeView>();
		
		int startIndex = 1+(page-1)*3;
		int endIndex = page*3;
		
		list= noticeDao.getViewList(startIndex,endIndex,query);
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
	
	public int deleteAll(int[] ids) {
		int result =0;
		for(Integer id : ids)
		result += noticeDao.delete(id);
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
	public int openAll(int[] oIds, int[] cIds) {
		List<String> oIdsList = new ArrayList<>();
		List<String> cIdsList = new ArrayList<>();
		
		for (int i = 0; i < oIds.length; i++)
			oIdsList.add(String.valueOf(oIds[i]));
		
		for (int i = 0; i < cIds.length; i++)
			cIdsList.add(String.valueOf(cIds[i]));
		
		return openAll(oIdsList, cIdsList);
	}
	
	public int openAll(List<String> oIds, List<String> cIds) {
		String oIdsCSV = String.join(",", oIds);
		String cIdsCSV = String.join(",", cIds);
		
		return openAll(oIdsCSV, cIdsCSV);
		
	}

	private int openAll(String oIdsCSV, String cIdsCSV) {
		return noticeDao.openAll(oIdsCSV, cIdsCSV);
	}

	public int closeAll(int[] oIds, int[] cIds) {
		List<String> oIdsList = new ArrayList<>();
		List<String> cIdsList = new ArrayList<>();
		
		for (int i = 0; i < oIds.length; i++)
			oIdsList.add(String.valueOf(oIds[i]));
		
		for (int i = 0; i < cIds.length; i++)
			cIdsList.add(String.valueOf(cIds[i]));
		
		return closeAll(oIdsList, cIdsList);
	}
	
	public int closeAll(List<String> oIds, List<String> cIds) {
		String oIdsCSV = String.join(",", oIds);
		String cIdsCSV = String.join(",", cIds);
		
		return closeAll(oIdsCSV, cIdsCSV);
	}

	private int closeAll(String oIdsCSV, String cIdsCSV) {
		return noticeDao.closeAll(oIdsCSV, cIdsCSV);
	}

	
}
