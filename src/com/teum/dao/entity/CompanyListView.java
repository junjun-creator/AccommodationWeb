package com.teum.dao.entity;

import com.teum.entity.Company;

public class CompanyListView extends Company{
	private int rownum;
	
	public CompanyListView() {
		
	}

	public CompanyListView(int rownum) {
		super();
		this.rownum = rownum;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	@Override
	public String toString() {
		return "CompanyListView [rownum=" + rownum + ", toString()=" + super.toString() + "]";
	}
	
}
