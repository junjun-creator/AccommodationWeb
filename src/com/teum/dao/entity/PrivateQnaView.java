package com.teum.dao.entity;

import java.util.Date;

public class PrivateQnaView {
	private int rownum;
	private int qnaId;
	private String userName;
	private String title;
	private String phone;
	private Date regdate;
	private int answerStatus;
	
	public PrivateQnaView() {
		
	}

	public PrivateQnaView(int rownum, int qnaId, String userName, String title, String phone, Date regdate,
			int answerStatus) {
		super();
		this.rownum = rownum;
		this.qnaId = qnaId;
		this.userName = userName;
		this.title = title;
		this.phone = phone;
		this.regdate = regdate;
		this.answerStatus = answerStatus;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public int getQnaId() {
		return qnaId;
	}

	public void setQnaId(int qnaId) {
		this.qnaId = qnaId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getAnswerStatus() {
		return answerStatus;
	}

	public void setAnswerStatus(int answerStatus) {
		this.answerStatus = answerStatus;
	}

	@Override
	public String toString() {
		return "PrivateQnaView [rownum=" + rownum + ", qnaId=" + qnaId + ", userName=" + userName + ", title=" + title
				+ ", phone=" + phone + ", regdate=" + regdate + ", answerStatus=" + answerStatus + "]";
	}

	
	
}
