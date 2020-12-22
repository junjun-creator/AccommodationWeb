package com.teum.service;

import java.util.List;

import com.teum.dao.entity.OfferInfoView;
import com.teum.dao.entity.RoomImageListView;
import com.teum.entity.Acc;
import com.teum.entity.Room;

public interface RoomServiceI {

	List<RoomImageListView> getList(String accIdsCSV);
	
//	//미승인 숙소디테일 페이지(관리자)
//	public List<Room> getListByAdmin(int accId);
//	
//	//숙소디테일 페이지(유저)
//	public List<Room> getListByUser(int accId);
	List<OfferInfoView> getOfferInfoList(int page,int offerId);
	int getOfferCount(int offerId);
}
