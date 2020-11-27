package com.teum.entity;

public class AccommodationList {

	 private int id;
	 private String name;
	 private String accName;
	 private String location;
	 private String regdate;
	 private String phone;
	 private String email;
	 private String accType;
	 private int registration;
	
	 public AccommodationList(int id, String name, String accName, String location, String regdate, String phone,
			String email, String accType, int registration) {
		super();
		this.id = id;
		this.name = name;
		this.accName = accName;
		this.location = location;
		this.regdate = regdate;
		this.phone = phone;
		this.email = email;
		this.accType = accType;
		this.registration = registration;
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

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public int getRegistration() {
		return registration;
	}

	public void setRegistration(int registration) {
		this.registration = registration;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	 
	 
	 
}
