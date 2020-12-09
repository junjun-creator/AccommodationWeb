package com.teum.service;

import java.util.Date;
import java.util.List;

import com.teum.entity.Acc;
import com.teum.entity.AccImage;
import com.teum.entity.Room;
import com.teum.entity.RoomImage;

public interface AccServiceI {
	//숙소리스트 정보(관리자)
//	public List<Acc> getList();
//	public List<Acc> getList(String type, int page, String accType, String search);
	//숙소 승인(관리자)
	public int[] approvalAll(int[] ids);
	//숙소 삭제(관리자)
	public int[] deleteAll(int[] ids);
	
	//숙소디테일 페이지(관리자)
	public Acc get(int id);
//	public List<AccImage> getByAdmin(int accId);
//	public List<Room> getListByAdmin(int accId);
//	public List<RoomImage> getByAdmin(int roomId);
	//숙소디테일 삭제(관리자)
	public int delete(int id);
		
	//미승인 숙소리스트 정보(관리자)
//	public List<Acc> applyGetList();
	public List<Acc> applyGetList(int page, String type, String search);

	//미승인 숙소디테일 페이지(관리자)
	public Acc applyGet(int id);
//	public List<AccImage> getByAdmin(int accId);
//	public List<Room> getListByAdmin(int accId);
//	public List<RoomImage> getByAdmin(int roomId);
	
	//찜한상품조회
//	List<Acc> getList(int id, String type, int page);
	//List<AccImage> getList(int[] id);
	
	//등록된 숙소정보
	List<Acc> getList(int id, String type,int page, String accType, Date currentDate, String search);
	//List<AccImage> getList(int[] id);
	
	//골든타임 관리
//	List<Acc> getList(int id, Date currentDate);
	
	//재희 기능
//	public List<Acc> getList(int id);
		
	//숙소리스트 페이지(유저)
//	public List<Acc> getList();
	//public List<AccImage> getList(int accId);
}
