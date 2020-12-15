package com.teum.entity;

import java.util.Date;

public class Acc {

	 private int id;
	 private String name;
	 private String location;
	 private Date regdate;
	 private String phone;
	 private String email;
	 private int accTypeId;
	 private int regStatus;
	 private Date approvalDate;
	 private int adiminId;
	 private int companyId;
	 private Date startDate;
	 private Date endDate;
	 private int saleprice;
	 
	public Acc() {
		
	}

	public Acc(int id, String name, String location, Date regdate, String phone, String email, int accTypeId,
			int regStatus, Date approvalDate, int adiminId, int companyId, Date startDate, Date endDate,
			int saleprice) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.regdate = regdate;
		this.phone = phone;
		this.email = email;
		this.accTypeId = accTypeId;
		this.regStatus = regStatus;
		this.approvalDate = approvalDate;
		this.adiminId = adiminId;
		this.companyId = companyId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.saleprice = saleprice;
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

	public int getAdiminId() {
		return adiminId;
	}

	public void setAdiminId(int adiminId) {
		this.adiminId = adiminId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}

	@Override
	public String toString() {
		return "Acc [id=" + id + ", name=" + name + ", location=" + location + ", regdate=" + regdate + ", phone="
				+ phone + ", email=" + email + ", accTypeId=" + accTypeId + ", regStatus=" + regStatus
				+ ", approvalDate=" + approvalDate + ", adiminId=" + adiminId + ", companyId=" + companyId
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", saleprice=" + saleprice + "]";
	}

}