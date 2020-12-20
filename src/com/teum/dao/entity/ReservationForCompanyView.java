package com.teum.dao.entity;

import com.teum.entity.Reservation;

public class ReservationForCompanyView extends Reservation{
	private String userName;
	private String accName;
	private int accTypeId;
	private int rownum;
	
	public ReservationForCompanyView() {
		super();
	}

	public ReservationForCompanyView(String userName, String accName, int accTypeId, int rownum) {
		super();
		this.userName = userName;
		this.accName = accName;
		this.accTypeId = accTypeId;
		this.rownum = rownum;
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

	public void setAccTypeId(int accTypeId) {
		this.accTypeId = accTypeId;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	@Override
	public String toString() {
		return "ReservationForCompanyView [userName=" + userName + ", accName=" + accName + ", accTypeId=" + accTypeId
				+ ", rownum=" + rownum + ", toString()=" + super.toString() + "]";
	}

	

	
	
	
}
