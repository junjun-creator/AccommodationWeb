package com.teum.entity;

import java.util.Date;

public class ReverseOffer {
	private int id;
	private int offerId;
	private int roomId;
	private Date approvalDate;
	
	public ReverseOffer() {
		
	}

	public ReverseOffer(int id, int offerId, int roomId, Date approvalDate) {
		super();
		this.id = id;
		this.offerId = offerId;
		this.roomId = roomId;
		this.approvalDate = approvalDate;
	}

	public ReverseOffer(int offerId, int roomId) {
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

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	@Override
	public String toString() {
		return "ReverseOffer [id=" + id + ", offerId=" + offerId + ", roomId=" + roomId + ", approvalDate="
				+ approvalDate + "]";
	}

	
}
