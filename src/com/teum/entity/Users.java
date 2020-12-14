package com.teum.entity;

import java.util.Date;

public class Users {
	private int id;
	private String name;
	private String email;
	private String password;
	private String birthday;
	private String phone;
	private int rankId;
	private Date regdate;
	private int type;
	
	public Users() {
		
	}

	public Users(int id, String name, String email, String password, String birthday, String phone, int rankId,
			Date regdate, int type) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthday = birthday;
		this.phone = phone;
		this.rankId = rankId;
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

	public int getRankId() {
		return rankId;
	}

	public void setRankId(int rankId) {
		this.rankId = rankId;
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
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", birthday="
				+ birthday + ", phone=" + phone + ", rankId=" + rankId + ", regdate=" + regdate + ", type=" + type
				+ "]";
	}
	
	
	
}
