package com.teum.entity;

import java.util.Date;

public class Offer {
	private int id;
	private int accId;
	private int userId;
	private int price;
	private String location;
	private Date checkinDate;
	private Date checkoutDate;
	private Date regdate;
	private int headcount;
	private Date rejectDate;
	
	public Offer() {
		
	}

	public Offer(int id, int accId, int userId, int price, String location, Date checkinDate, Date checkoutDate,
			Date regdate, int headcount, Date rejectDate) {
		super();
		this.id = id;
		this.accId = accId;
		this.userId = userId;
		this.price = price;
		this.location = location;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
		this.regdate = regdate;
		this.headcount = headcount;
		this.rejectDate = rejectDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getHeadcount() {
		return headcount;
	}

	public void setHeadcount(int headcount) {
		this.headcount = headcount;
	}

	public Date getRejectDate() {
		return rejectDate;
	}

	public void setRejectDate(Date rejectDate) {
		this.rejectDate = rejectDate;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", accId=" + accId + ", userId=" + userId + ", price=" + price + ", location="
				+ location + ", checkinDate=" + checkinDate + ", checkoutDate=" + checkoutDate + ", regdate=" + regdate
				+ ", headcount=" + headcount + ", rejectDate=" + rejectDate + "]";
	}

	
}
