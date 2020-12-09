package com.teum.entity;

import java.util.Date;

public class Offer {
	private int id;
	private int companyId;
	private int userId;
	private int price;
	private String location;
	private Date checkinDate;
	private Date checkoutDate;
	private Date regdate;
	private int headcount;
	private Date approvalDate;
	private Date rejectDate;
	
	public Offer() {
		
	}
	
	public Offer(int id, int companyId, int userId, int price, String location, Date checkinDate, Date checkoutDate,
			Date regdate, int headcount, Date approvalDate, Date rejectDate) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.userId = userId;
		this.price = price;
		this.location = location;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
		this.regdate = regdate;
		this.headcount = headcount;
		this.approvalDate = approvalDate;
		this.rejectDate = rejectDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
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

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public Date getRejectDate() {
		return rejectDate;
	}

	public void setRejectDate(Date rejectDate) {
		this.rejectDate = rejectDate;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", companyId=" + companyId + ", userId=" + userId + ", price=" + price
				+ ", location=" + location + ", checkinDate=" + checkinDate + ", checkoutDate=" + checkoutDate
				+ ", regdate=" + regdate + ", headcount=" + headcount + ", approvalDate=" + approvalDate
				+ ", rejectDate=" + rejectDate + "]";
	}
	
	
	
}
