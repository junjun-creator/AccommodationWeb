package com.teum.dao.entity;

import com.teum.entity.Users;

public class UsersListView extends Users {
	private int rownum;
	
	public UsersListView() {
		
	}

	public UsersListView(int rownum) {
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
		return "UsersListView [rownum=" + rownum + ", toString()=" + super.toString() + "]";
	}
	
	
}
