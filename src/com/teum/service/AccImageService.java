package com.teum.service;

import java.util.List;

import com.teum.dao.AccImageDao;
import com.teum.dao.jdbc.JdbcAccImageDao;
import com.teum.entity.AccImage;

public class AccImageService {

	AccImageDao accImageDao;
	
	public AccImageService() {
		accImageDao = new JdbcAccImageDao();
	}
	
	public int insert(AccImage accImage) {
		int result = 0;
		return accImageDao.insert(accImage);
	}

	public AccImage get(int accId) {
		return accImageDao.get(accId);
	}





}
