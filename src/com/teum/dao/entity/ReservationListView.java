package com.teum.dao.entity;

import java.util.Date;

public class ReservationListView {
	private int id;
	private int userId;
	private int accId;
	private int roomId;
	private int price;
	private Date checkinDate;
	private Date checkoutDate;
	private String accName;
	private String fileName;
	
	public ReservationListView() {
		
	}

	public ReservationListView(int id, int userId, int accId, int roomId, int price, Date checkinDate,
			Date checkoutDate, String accName, String fileName) {
		super();
		this.id = id;
		this.userId = userId;
		this.accId = accId;
		this.roomId = roomId;
		this.price = price;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
		this.accName = accName;
		this.fileName = fileName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "ReservationListView [id=" + id + ", userId=" + userId + ", accId=" + accId + ", roomId=" + roomId
				+ ", price=" + price + ", checkinDate=" + checkinDate + ", checkoutDate=" + checkoutDate + ", accName="
				+ accName + ", fileName=" + fileName + "]";
	}
	
	
}
