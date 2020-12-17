package com.teum.service;

import com.teum.dao.RoomImageDao;
import com.teum.dao.jdbc.JdbcRoomImageDao;
import com.teum.entity.RoomImage;

public class RoomImageService {

	private RoomImageDao roomImageDao;
	
	public RoomImageService() {
		roomImageDao = new JdbcRoomImageDao();
	}
	
	public int insert(RoomImage roomImage) {
		return roomImageDao.insert(roomImage); 
	}

}
