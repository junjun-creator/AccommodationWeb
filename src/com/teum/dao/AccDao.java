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
	List<Acc> applyGetList();
	List<AccListForAdminView> getViewList();
	List<AccListForAdminView> getViewList(int startIndex, int endIndex);
	List<AccListForAdminView> getViewList(String ac, String field,  String query, int startIndex, int endIndex);
	List<AccListForAdminView> getApplyViewList();
	List<AccListForAdminView> getApplyViewList(int startIndex, int endIndex);
	List<AccListForAdminView> getApplyViewList(int startIndex, int endIndex,String ac,String field,  String query);

	
	
	
}
