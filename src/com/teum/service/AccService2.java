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
import com.teum.dao.jdbc.DBContext;
import com.teum.entity.Acc;


public class AccService2 {

	public AccDao accDao;
	
	public List<Acc> getList() {
		
		return accDao.getList();
	}

	public Acc get(int id) {
		
		return accDao.get(id);
	}

	public List<Acc> applyGetList() {
		
		return accDao.applyGetList();
	}

	public Acc applyGet(int id) {
		
		return accDao.applyGet(id);
	}
}
