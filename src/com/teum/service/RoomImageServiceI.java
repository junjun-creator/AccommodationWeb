package com.teum.service;

import java.util.List;

import com.teum.entity.RoomImage;

public interface RoomImageServiceI {

	List<RoomImage> get(String type, int roomId); 
	
}
