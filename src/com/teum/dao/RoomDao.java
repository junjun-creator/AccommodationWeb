package com.teum.dao;

import java.util.List;

import com.teum.entity.Room;

public interface RoomDao {

	int insert(Room room);

	Room getLast();

	List<Room> getList(String accIdsCSV);

}
