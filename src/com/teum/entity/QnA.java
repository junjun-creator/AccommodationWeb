package com.teum.entity;

import java.util.Date;

public class QnA {
	private int id;
	private String title;
	private String content;
	private Date regdate;
	private int categoryId;
	private int adminId;
	private int answerStatus;
	private int userId;
	private Date answerRegdate;
	private String answerContent;
	
	public QnA() {
		
	}

	public QnA(int id, String title, String content, Date regdate, int categoryId, int adminId, int answerStatus,
			int userId, Date answerRegdate, String answerContent) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.categoryId = categoryId;
		this.adminId = adminId;
		this.answerStatus = answerStatus;
		this.userId = userId;
		this.answerRegdate = answerRegdate;
		this.answerContent = answerContent;
	}

	public QnA(String title, String answerContent, int adminId, int answerStatus) {
		this.title = title;
		this.answerContent = answerContent;
		this.adminId = adminId;
		this.answerStatus = answerStatus;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public int getAnswerStatus() {
		return answerStatus;
	}

	public void setAnswerStatus(int answerStatus) {
		this.answerStatus = answerStatus;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getAnswerRegdate() {
		return answerRegdate;
	}

	public void setAnswerRegdate(Date answerRegdate) {
		this.answerRegdate = answerRegdate;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	@Override
	public String toString() {
		return "QnA [id=" + id + ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", categoryId="
				+ categoryId + ", adminId=" + adminId + ", answerStatus=" + answerStatus + ", userId=" + userId
				+ ", answerRegdate=" + answerRegdate + ", answerContent=" + answerContent + "]";
	}

	
	
}
