package com.teum.dao.entity;

import java.util.Date;

import com.teum.entity.Acc;

public class AccListForAdminView extends Acc{

	private String companyName;
	private String accType;
	

	public AccListForAdminView(int id, String accName, String location, Date regdate, String phone, String email, int accTypeId, int regStatus, Date approvalDate, int adiminId, int companyId, Date startDate, Date endDate, int saleprice, String companyName, String accType) {
		super();
		this.companyName = companyName;
		this.accType = accType;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	

	@Override
	public String toString() {
		return "AccListForAdminView [companyName=" + companyName + ", accType=" + accType + ", toString()=" + super.toString() +"]";
	}



	
	
}
