package com.teum.service;

import java.util.List;

import com.teum.dao.PickDao;
import com.teum.dao.entity.PickListView;
import com.teum.dao.jdbc.JdbcPickDao;

public class PickService implements PickServiceI{
	private PickDao pickDao;
	
	public PickService() {
		pickDao = new JdbcPickDao();
	}

	@Override
	public List<PickListView> getList(int userId) {
		List<PickListView> list = pickDao.getList(userId);
		
		return list;
	}
	@Override
	public List<Double> getPointList(List<Integer> accIds) {
		List<Double> pointList = pickDao.getPointList(accIds);
		
		return pointList;
	}
	
}
