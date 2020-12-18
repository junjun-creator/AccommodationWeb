package com.teum.service;

import java.util.List;

import com.teum.entity.Offer;

public interface OfferServiceI {
	List<Offer> getList(int id, int type);

	int cancel(int id);

	// offer service
//	// 회원이 제안한 정보(제안 id)
//	public List<Offer> getListByUser(int id);
//
//	// 기업이 역제안한 정보(역제안 id)
//	public List<Offer> getListByCompany(int id);

	public int insert(Offer offer);

	public int update(Offer offer);
	
}