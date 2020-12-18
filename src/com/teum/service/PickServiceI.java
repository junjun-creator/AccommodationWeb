package com.teum.service;

import java.util.List;

import com.teum.dao.entity.PickListView;
import com.teum.entity.Pick;

public interface PickServiceI {
	List<PickListView> getList(int userId);
	List<Double> getPointList(List<Integer> accIds);
	int delete(Pick p);
}
