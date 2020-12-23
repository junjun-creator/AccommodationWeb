package com.teum.dao;

import java.util.List;

import com.teum.entity.AccImage;

public interface AccImageDao {

	int insert(AccImage accImage);

	AccImage get(int accId);


}
