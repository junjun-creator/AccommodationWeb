package com.teum.dao.entity;

import java.util.Date;

import com.teum.entity.Notice;

public class NoticeView extends Notice {

	private int num;
	
	public NoticeView() {
	}

	public NoticeView(int id, String title, int adminId, String content, Date regdate, int openStatus, String imageName,
			String imageRoute, int num) {
		super(id, title, adminId, content, regdate, openStatus, imageName, imageRoute);
		this.num = num;
	}

	public NoticeView(String title, String content, int adminId, int openStatus) {
		super(title, content, adminId, openStatus);
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "NoticeView [num=" + num + "]";
	}
	
	
	
}
