package com.teum.service;

import java.util.Date;
import java.util.List;

import com.teum.entity.Reservation;

public interface ReservationServiceI {

	//예약관리 페이지(회원)
	List<Reservation> getList(int id, String type);
	List<Reservation> getList(String type, Date fromDate, Date toDate); // 기간별 내역 조회
	
	//예약관리 페이지(업체)
	List<Reservation> getList(int id, String type, String accType, int page, String keyword);//키워드는 검색
}
