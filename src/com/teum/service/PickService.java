package com.teum.service;

import java.util.List;

import com.teum.dao.PickDao;
import com.teum.dao.entity.PickListView;
import com.teum.dao.jdbc.JdbcPickDao;
import com.teum.entity.Pick;

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
	@Override
	public int delete(Pick p) {
		int result = 0;
		
		result = pickDao.delete(p);
		
		return result;
	}
	@Override
	public int checkZzim(int userId, int accId) {
		int result = 0;
		
		result = pickDao.checkZzim(userId, accId);
		
		return result;
	}
	@Override
	public int insertZzim(int userId, int accId) {
		int result = 0;
		
		result = pickDao.insertZzim(userId,accId);
		
		return result;
	}
	@Override
	public int deleteZzim(int userId, int accId) {
		int result = 0;
		
		result = pickDao.deleteZzim(userId,accId);
		
		return result;
	}

	public int delete(int accId) {
		int result = 0;
		
		result = pickDao.delete(accId);
		
		return result;
	}
	
}
