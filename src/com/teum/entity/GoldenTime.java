package com.teum.entity;

import java.util.Date;

public class GoldenTime {
	private int id;
	private String name;
	private String accName;
	private String location;
	private Date regdate;
	private String phone;
	private String email;
	private String accType;
	private int registration;
	
	public GoldenTime() {
		
	}

	public GoldenTime(int id, String name, String accName, String location, Date regdate, String phone, String email,
			String accType, int registration) {
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
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
		return "GoldenTime [id=" + id + ", name=" + name + ", accName=" + accName + ", location=" + location
				+ ", regdate=" + regdate + ", phone=" + phone + ", email=" + email + ", accType=" + accType
				+ ", registration=" + registration + "]";
	}
	
	
}
