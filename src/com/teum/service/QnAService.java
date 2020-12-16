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
	
	public List<QnAView> getViewList(int page, int size, String category){
		int startIndex = 1 + (page-1)*size;
		int endIndex = page*size;
		
		return qnaDao.getViewList(startIndex,endIndex,category);
	}
	
	public List<QnAView> getViewList(int page, int size){
		int startIndex = 1 + (page-1)*size;
		int endIndex = page*size;
		
		return qnaDao.getViewList(startIndex,endIndex,"");
	}
	
	public List<QnAView> getViewList(){
		
		
		return qnaDao.getViewList(1,10,"");
	}
	
	
	public List<QnA> getList() {
		
		return qnaDao.getList();
		
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
}
