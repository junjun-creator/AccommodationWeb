package com.teum.dao;

import java.util.List;

import com.teum.entity.Acc;
import com.teum.entity.AccListForAdminView;

public interface AccDao {
	
	int update(Acc acc);
	int delete(int id);
	int[] deleteAll(int[] ids);
	
	Acc get(int id);
	Acc applyGet(int id);
	
	List<Acc> getList();
	List<Acc> getList(int startIndex);
	List<Acc> getList(int startIndex, int endIndex,String accType, String qeury);
	
	List<Acc> applyGetList();
	List<Acc> applyGetList(int startIndex);
	List<Acc> applyGetList(int startIndex, int endIndex, String accType, String qeury);
	
	List<AccListForAdminView> getViewList();
	List<AccListForAdminView> getViewList(int startIndex, int endIndex);
	List<AccListForAdminView> getViewList(int startIndex, int endIndex, String accType, String qeury);
	
}
