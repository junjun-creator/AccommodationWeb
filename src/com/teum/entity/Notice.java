package com.teum.entity;

import java.util.Date;

public class Notice {
	private int id;
    private String title;
    private int adminId;
    private String content;
    private Date regdate;
    private int openStatus;

    
    public Notice() {
    	
    }



	public Notice(int id, String title, int adminId, String content, Date regdate, int openStatus) {
		super();
		this.id = id;
		this.title = title;
		this.adminId = adminId;
		this.content = content;
		this.regdate = regdate;
		this.openStatus = openStatus;
	}



	public Notice(String title, String content, int adminId) {
		this.title = title;
		this.adminId = adminId;
		this.content = content;
		
	}



	public Notice(String title, String content, int adminId, int openStatus) {
		this.title = title;
		this.adminId = adminId;
		this.content = content;
		this.openStatus = openStatus;
	}



	public Notice(String title, String content) {
		this.title = title;
		this.content = content;
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



	public int getAdminId() {
		return adminId;
	}



	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public Date getRegdate() {
		return regdate;
	}



	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}



	public int getOpenStatus() {
		return openStatus;
	}



	public void setOpenStatus(int openStatus) {
		this.openStatus = openStatus;
	}



	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", adminId=" + adminId + ", content=" + content + ", regdate="
				+ regdate + ", openStatus=" + openStatus + "]";
	}




    
}
