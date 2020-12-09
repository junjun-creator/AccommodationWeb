package com.teum.entity;

import java.util.Date;

public class ReverseOffer {
	private int id;
	private int offerId;
	private int roomIndex;
	private Date approvalDate;
	
	public ReverseOffer() {
		
	}

	public ReverseOffer(int id, int offerId, int roomIndex, Date approvalDate) {
		super();
		this.id = id;
		this.offerId = offerId;
		this.roomIndex = roomIndex;
		this.approvalDate = approvalDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public int getRoomIndex() {
		return roomIndex;
	}

	public void setRoomIndex(int roomIndex) {
		this.roomIndex = roomIndex;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	@Override
	public String toString() {
		return "ReverseOffer [id=" + id + ", offerId=" + offerId + ", roomIndex=" + roomIndex + ", approvalDate="
				+ approvalDate + "]";
	}
	
}
