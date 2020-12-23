package com.teum.service;

import java.util.List;

import com.teum.dao.ReverseOfferDao;
import com.teum.dao.RoomImageDao;
import com.teum.dao.jdbc.JdbcReverseOfferDao;
import com.teum.entity.ReverseOffer;

public class ReverseOfferService {
	
	private ReverseOfferDao reverseOfferDao;
	
	public ReverseOfferService() {
		reverseOfferDao = new JdbcReverseOfferDao();
	}

	public List<Integer> getRoomIds(int id) {
		List<Integer> list = reverseOfferDao.getRoomIds(id);
		
		return list;
	}

	public int insert(ReverseOffer reverseOffer) {
		int result = reverseOfferDao.insert(reverseOffer);
		return result;
	}

	public List<ReverseOffer> getList(String offerIdsCSV) {
		return reverseOfferDao.getList(offerIdsCSV);
	}
	public int delete(int roomId) {
		int result = 0;
		result = reverseOfferDao.delete(roomId);
		return result;
		
	}




	
	
}
