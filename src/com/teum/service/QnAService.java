package com.teum.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teum.dao.QnADao;
import com.teum.dao.entity.QnAView;
import com.teum.dao.jdbc.JdbcQnADao;
import com.teum.entity.QnA;

public class QnAService {
	
	private QnADao qnaDao;
	
	public QnAService() {
		
		qnaDao = new JdbcQnADao();
	}

	public List<QnAView> getVIewList(int page,int size,String category, String query) {
		
		List<QnAView> list = new ArrayList<QnAView>();
		
		int startIndex = 1 + (page-1)*size;
		int endIndex = page*size;
		list = qnaDao.getViewList(startIndex,endIndex,category,query);
		return list;
	}
	public List<QnAView> getViewList(int page,int size, String category){
		
		
		return qnaDao.getViewList(page, size, category,"");
	}
	
	public List<QnAView> getViewList(int page,int size){
		
		
		return qnaDao.getViewList(page,size,"","");
	}
	
	public List<QnAView> getViewList(){
		
		
		return qnaDao.getViewList(1, 3, "", "");
	}
	
	
	public List<QnA> getList(int id) {
		
		 List<QnA> list = new ArrayList<QnA>();
		 list = qnaDao.getList(id);
		return list;
		
	}

	public QnA get(int id) {
		
		return qnaDao.get(id);
	}
	public int delete(int id) {
		int result =0;
		
		result = qnaDao.delete(id);
		
		return result;
	}

	public int update(QnA qna) {
		int result =0;
		
		result = qnaDao.update(qna);
		
		return result;
	}

	public int getCount(String category, String query) {
		int result = 0;
		
		result = qnaDao.getCount(category,query);
		
		return result;
	}
	public int deleteAll(int[] ids) {
		int result =0;
		for(Integer id : ids)
		result += qnaDao.delete(id);
		return result;
	}

	public int insert(QnA qna) {
		int result =0;
		
		result = qnaDao.insert(qna);
		
		return result;
		
	}


	
}
