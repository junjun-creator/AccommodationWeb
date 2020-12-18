package com.teum.dao;

import java.util.List;

import com.teum.entity.Offer;

public interface OfferDao {

	int insert(Offer offer);

	List<Offer> getList(int id, int type);

}
