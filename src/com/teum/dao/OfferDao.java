package com.teum.dao;

import java.util.List;

import com.teum.entity.Offer;

public interface OfferDao {

	int insert(Offer offer);

	List<Offer> getList(int id, int type);

	List<Offer> getList(String accIdsCSV);

	int getId(int accId);

	List<Integer> getIds(String accIdsCSV);

	List<Offer> getListByOfferIds(String finalOfferIdsCSV);

}
