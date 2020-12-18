package com.teum.service;

import com.teum.dao.OfferDao;
import com.teum.dao.jdbc.JdbcOfferDao;
import com.teum.entity.Offer;

public class OfferService {

	private OfferDao offerDao;
	
	public OfferService() {
		offerDao = new JdbcOfferDao();
	}
	
	public int insert(Offer offer) {
		int result = offerDao.insert(offer);
		return result;
	}

}
