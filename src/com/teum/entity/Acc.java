package com.teum.entity;

import java.util.Date;

public class Acc {

	 private int id;
	 private String accName;
	 private String location;
	 private Date regdate;
	 private String phone;
	 private String email;
	 private int accTypeId;
	 private int regStatus;
	 private Date approvalDate;
	 private int adiminId;
	 private int companyId;
	 
	


	public Acc(int id, String accName, String location, Date regdate, String phone, String email, int accTypeId,
			int regStatus, Date approvalDate, int adiminId, int companyId) {
		super();
		this.id = id;
		this.accName = accName;
		this.location = location;
		this.regdate = regdate;
		this.phone = phone;
		this.email = email;
		this.accTypeId = accTypeId;
		this.regStatus = regStatus;
		this.approvalDate = approvalDate;
		this.adiminId = adiminId;
		this.companyId = companyId;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAccTypeId() {
		return accTypeId;
	}

	public void setAccTypeId(int accTypeId) {
		this.accTypeId = accTypeId;
	}

	public int getRegstatus() {
		return regStatus;
	}

	public void setRegstatus(int regStatus) {
		this.regStatus = regStatus;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	 
	 
	 
}
