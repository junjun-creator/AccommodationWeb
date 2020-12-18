package com.teum.entity;

import java.util.Date;

public class Acc {

	 private int id;
	 private String name;
	 private String phone;
	 private String location;
	 private int regStatus;
	 private Date approvalDate;
	 private int adminId;
	 private int companyId;
	 private Date regdate;
	 private int accTypeId;
	 private Date gtStartDate;
	 private Date gtEndDate;
	 private int saleprice;
	 private int goldentimeStatus;
	 
	public Acc() {
		
	}

	public Acc(int id, String name, String phone, String location, int regStatus, Date approvalDate,
			int adminId, int companyId, Date regdate, int accTypeId, Date gtStartDate, Date gtEndDate, int saleprice,
			int goldentimeStatus) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.location = location;
		this.regStatus = regStatus;
		this.approvalDate = approvalDate;
		this.adminId = adminId;
		this.companyId = companyId;
		this.regdate = regdate;
		this.accTypeId = accTypeId;
		this.gtStartDate = gtStartDate;
		this.gtEndDate = gtEndDate;
		this.saleprice = saleprice;
		this.goldentimeStatus = goldentimeStatus;
	}


	public Acc(int chk, Date startDate, Date endDate, int saleprice) {
		this.id = chk;
		this.gtStartDate = startDate;
		this.gtEndDate = endDate;
		this.saleprice = saleprice;
	}

	public Acc(int chk, int status) {
		this.id = chk;
		this.goldentimeStatus = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getRegStatus() {
		return regStatus;
	}

	public void setRegStatus(int regStatus) {
		this.regStatus = regStatus;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adiminId) {
		this.adminId = adiminId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getAccTypeId() {
		return accTypeId;
	}

	public void setAccTypeId(int accTypeId) {
		this.accTypeId = accTypeId;
	}

	public Date getGtStartDate() {
		return gtStartDate;
	}

	public void setGtStartDate(Date gtStartDate) {
		this.gtStartDate = gtStartDate;
	}

	public Date getGtEndDate() {
		return gtEndDate;
	}

	public void setGtEndDate(Date gtEndDate) {
		this.gtEndDate = gtEndDate;
	}

	public int getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}

	public int getGoldentimeStatus() {
		return goldentimeStatus;
	}

	public void setGoldentimeStatus(int goldentimeStatus) {
		this.goldentimeStatus = goldentimeStatus;
	}

	@Override
	public String toString() {
		return "Acc [id=" + id + ", name=" + name + ", phone=" + phone + ", location=" + location + ", regStatus="
				+ regStatus + ", approvalDate=" + approvalDate + ", adminId=" + adminId + ", companyId=" + companyId
				+ ", regdate=" + regdate + ", accTypeId=" + accTypeId + ", gtStartDate=" + gtStartDate + ", gtEndDate="
				+ gtEndDate + ", saleprice=" + saleprice + ", goldentimeStatus=" + goldentimeStatus + "]";
	}

	

}