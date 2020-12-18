package com.teum.dao;

import java.util.List;

import com.teum.dao.entity.AccListForAdminView;
import com.teum.dao.entity.GoldenTimeView;
import com.teum.entity.Acc;

public interface AccDao {
	
	int approval(int id);
	int[] approvalAll(int[] ids);
	int delete(int id);
	int[] deleteAll(int[] ids);
	
	int insert(Acc acc);
	int update(Acc acc);
	
	Acc get(int id);
	Acc applyGet(int id);
	
	List<Acc> getList();
	List<Acc> getList(String location);
	List<Acc> applyGetList();
	
	List<AccListForAdminView> getViewList();
	List<AccListForAdminView> getViewList(int startIndex, int endIndex);
	List<AccListForAdminView> getViewList(int startIndex, int endIndex, String ac, String field,  String query);
	List<AccListForAdminView> getApplyViewList();
	List<AccListForAdminView> getApplyViewList(int startIndex, int endIndex);
	List<AccListForAdminView> getApplyViewList(int startIndex, int endIndex,String ac, String field,  String query);
	
	Acc getLast();
	List<GoldenTimeView> getGoldenList();
	
}
