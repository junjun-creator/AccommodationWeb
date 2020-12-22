package com.teum.dao.entity;

import java.util.Date;

import com.teum.entity.Acc;

public class AccImageListView extends Acc {
	
	private String filename;
	private String fileroute;
	
	public AccImageListView(int id, String name, String filename, String fileroute, String phone, String location, int regStatus, Date approvalDate, int adminId, int companyId, Date regdate, int accTypeId, Date gtStartDate, Date gtEndDate, int saleprice, int goldentimeStatus) {
		super(id, name, phone, location, regStatus, approvalDate, adminId, companyId, regdate, accTypeId, gtStartDate, gtEndDate, saleprice, goldentimeStatus);
		this.filename = filename;
		this.fileroute = fileroute;
	}
	
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFileroute() {
		return fileroute;
	}
	public void setFileroute(String fileroute) {
		this.fileroute = fileroute;
	}
	
	
}
