package com.teum.entity;

import java.util.Date;

public class Reservation {
	private int id;
	private int userId;
	private Date regdate;
	private Date cancelDate;
	private Date reviewRegdate;
	private int reviewScore;
	private int accId;
	
	public Reservation() {
		
	}
	
	public Reservation(int id, int userId, Date regdate, Date cancelDate, Date reviewRegdate, int reviewScore,
			int accId) {
		super();
		this.id = id;
		this.userId = userId;
		this.regdate = regdate;
		this.cancelDate = cancelDate;
		this.reviewRegdate = reviewRegdate;
		this.reviewScore = reviewScore;
		this.accId = accId;
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

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
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

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", userId=" + userId + ", regdate=" + regdate + ", cancelDate=" + cancelDate
				+ ", reviewRegdate=" + reviewRegdate + ", reviewScore=" + reviewScore + ", accId=" + accId + "]";
	}
	
	
}
