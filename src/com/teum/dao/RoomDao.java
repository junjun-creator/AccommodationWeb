package com.teum.dao;

import java.util.List;

import com.teum.dao.entity.OfferInfoView;
import com.teum.dao.entity.OfferableRoomListView;
import com.teum.dao.entity.PayInfoView;
import com.teum.dao.entity.ReverseListView;
import com.teum.dao.entity.RoomImageListView;
import com.teum.entity.Room;

public interface RoomDao {

	int insert(Room room);

	Room getLast();

	List<RoomImageListView> getList(String accIdsCSV);

	List<OfferInfoView> getOfferInfoList(int startIndex,int endIndex,int offerId);

	List<OfferableRoomListView> getOfferableRoomList(int startIndex, int endIndex, int offerId);
//	List<OfferableRoomListView> getOfferableRoomList(int offerId);
	int getOfferCount(int offerId);

	int getId(int roomId);

	ReverseListView get(int roomId);

	PayInfoView getList(int accId, int roomId);

	int update(int accId, int roomId, String bookedDates);

	List<RoomImageListView> getViewList(int accId);

	Room getRoom(int roomId);

	int update(int roomId, String newBookedDatesString);

	
	/*골든타임 가격불러오기용*/
	List<Room> getPriceList(int chk);

	int updatePrice(Room room);

	List<ReverseListView> getReversedRoomList(int startIndex, int endIndex, int offerId);

	int getPrice(int id);
}
