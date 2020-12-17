package com.teum.service;

import java.util.ArrayList;
import java.util.List;

import com.teum.dao.AccDao;
import com.teum.dao.entity.AccListForAdminView;
import com.teum.dao.entity.GoldenTimeView;
import com.teum.dao.jdbc.JdbcAccDao;
//import com.teum.dao.jdbc.JdbcAccDao;
import com.teum.entity.Acc;

public class AccService {

	private AccDao accDao;

	public AccService() {
		accDao = new JdbcAccDao();
	}
	
	public int insert(Acc acc) {
		int result = accDao.insert(acc);
		return result;
	}
	
	public int update(Acc acc) {
		int result = accDao.update(acc);
		return result;
	}

	public List<AccListForAdminView> getViewList() {

		return accDao.getViewList(1, 10, "", "companyName", "");
	}

	public List<AccListForAdminView> getViewList(int page, int size) {

		return accDao.getViewList(page, size, "", "companyName", "");
	}

	public List<AccListForAdminView> getViewList(int page, int size, String ac, String field, String qeury) {

		int startIndex = 1 + (page - 1) * size;// 1, 11, 21, 31, ...
		int endIndex = page * 10;// 10,20,30,40,50,60...

		return accDao.getViewList(startIndex, endIndex, ac, field, qeury);
	}

	public List<AccListForAdminView> getApplyViewList() {

		return accDao.getApplyViewList(1, 10, "", "", "");
	}

	public List<AccListForAdminView> getApplyViewList(int page, int size) {

		return accDao.getApplyViewList(page, size, "", "", "");
	}

	public List<AccListForAdminView> getApplyViewList(int page, int size, String ac, String field, String qeury) {

		int startIndex = 1 + (page - 1) * size;// 1, 11, 21, 31, ...
		int endIndex = page * 10;// 10,20,30,40,50,60...

		return accDao.getApplyViewList(startIndex, endIndex, ac, field, qeury);
	}

	public Acc get(int id) {
		return accDao.get(id);
	}

	public Acc applyGet(int id) {
		return accDao.applyGet(id);
	}

	public int delete(int id) {
		int result = 0;
		result = accDao.delete(id);

		return result;
	}

	// 수정필요
	public int[] deleteAll(int[] ids) {

		int result = 0;
		for (int i = 0; i < ids.length; i++) {
			int id = ids[i];
			result += accDao.delete(id);
		}
		return null;
	}

	public int approval(int id) {
		int result = 0;
		Acc acc = accDao.applyGet(id);
		acc.setRegStatus(1);
		result = accDao.approval(id);
		return result;
	}

	public int[] approvalAll(int[] ids) {
		int result = 0;
		for (int i = 0; i < ids.length; i++) {
			int id = ids[i];
			result += accDao.approval(id);
		}
		return null;
	}

	public int getLastId() {
		Acc acc = accDao.getLast();
		return acc.getId();
	}

	public List<GoldenTimeView> getGoldenList() {
		List<GoldenTimeView> list = new ArrayList<GoldenTimeView>();
		list =accDao.getGoldenList();
		return list;
	}
}