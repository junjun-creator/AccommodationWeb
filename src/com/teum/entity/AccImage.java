package com.teum.entity;

public class AccImage {
	
	private int id;
	private String filename;
	private String fileroute;
	private int accId;
	
	public AccImage(int id, String filename, String fileroute, int accId) {
		super();
		this.id = id;
		this.filename = filename;
		this.fileroute = fileroute;
		this.accId = accId;
	}
	
	@Override
	public String toString() {
		return "AccImage [id=" + id + ", filename=" + filename + ", fileroute=" + fileroute + ", accId=" + accId + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFileroute() {
		return fileroute;
	}
	public void setFileroute(String fileroute) {
		this.fileroute = fileroute;
	}
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	
	
}
