package com.teum.entity;

import java.util.Date;

public class QnA {
	private int id;
	private String name;
	private String title;
	private String content;
	private String phone;
	private Date regdate;
	private int answer;
	
	public QnA() {
		
	}

	public QnA(int id, String name, String title, String content, String phone, Date regdate, int answer) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.content = content;
		this.phone = phone;
		this.regdate = regdate;
		this.answer = answer;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "QnA [id=" + id + ", name=" + name + ", title=" + title + ", content=" + content + ", phone=" + phone
				+ ", regdate=" + regdate + ", answer=" + answer + "]";
	}
	
}
