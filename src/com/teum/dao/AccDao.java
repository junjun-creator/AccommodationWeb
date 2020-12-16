package com.teum.dao;

import java.util.List;

import com.teum.dao.entity.AccListForAdminView;
import com.teum.entity.Acc;

public interface AccDao {
	
	int approval(int id);
	int[] approvalAll(int[] ids);
	int delete(int id);
	int[] deleteAll(int[] ids);
	
	Acc get(int id);
	Acc applyGet(int id);
	
	List<Acc> getList();
	List<Acc> getList(int startIndex, int endIndex);
	List<Acc> getList(int startIndex, int endIndex, String qeury);
	
	List<Acc> applyGetList();
	List<Acc> applyGetList(int startIndex, int endIndex);
	List<Acc> applyGetList(int startIndex, int endIndex, String qeury);
	
	List<AccListForAdminView> getViewList();
	List<AccListForAdminView> getViewList(int startIndex, int endIndex);
	List<AccListForAdminView> getViewList(int startIndex, int endIndex, String qeury);
	
}
