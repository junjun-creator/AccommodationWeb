package com.teum.dao.entity;

import java.util.Date;

import com.teum.entity.QnA;

public class QnAView extends QnA {

	private String userName;
	private String phone;
	private String category;
	
	public QnAView() {
		
	}

	public QnAView(int id,String userName, String title, Date regdate, int answerStatus, String phone, String category) {
		super();
		this.userName=userName;
		this.phone = phone;
		this.category = category;
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



	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "QnAView [userName=" + userName + ", phone=" + phone + ", category=" + category + "]";
	}


	
}
