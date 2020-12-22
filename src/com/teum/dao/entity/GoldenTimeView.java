package com.teum.dao.entity;

import java.util.Date;

import com.teum.entity.Acc;

public class GoldenTimeView extends Acc {
	private String fileroute;
	private String userName;
	private String type;
	private String timeRemain;
	private int accId;
	public GoldenTimeView() {
		
	}

	public GoldenTimeView(int id, String name, String phone, String location, int regStatus, Date approvalDate,
			int adminId, int companyId, Date regdate, int accTypeId, Date gtStartDate, Date gtEndDate, int saleprice,
			int goldentimeStatus, String fileroute, String userName,String type,String timeRemain,int accId) {
		super(id, name, phone, location, regStatus, approvalDate, adminId, companyId, regdate, accTypeId, gtStartDate,
				gtEndDate, saleprice, goldentimeStatus);
		this.accId=accId;
		this.fileroute=fileroute;
		this.userName=userName;
		this.type=type;
		this.timeRemain=timeRemain;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public String getTimeRemain() {
		return timeRemain;
	}

	public void setTimeRemain(String timeRemain) {
		this.timeRemain = timeRemain;
	}

	public String getFileroute() {
		return fileroute;
	}

	public void setFileroute(String fileroute) {
		this.fileroute = fileroute;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "GoldenTimeView [fileroute=" + fileroute + ", userName=" + userName + ", type=" + type + ", timeRemain="
				+ timeRemain + ", accId=" + accId + "]";
	}



	
	
}
