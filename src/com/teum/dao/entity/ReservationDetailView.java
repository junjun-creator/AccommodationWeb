package com.teum.dao.entity;

import java.util.Date;

public class ReservationDetailView {
	private int reservationId;
	private String accName;
	private String roomName;
	private Date checkinDate;
	private Date checkoutDate;
	private String userName;
	private int price;
	private String phone;
	private int cancelStatus;
	
	public ReservationDetailView() {
		
	}

	public ReservationDetailView(int reservationId, String accName, String roomName, Date checkinDate,
			Date checkoutDate, String userName, int price, String phone, int cancelStatus) {
		super();
		this.reservationId = reservationId;
		this.accName = accName;
		this.roomName = roomName;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
		this.userName = userName;
		this.price = price;
		this.phone = phone;
		this.cancelStatus = cancelStatus;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCancelStatus() {
		return cancelStatus;
	}

	public void setCancelStatus(int cancelStatus) {
		this.cancelStatus = cancelStatus;
	}

	@Override
	public String toString() {
		return "ReservationDetailView [reservationId=" + reservationId + ", accName=" + accName + ", roomName="
				+ roomName + ", checkinDate=" + checkinDate + ", checkoutDate=" + checkoutDate + ", userName="
				+ userName + ", price=" + price + ", phone=" + phone + ", cancelStatus=" + cancelStatus + "]";
	}

	
}
