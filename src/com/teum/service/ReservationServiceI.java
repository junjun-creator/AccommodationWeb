package com.teum.service;

import java.util.Date;
import java.util.List;

import com.teum.dao.entity.ReservationListView;
import com.teum.entity.Reservation;

public interface ReservationServiceI {

	//예약관리 페이지(회원)
	List<ReservationListView> getListByUser(int page, int id);
	int getCount(int userId);
	
	//예약관리 페이지(업체)
	List<Reservation> getList(int id, int type, String accType, int page, String keyword);//키워드는 검색
}
