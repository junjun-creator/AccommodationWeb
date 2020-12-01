package com.teum.entity;

import java.util.Date;

public class Member {
	private int id;
	private String name;
	private String email;
	private String pwd;
	private String birthday;
	private String phone;
	private String type;
	private int rank;
	private Date regdate;
	
	public Member() {
		
	}
	
	public Member(int id, String name, String email, String pwd, String birthday, String phone, String type, int rank,
			Date regdate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.birthday = birthday;
		this.phone = phone;
		this.type = type;
		this.rank = rank;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", birthday=" + birthday
				+ ", phone=" + phone + ", type=" + type + ", rank=" + rank + ", regdate=" + regdate + "]";
	}
	
	
}
