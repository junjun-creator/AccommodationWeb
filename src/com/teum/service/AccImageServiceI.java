package com.teum.service;

import java.util.List;

import com.teum.entity.AccImage;

public interface AccImageServiceI {
	//숙소리스트 페이지(유저,숙소)
	public List<AccImage> getList(int[] id, String type);
}
