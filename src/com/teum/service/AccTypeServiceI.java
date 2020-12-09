package com.teum.service;

import java.util.List;
import com.teum.entity.AccType;

public class AccTypeServiceI {

	public List<AccType> getList(int id, String type);
	
	public List<AccType> get(int id);
}
