package com.teum.dao.entity;

import java.util.Date;

import com.teum.entity.QnA;

public class QnAView extends QnA {

	private String userName;
	private String phone;
	private String categoryType;
	
	public QnAView() {
		
	}

	public QnAView(int id,String userName, String title, Date regdate, int answerStatus, String phone, String categoryType) {
		super();
		this.userName=userName;
		this.phone = phone;
		this.categoryType = categoryType;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getCategoryType() {
		return categoryType;
	}


	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}


	@Override
	public String toString() {
		return "QnAView [userName=" + userName + ", phone=" + phone + ", categoryType=" + categoryType + "]";
	}


	
}
