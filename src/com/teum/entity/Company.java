package com.teum.entity;

public class Company {
	private int id;
	private String name;
	private String email;
	private String birthday;
	private String password;
	private String phone;
	
	public Company() {
		
	}

	public Company(int id, String name, String email, String birthday, String password, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthday = birthday;
		this.password = password;
		this.phone = phone;
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

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", email=" + email + ", birthday=" + birthday + ", password="
				+ password + ", phone=" + phone + "]";
	}
	
	
}
