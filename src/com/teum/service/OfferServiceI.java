package com.teum.service;

import java.util.List;

public class OfferServiceI {
	//제안 신청관리(회원)
		List<Offer> getList(int id, String type);
		int cancel(int id);
		
		//제안 신청관리(기업)
		List<Offer> getList(int id, String type);
		
		//offer service
		// 회원이 제안한 정보 
		   public List<Offer> getListByUser(int id);
		   
		   // 기업이 역제안한 정보
		   public List<Offer> getListByCompany(int id);
		   
		   public int insert(Offer offer);
		   public int update(Offer offer);
}
