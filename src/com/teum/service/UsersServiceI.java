package com.teum.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teum.entity.Reservation;
import com.teum.entity.Users;

public interface UsersServiceI {
	//회원정보관리페이지 메인
	
	//회원정보수정 페이지(업체와 동일)
	int update(Users users);
	
	//회원가입
	int insert(Users users);
	
	//상세정보 페이지
	Users get(int id);
	int getCount();
	int getCount(String field, String query);
	ArrayList<Integer> getRankCount();
	
	
	// 관리자페이지
	//개인회원리스트
	List<Users> getList();
	List<Users> getList(String field, String query);
	List<Users> getList(int page);
	List<Users> getList(int page, String field, String query);//text 는 문자열로 검
	int delete(int[] id);
	int delete(int id);

	//예약관리 페이지(회원)
//	List<Reservation> getList(int id, String type);
//	List<Reservation> getList(String type, Date fromDate, Date toDate); // 기간별 내역 조회
	//List<AccImage> getList(int[] id);//숙소아이디
	
	//예약관리 페이지(업체)
//	List<Reservation> getList(int id,String type,String accType, int page, String keyword);//키워드는 검색
	
//	//제안 신청관리(회원)
//	List<Offer> getList(int id, String type);
//	int cancel(int id);
//	
//	//제안 신청관리(기업)
//	List<Offer> getList(int id, String type);
//	
//	//offer service
//	// 회원이 제안한 정보 
//	   public List<Offer> getListByUser(int id);
//	   
//	   // 기업이 역제안한 정보
//	   public List<Offer> getListByCompany(int id);
//	   
//	   public int insert(Offer offer);
//	   public int update(Offer offer);
	
//	//찜한상품조회
//	List<Acc> getList(int id, String type, int page);
//	//List<AccImage> getList(int[] id);
//	
//	//등록된 숙소정보
//	List<Acc> getList(int id, String type,int page, String category);
//	//List<AccImage> getList(int[] id);
//	
//	//골든타임 관리
//	List<Acc> getList(int id, Date currentDate);
	
	
	
	//기업회원리스트
//	List<Company> getList(int page, String text);//text 는 문자열로 검
//	int delete(int[] id);
	
}
