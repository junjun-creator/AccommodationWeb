package com.teum.service;

import java.util.List;

public interface ReverseOfferServiceI {
	
	// 제안 아이디로 역제안 정보 갖고오기
	List<ReverseOffer> getList(int id);
}
