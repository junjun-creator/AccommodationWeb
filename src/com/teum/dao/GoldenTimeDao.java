package com.teum.dao;

import java.util.List;

import com.teum.dao.entity.GoldenTimeView;
import com.teum.entity.Acc;

public interface GoldenTimeDao {
	int update(Acc acc);
	int updateStatus(Acc acc);
	
	
	List<GoldenTimeView> getGoldenList();
	List<GoldenTimeView> getGoldenList(int id);
	
	
	
	List<GoldenTimeView> getVIewList(int startIndex, int endIndex, String category, String query);
	List<GoldenTimeView> getVIewList(int startIndex, int endIndex, String category);
	List<GoldenTimeView> getVIewList(int startIndex, int endIndex);
	List<GoldenTimeView> getVIewList();
	int getCount(String category, String query);
	

}
