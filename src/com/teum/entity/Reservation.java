package com.teum.entity;

import java.util.Date;

public class Reservation {
	private int id;
	private int userId;
	private Date regdate;
	private int cancelStatus;
	private Date reviewRegdate;
	private int reviewScore;
	private int accId;
	private int roomId;
	private String reviewContent;
	private Date checkinDate;
	private Date checkoutDate;
	private int price;
	
	public Reservation() {
		
	}

	public Reservation(int id, int userId, Date regdate, int cancelStatus, Date reviewRegdate, int reviewScore,
			int accId, int roomId, String reviewContent, Date checkinDate, Date checkoutDate, int price) {
		super();
		this.id = id;
		this.userId = userId;
		this.regdate = regdate;
		this.cancelStatus = cancelStatus;
		this.reviewRegdate = reviewRegdate;
		this.reviewScore = reviewScore;
		this.accId = accId;
		this.roomId = roomId;
		this.reviewContent = reviewContent;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
		this.price = price;
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getCancelStatus() {
		return cancelStatus;
	}

	public void setCancelStatus(int cancelStatus) {
		this.cancelStatus = cancelStatus;
	}

	public Date getReviewRegdate() {
		return reviewRegdate;
	}

	public void setReviewRegdate(Date reviewRegdate) {
		this.reviewRegdate = reviewRegdate;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
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

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", userId=" + userId + ", regdate=" + regdate + ", cancelStatus="
				+ cancelStatus + ", reviewRegdate=" + reviewRegdate + ", reviewScore=" + reviewScore + ", accId="
				+ accId + ", roomId=" + roomId + ", reviewContent=" + reviewContent + ", checkinDate=" + checkinDate
				+ ", checkoutDate=" + checkoutDate + ", price=" + price + "]";
	}
	
	
	
}
