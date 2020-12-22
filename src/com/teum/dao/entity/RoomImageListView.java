package com.teum.dao.entity;

import com.teum.entity.Room;

public class RoomImageListView extends Room {
	
	private String filename;
	private String fileroute;
	
	public RoomImageListView() {
		
	}
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFileroute() {
		return fileroute;
	}
	public void setFileroute(String fileroute) {
		this.fileroute = fileroute;
	}
	
	
}
