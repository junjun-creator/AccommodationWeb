package com.teum.dao;

import java.util.List;

import com.teum.dao.entity.GoldenTimeView;
import com.teum.entity.Acc;

public interface GoldenTimeDao {
	int update(Acc acc);
	int updateStatus(Acc acc);
	
	
	List<GoldenTimeView> getGoldenList(int id);

}
