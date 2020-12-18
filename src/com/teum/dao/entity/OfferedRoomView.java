package com.teum.dao.entity;

public class OfferedRoomView {
	private int id;
	private int name;
	private int price;
	private int accId;
	private int maxHeadcount;
	private int bedCount;
	private String bookedDate;
	private String fileName;
	private String fileRoute;
	
	public OfferedRoomView() {
		
	}

	public OfferedRoomView(int id, int name, int price, int accId, int maxHeadcount, int bedCount, String bookedDate,
			String fileName, String fileRoute) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.accId = accId;
		this.maxHeadcount = maxHeadcount;
		this.bedCount = bedCount;
		this.bookedDate = bookedDate;
		this.fileName = fileName;
		this.fileRoute = fileRoute;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
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

	public String getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(String bookedDate) {
		this.bookedDate = bookedDate;
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

	@Override
	public String toString() {
		return "OfferedRoomView [id=" + id + ", name=" + name + ", price=" + price + ", accId=" + accId
				+ ", maxHeadcount=" + maxHeadcount + ", bedCount=" + bedCount + ", bookedDate=" + bookedDate
				+ ", fileName=" + fileName + ", fileRoute=" + fileRoute + "]";
	}
	
	
}
