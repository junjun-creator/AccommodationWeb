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
import com.teum.dao.jdbc.JdbcQnADao;
import com.teum.entity.QnA;

public class QnAService {
	
	private QnADao qnaDao;
	
	public QnAService() {
		
		qnaDao = new JdbcQnADao();
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
}
