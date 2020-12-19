package com.teum.dao.entity;

public class OfferInfoView {
	private int roomId;
	private String roomName;
	private int price;
	private int accId;
	private int maxHeadcount;
	private int bedCount;
	private String fileName;
	private String fileRoute;
	private int offerId;
	private String accName;
	
	public OfferInfoView() {
		
	}

	public OfferInfoView(int roomId, String roomName, int price, int accId, int maxHeadcount, int bedCount,
			String fileName, String fileRoute, int offerId, String accName) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.price = price;
		this.accId = accId;
		this.maxHeadcount = maxHeadcount;
		this.bedCount = bedCount;
		this.fileName = fileName;
		this.fileRoute = fileRoute;
		this.offerId = offerId;
		this.accName = accName;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileRoute() {
		return fileRoute;
	}

	public void setFileRoute(String fileRoute) {
		this.fileRoute = fileRoute;
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	@Override
	public String toString() {
		return "OfferInfoView [roomId=" + roomId + ", roomName=" + roomName + ", price=" + price + ", accId=" + accId
				+ ", maxHeadcount=" + maxHeadcount + ", bedCount=" + bedCount + ", fileName=" + fileName
				+ ", fileRoute=" + fileRoute + ", offerId=" + offerId + ", accName=" + accName + "]";
	}

	
	
}
