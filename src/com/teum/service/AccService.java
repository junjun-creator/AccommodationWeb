package com.teum.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teum.dao.AccDao;
import com.teum.dao.entity.AccListForAdminView;
import com.teum.dao.jdbc.DBContext;
//import com.teum.dao.jdbc.JdbcAccDao;
import com.teum.entity.Acc;


public class AccService {
	
	private AccDao accDao;
	public AccService() {
//		accDao = new JdbcAccDao();
	}
	
	public List<Acc> getList(int page, int size, String accType, String qeury) {
		
		int startIndex =1+(page-1)*size;//1, 11, 21, 31, ...
		int endIndex = page*10;//10,20,30,40,50,60... 
		
		return accDao.getList(startIndex, endIndex, accType, qeury);
	}
	public List<Acc> getList() {
		return accDao.getList(1,10,"","");
	}
	public List<AccListForAdminView> getViewList(int page, int size, String accType, String qeury) {
		
		int startIndex =1+(page-1)*size;//1, 11, 21, 31, ...
		int endIndex = page*10;//10,20,30,40,50,60... 
		
		return accDao.getViewList(startIndex, endIndex, accType, qeury);
	}
	

	public Acc get(int id) {
		return accDao.get(id);
	}

	public List<Acc> applyGetList(int page, int size, String accType, String qeury) {
		
		int startIndex =1+(page-1)*size;//1, 11, 21, 31, ...
		int endIndex = page*10;//10,20,30,40,50,60... 
		
		return accDao.applyGetList(startIndex, endIndex, accType, qeury);
	}
	public List<Acc> applyGetList() {
		return accDao.applyGetList(1,10,"","");
	}
	public Acc applyGet(int id) {
		return accDao.applyGet(id);
	}
	
	public int delete(int id) {
		int result=0;
		result = accDao.delete(id);
		
		return result;
	}
	//수정필요
	public int[] deleteAll(int[] ids) {
		
		int result =0;
		for(int i=0; i<ids.length; i++) {
			int id = ids[i];
			result+= accDao.delete(id);
		}
		return null;
	}
	public int approval(int id) {
		int result =0;
		Acc acc = accDao.applyGet(id);
		acc.setRegStatus(1);
		result = accDao.approval(id);
		return result;
	}
	public int[] approvalAll(int[] ids) {
		int result=0;
		for(int i=0; i<ids.length;i++) {
			int id=ids[i];
			result+= accDao.approval(id);
		}
		return null;
	}
}