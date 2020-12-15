package com.teum.dao.entity;

import java.util.Date;

import com.teum.entity.Acc;

public class AccListForAdminView extends Acc{

	private int rownum;
	private String companyName;
	private String accType;

	public AccListForAdminView() {
		super();
		this.rownum = rownum;
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

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	@Override
	public String toString() {
		return "AccListForAdminView [rownum=" + rownum + ", companyName=" + companyName + ", accType=" + accType + "]";
	}



	
	
}
