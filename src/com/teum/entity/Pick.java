package com.teum.entity;

public class Pick {
	private int id;
	private int userId;
	private int accId;
	
	public Pick() {
		
	}

	public Pick(int id, int userId, int accId) {
		super();
		this.id = id;
		this.userId = userId;
		this.accId = accId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	@Override
	public String toString() {
		return "Pick [id=" + id + ", userId=" + userId + ", accId=" + accId + "]";
	}
	
}
