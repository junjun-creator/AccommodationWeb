package com.teum.entity;

public class Room {
	private int id;
	private String name;
	private int price;
	private int accId;
	private int maxHeadcount;
	private int bedCount;
	private String bookedDate;
	
	public Room() {
		
	}

	public Room(int id, String name, int price, int accId, int maxHeadcount, int bedCount, String bookedDate) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.accId = accId;
		this.maxHeadcount = maxHeadcount;
		this.bedCount = bedCount;
		this.bookedDate = bookedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
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

	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", price=" + price + ", accId=" + accId + ", maxHeadcount="
				+ maxHeadcount + ", bedCount=" + bedCount + ", bookedDate=" + bookedDate + "]";
	}

	
	
}
