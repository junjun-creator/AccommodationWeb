package com.teum.entity;

import java.util.Date;

public class Event {
	private int eventNo;
	private int status;
	private String title;
	private Date regDate;
	private Date startDate;
	private Date endDate;
	private int pub;
	
	public Event() {
		
	}

	public Event(int eventNo, int status, String title, Date regDate, Date startDate, Date endDate, int pub) {
		super();
		this.eventNo = eventNo;
		this.status = status;
		this.title = title;
		this.regDate = regDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pub = pub;
	}

	// insert, update용 생성자
	public Event(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Event [eventNo=" + eventNo + ", status=" + status + ", title=" + title + ", regDate=" + regDate
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", pub=" + pub + "]";
	}

	public int getEventNo() {
		return eventNo;
	}

	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
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

	public int getPub() {
		return pub;
	}

	public void setPub(int pub) {
		this.pub = pub;
	}

	
}
