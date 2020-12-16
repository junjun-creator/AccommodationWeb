package com.teum.entity;

import java.util.Date;

public class Event {
	private int id;
	private String title;
	private int openStatus;
	private String imageName;
	private String imageRoute;
	private int status;
	private Date startDate;
	private Date endDate;
	private Date regdate;
	private int adminId;
	
	public Event(int id, String title, int openStatus, String imageName, String imageRoute, int status, Date startDate,
			Date endDate, Date regdate, int adminId) {
		super();
		this.id = id;
		this.title = title;
		this.openStatus = openStatus;
		this.imageName = imageName;
		this.imageRoute = imageRoute;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.regdate = regdate;
		this.adminId = adminId;
	}

	public Event() {
	}

	// insert용 생성자
	public Event(String title, int openStatus, Date startDate, Date endDate, String imageName, String imageRoute) {
		this.title = title;
		this.openStatus = openStatus;
		this.startDate = startDate;
		this.endDate = endDate;
		this.imageName = imageName;
		this.imageRoute = imageRoute;
	}
	
	// update용 생성자
	public Event(int id, String title, int openStatus, Date startDate, Date endDate, String imageName, String imageRoute) {
		this.id = id;
		this.title = title;
		this.openStatus = openStatus;
		this.startDate = startDate;
		this.endDate = endDate;
		this.imageName = imageName;
		this.imageRoute = imageRoute;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", openStatus=" + openStatus + ", imageName=" + imageName
				+ ", imageRoute=" + imageRoute + ", status=" + status + ", startDate=" + startDate + ", endDate="
				+ endDate + ", regdate=" + regdate + ", adminId=" + adminId + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getOpenStatus() {
		return openStatus;
	}

	public void setOpenStatus(int openStatus) {
		this.openStatus = openStatus;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageRoute() {
		return imageRoute;
	}

	public void setImageRoute(String imageRoute) {
		this.imageRoute = imageRoute;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	

	
}
