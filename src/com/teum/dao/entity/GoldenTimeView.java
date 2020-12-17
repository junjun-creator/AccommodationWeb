package com.teum.dao.entity;

import java.util.Date;

import com.teum.entity.Acc;

public class GoldenTimeView extends Acc {
	private String fileroute;
	
	public GoldenTimeView() {
		
	}

	public GoldenTimeView(int id, String name, String phone, String location, int regStatus, Date approvalDate,
			int adminId, int companyId, Date regdate, int accTypeId, Date gtStartDate, Date gtEndDate, int saleprice,
			int goldentimeStatus, String fileroute) {
		super(id, name, phone, location, regStatus, approvalDate, adminId, companyId, regdate, accTypeId, gtStartDate,
				gtEndDate, saleprice, goldentimeStatus);
		this.fileroute=fileroute;
	}

	public String getFileroute() {
		return fileroute;
	}

	public void setFileroute(String fileroute) {
		this.fileroute = fileroute;
	}

	@Override
	public String toString() {
		return "GoldenTimeView [fileroute=" + fileroute + "]";
	}
	
	
	
	
}
