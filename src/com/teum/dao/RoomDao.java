package com.teum.dao;

import com.teum.entity.Room;

public interface RoomDao {

	int insert(Room room);

	Room getLast();

}
