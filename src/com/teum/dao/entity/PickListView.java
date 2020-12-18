package com.teum.dao.entity;

public class PickListView {
	private int accId;
	private int userId;
	private String accName;
	private String accLocation;
	private String accFileName;
	private String accFileRoute;
	private int price;
	
	public PickListView() {
		
	}

	public PickListView(int accId, int userId, String accName, String accLocation, String accFileName,
			String accFileRoute, int price) {
		super();
		this.accId = accId;
		this.userId = userId;
		this.accName = accName;
		this.accLocation = accLocation;
		this.accFileName = accFileName;
		this.accFileRoute = accFileRoute;
		this.price = price;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getAccLocation() {
		return accLocation;
	}

	public void setAccLocation(String accLocation) {
		this.accLocation = accLocation;
	}

	public String getAccFileName() {
		return accFileName;
	}

	public void setAccFileName(String accFileName) {
		this.accFileName = accFileName;
	}

	public String getAccFileRoute() {
		return accFileRoute;
	}

	public void setAccFileRoute(String accFileRoute) {
		this.accFileRoute = accFileRoute;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PickListView [accId=" + accId + ", userId=" + userId + ", accName=" + accName + ", accLocation="
				+ accLocation + ", accFileName=" + accFileName + ", accFileRoute=" + accFileRoute + ", price=" + price
				+ "]";
	}
	
}
