package com.teum.dao.entity;

import com.teum.entity.Reservation;

public class ReservationForCompanyView extends Reservation{
	private String userName;
	private String accName;
	private int accTypeId;
	
	public ReservationForCompanyView() {
		super();
	}

	public ReservationForCompanyView(String userName, String accName, int accTypeId) {
		super();
		this.userName = userName;
		this.accName = accName;
		this.accTypeId = accTypeId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public int getAccTypeId() {
		return accTypeId;
	}

	public void setAccTypeId(int accTypeId2) {
		this.accTypeId = accTypeId2;
	}

	@Override
	public String toString() {
		return "ReservationForCompanyView [userName=" + userName + ", accName=" + accName + ", accTypeId=" + accTypeId
				+ "]";
	}

	
	
	
}
