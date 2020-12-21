package com.teum.dao.entity;

import java.util.Date;

import com.teum.entity.Reservation;

public class ReviewView extends Reservation {

	private String userName;
	private String accName;
	public ReviewView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewView(int id, int userId, Date regdate, int cancelStatus, Date reviewRegdate, int reviewScore,
			int accId, int roomId, String reviewContent, Date checkinDate, Date checkoutDate, int price,
			int headcount,String userName,String accName) {
		super(id, userId, regdate, cancelStatus, reviewRegdate, reviewScore, accId, roomId, reviewContent, checkinDate,
				checkoutDate, price, headcount);
		
		this.accName=accName;
		this.userName=userName;
		
	}

	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "ReviewView [userName=" + userName + ", accName=" + accName + "]";
	}

	
	
	
}
