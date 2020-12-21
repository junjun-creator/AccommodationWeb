package com.teum.dao.entity;

import com.teum.entity.Room;

public class PayInfoView extends Room {
	
	private int accId;
	private String accName;
	
	public PayInfoView() {
	}

	public PayInfoView(int accId, int roomId, String accName, String roomName, String bookedDate, int price) {
		super(roomId, roomName, bookedDate, price);
		this.accId = accId;
		this.accName = accName;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}
	
	
}
