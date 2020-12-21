package com.teum.dao;

import java.util.List;

import com.teum.dao.entity.OfferInfoView;
import com.teum.dao.entity.OfferableRoomListView;
import com.teum.entity.Room;

public interface RoomDao {

	int insert(Room room);

	Room getLast();

	List<Room> getList(String accIdsCSV);

	List<OfferInfoView> getOfferInfoList(int startIndex,int endIndex,int offerId);

//	List<OfferableRoomListView> getOfferableRoomList(int startIndex, int endIndex, int offerId);
	List<OfferableRoomListView> getOfferableRoomList(int offerId);
	int getOfferCount(int offerId);

	int getId(int roomId);

	Room get(int roomId);

	List<Room> getList(int accId);

}
