package com.teum.service;

import java.util.List;

import com.teum.dao.OfferDao;
import com.teum.dao.jdbc.JdbcOfferDao;
import com.teum.entity.Offer;

public class OfferService implements OfferServiceI{

	private OfferDao offerDao;
	
	public OfferService() {
		offerDao = new JdbcOfferDao();
	}
	
	@Override
	public int insert(Offer offer) {
		int result = offerDao.insert(offer);
		return result;
	}

	@Override
	public List<Offer> getList(int id, int type) {
		List<Offer> list = offerDao.getList(id,type);
		
		return list;
	}

	@Override
	public int cancel(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Offer offer) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Offer> getList(String accIdsCSV) {
		return offerDao.getList(accIdsCSV);
	}

	public int getId(int accId) {
		return offerDao.getId(accId);
	}

	public List<Integer> getIds(String accIdsCSV) {
		return offerDao.getIds(accIdsCSV);
	}

	public List<Offer> getListByOfferIds(String finalOfferIdsCSV) {
		return offerDao.getListByOfferIds(finalOfferIdsCSV);
	}

	public int delete(int accId) {
		int result = 0;
		
		result = offerDao.delete(accId);
		
		return result;
	}

}
