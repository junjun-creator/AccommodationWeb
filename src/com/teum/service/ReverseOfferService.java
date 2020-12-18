package com.teum.service;

import com.teum.dao.ReverseOfferDao;
import com.teum.dao.jdbc.JdbcReverseOfferDao;

public class ReverseOfferService {
	
	private ReverseOfferDao reverseOfferDao;
	
	public ReverseOfferService() {
		reverseOfferDao = new JdbcReverseOfferDao();
	}
	
	
}
