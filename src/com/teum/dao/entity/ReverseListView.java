package com.teum.dao.entity;

import java.util.Date;

public class ReverseListView {
	
	private int accId;
	private int offerId;
	private int roomId;
	private String roomName;
	private int roomPrice;
	private int maxHeadcount;
	private int bedCount;
	private String bookedDate;
	private Date approvalDate;
	private String filename;
	private String fileroute;
	
	public ReverseListView(int accId, int offerId, int roomId, String roomName, int roomPrice, int maxHeadcount,
			int bedCount, String bookedDate, Date approvalDate, String filename, String fileroute) {
		super();
		this.accId = accId;
		this.offerId = offerId;
		this.roomId = roomId;
		this.roomName = roomName;
		this.roomPrice = roomPrice;
		this.maxHeadcount = maxHeadcount;
		this.bedCount = bedCount;
		this.bookedDate = bookedDate;
		this.approvalDate = approvalDate;
		this.filename = filename;
		this.fileroute = fileroute;
	}
	
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
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
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}
	public int getMaxHeadcount() {
		return maxHeadcount;
	}
	public void setMaxHeadcount(int maxHeadcount) {
		this.maxHeadcount = maxHeadcount;
	}
	public int getBedCount() {
		return bedCount;
	}
	public void setBedCount(int bedCount) {
		this.bedCount = bedCount;
	}
	public String getBookedDate() {
		return bookedDate;
	}
	public void setBookedDate(String bookedDate) {
		this.bookedDate = bookedDate;
	}
	public Date getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFileroute() {
		return fileroute;
	}
	public void setFileroute(String fileroute) {
		this.fileroute = fileroute;
	}


	@Override
	public String toString() {
		return "ReverseListView [accId=" + accId + ", offerId=" + offerId + ", roomId=" + roomId + ", roomName="
				+ roomName + ", roomPrice=" + roomPrice + ", maxHeadcount=" + maxHeadcount + ", bedCount=" + bedCount
				+ ", bookedDate=" + bookedDate + ", approvalDate=" + approvalDate + ", filename=" + filename
				+ ", fileroute=" + fileroute + "]";
	}
	
	
}
