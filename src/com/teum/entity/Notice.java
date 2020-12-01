package com.teum.entity;

import java.util.Date;

public class Notice {
	private int id;
    private String title;
    private String writerId;
    private String content;
    private Date regdate;
    private int pub;

    
    public Notice() {
    	
    }


	public Notice(int id, String title, String writerId, String content, Date regdate, int pub) {
		super();
		this.id = id;
		this.title = title;
		this.writerId = writerId;
		this.content = content;
		this.regdate = regdate;
		this.pub = pub;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getWriterId() {
		return writerId;
	}


	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	public int getPub() {
		return pub;
	}


	public void setPub(int pub) {
		this.pub = pub;
	}


	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", writerId=" + writerId + ", content=" + content
				+ ", regdate=" + regdate + ", pub=" + pub + "]";
	}


    
}
