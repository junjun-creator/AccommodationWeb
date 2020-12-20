package com.teum.dao;

import java.util.List;

import com.teum.dao.entity.AccListForAdminView;
import com.teum.dao.entity.GoldenTimeView;
import com.teum.entity.Acc;

public interface AccDao {
	
	int delete(int id);
	int deleteAll(int[] ids);
	int approval(int id);
	int approvalAll(int[] ids);
	int getAccCount(String ac,String field, String query);
	int getApplyAccCount(String ac,String field, String query);
	
	int insert(Acc acc);
	int update(Acc acc);
	
	Acc get(int id);
	Acc applyGet(int id);
	
	List<Acc> getList();
	List<Acc> getList(String location);	// 개인회원으로부터 제안받은 위치에 일치하는 숙소목록 얻어오기
	List<Acc> getList(int companyId); 	// 개인회원으로부터 제안받은 숙소 중 기업회원 id와 일치하는 것만 얻어오기
	List<Acc> getList(int type, String location); // /accommodation/list 불러올 때
	List<Acc> applyGetList();
	
	List<AccListForAdminView> getViewList();
	List<AccListForAdminView> getViewList(int startIndex, int endIndex);
	List<AccListForAdminView> getViewList(String ac, String field,  String query, int startIndex, int endIndex);
	List<AccListForAdminView> getApplyViewList();
	List<AccListForAdminView> getApplyViewList(int startIndex, int endIndex);
	List<AccListForAdminView> getApplyViewList(String ac, String field,  String query, int startIndex, int endIndex);
	
	Acc getLast();
	List<GoldenTimeView> getGoldenList();
	
	List<Integer> getIds(int companyId, int accType);
	
	
	
}
