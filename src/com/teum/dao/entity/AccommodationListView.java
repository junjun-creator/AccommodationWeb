package com.teum.dao.entity;

public class AccommodationListView {
	private int accId;
	private int companyId;
	private int accType;
	private String accName;
	private String accLocation;
	private String accFileName;
	private String accFileRoute;
	private int price;
	private int score;
	
	public AccommodationListView() {
		
	}

	public AccommodationListView(int accId, int companyId, int accType, String accName, String accLocation,
			String accFileName, String accFileRoute, int price, int score) {
		super();
		this.accId = accId;
		this.companyId = companyId;
		this.accType = accType;
		this.accName = accName;
		this.accLocation = accLocation;
		this.accFileName = accFileName;
		this.accFileRoute = accFileRoute;
		this.price = price;
		this.score = score;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getAccType() {
		return accType;
	}

	public void setAccType(int accType) {
		this.accType = accType;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "AccommodationListView [accId=" + accId + ", companyId=" + companyId + ", accType=" + accType
				+ ", accName=" + accName + ", accLocation=" + accLocation + ", accFileName=" + accFileName
				+ ", accFileRoute=" + accFileRoute + ", price=" + price + ", score=" + score + "]";
	}
	
}
