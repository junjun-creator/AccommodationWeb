package com.teum.dao.entity;

import java.util.Date;

import com.teum.entity.Room;

public class OfferableRoomListView extends Room {

	private int roomImageId;
	private String fileName;
	private String fileRoute;
	private Date checkinDate;
	private Date checkoutDate;
	
	public OfferableRoomListView() {
	}

	public int getRoomImageId() {
		return roomImageId;
	}

	public void setRoomImageId(int roomImageId) {
		this.roomImageId = roomImageId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileRoute() {
		return fileRoute;
	}

	public void setFileRoute(String fileRoute) {
		this.fileRoute = fileRoute;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	
	
	
	
}
