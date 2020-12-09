package com.teum.entity;

public class Rank {
	private int id;
	private String tier;
	
	public Rank() {
		
	}
	
	public Rank(int id, String tier) {
		super();
		this.id = id;
		this.tier = tier;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	@Override
	public String toString() {
		return "Rank [id=" + id + ", tier=" + tier + "]";
	}
	
	
	
}
