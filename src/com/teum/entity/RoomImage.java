package com.teum.entity;

public class RoomImage {
	private int id;
	private String filename;
	private String fileroute;
	private int roomId;
	
	public RoomImage() {
		
	}

	public RoomImage(int id, String filename, String fileroute, int roomId) {
		super();
		this.id = id;
		this.filename = filename;
		this.fileroute = fileroute;
		this.roomId = roomId;
	}

	public RoomImage(String filename, String fileroute, int roomId) {
		this.filename = filename;
		this.fileroute = fileroute;
		this.roomId = roomId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	@Override
	public String toString() {
		return "RoomImage [id=" + id + ", filename=" + filename + ", fileroute=" + fileroute + ", roomId=" + roomId
				+ "]";
	}
	
}
