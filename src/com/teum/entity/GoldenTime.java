package com.teum.entity;

import java.util.Date;

public class GoldenTime {
	private int id;
	private Date regdate;
	private int price;
	private Date startDate;
	private Date endDate;
	private int accId;
	
	
	public GoldenTime() {
		
	}


	public GoldenTime(int id, Date regdate, int price, Date startDate, Date endDate, int accId) {
		super();
		this.id = id;
		this.regdate = regdate;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.accId = accId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public int getAccId() {
		return accId;
	}


	public void setAccId(int accId) {
		this.accId = accId;
	}


	@Override
	public String toString() {
		return "GoldenTime [id=" + id + ", regdate=" + regdate + ", price=" + price + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", accId=" + accId + "]";
	}

	
}
