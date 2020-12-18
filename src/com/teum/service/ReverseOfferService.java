package com.teum.service;

import java.util.List;

import com.teum.dao.ReverseOfferDao;
import com.teum.dao.jdbc.JdbcReverseOfferDao;

public class ReverseOfferService {
	
	private ReverseOfferDao reverseOfferDao;
	
	public ReverseOfferService() {
		reverseOfferDao = new JdbcReverseOfferDao();
	}

	public List<Integer> getRoomIds(int id) {
		List<Integer> list = reverseOfferDao.getRoomIds(id);
		
		return list;
	}
	
	
}
