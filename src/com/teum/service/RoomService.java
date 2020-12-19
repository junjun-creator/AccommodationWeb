package com.teum.service;

import java.util.List;

import com.teum.dao.RoomDao;
import com.teum.dao.entity.OfferInfoView;
import com.teum.dao.jdbc.JdbcRoomDao;
import com.teum.entity.Room;

public class RoomService implements RoomServiceI{
	
	private RoomDao roomDao;
	
	public RoomService() {
		roomDao = new JdbcRoomDao();
	}
	
	public int insert(Room room) {
		int result = roomDao.insert(room);
		return result;
	}

	public int getLastId() {
		Room room = roomDao.getLast();
		return room.getId();
	}
	@Override
	public List<Room> getList(String accIdsCSV) {
		return roomDao.getList(accIdsCSV);
	}
	
	@Override
	public List<OfferInfoView> getOfferInfoList(int page,int offerId) {
		int startIndex = 1+(page-1)*3;
		int endIndex = page*3;
		return roomDao.getOfferInfoList(startIndex,endIndex,offerId);
	}
}
