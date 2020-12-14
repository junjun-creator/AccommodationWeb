package com.teum.entity;

import java.util.Date;

public class Company {
	private int id;
	private String name;
	private String email;
	private String birthday;
	private String password;
	private String phone;
	private Date regdate;
	private int type;
	
	public Company() {
		
	}

	public Company(int id, String name, String email, String birthday, String password, String phone, Date regdate,
			int type) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthday = birthday;
		this.password = password;
		this.phone = phone;
		this.regdate = regdate;
		this.type = type;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", email=" + email + ", birthday=" + birthday + ", password="
				+ password + ", phone=" + phone + ", regdate=" + regdate + ", type=" + type + "]";
	}

	
}
