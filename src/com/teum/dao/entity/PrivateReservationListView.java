package com.teum.dao.entity;

import java.util.Date;

public class PrivateReservationListView {
	private int rownum;
	private int userId;
	private String userName;
	private String userEmail;
	private String accName;
	private String phone;
	private Date checkinDate;
	private Date checkoutDate;
	
	public PrivateReservationListView() {
		
	}

	public PrivateReservationListView(int rownum, int userId, String userName, String userEmail, String accName,
			String phone, Date checkinDate, Date checkoutDate) {
		super();
		this.rownum = rownum;
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.accName = accName;
		this.phone = phone;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	@Override
	public String toString() {
		return "PrivateReservationListView [rownum=" + rownum + ", userId=" + userId + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", accName=" + accName + ", phone=" + phone + ", checkinDate="
				+ checkinDate + ", checkoutDate=" + checkoutDate + "]";
	}

	
}
