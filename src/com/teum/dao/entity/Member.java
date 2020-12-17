package com.teum.dao.entity;

import java.util.Date;

public class Member {
	private int id;
	private String name;
	private String email;
	private String password;
	private String birthday;
	private String phone;
	private int type;
	private Date regdate;
	
	public Member() {
		
	}

	public Member(int id, String name, String email, String password, String birthday, String phone, int type,
			Date regdate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthday = birthday;
		this.phone = phone;
		this.type = type;
		this.regdate = regdate;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", birthday="
				+ birthday + ", phone=" + phone + ", type=" + type + ", regdate=" + regdate + "]";
	}

	
	
}

