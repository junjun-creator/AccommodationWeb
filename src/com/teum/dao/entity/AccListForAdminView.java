package com.teum.dao.entity;

import java.util.Date;

import com.teum.entity.Acc;

public class AccListForAdminView extends Acc{
	
	private int num;
	private String companyName;
	private String accType;
	
public AccListForAdminView() {
	// TODO Auto-generated constructor stub
}

public AccListForAdminView(int id, String name, String phone, String location, String email, int regStatus,
		Date approvalDate, int adiminId, int companyId, Date regdate, int accTypeId, Date gtStartDate, Date gtEndDate,
		int saleprice, int goldentimeStatus,int num, String companyName,String accType) {
	super(id, name, phone, location, email, regStatus, approvalDate, adiminId, companyId, regdate, accTypeId, gtStartDate,
			gtEndDate, saleprice, goldentimeStatus);
	this.num =num;
	this.companyName =companyName;
	this.accType=accType;
}


public int getNum() {
	return num;
}

public void setNum(int num) {
	this.num = num;
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
	return "AccListForAdminView [num=" + num + ", companyName=" + companyName + ", accType=" + accType + "]";
}


}
