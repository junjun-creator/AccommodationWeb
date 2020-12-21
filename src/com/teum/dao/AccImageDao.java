package com.teum.dao;

import java.util.List;

import com.teum.entity.AccImage;

public interface AccImageDao {

	int insert(AccImage accImage);

	List<AccImage> getList(int accId);

}
