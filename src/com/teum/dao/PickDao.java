package com.teum.dao;

import java.util.List;

import com.teum.dao.entity.PickListView;

public interface PickDao {
	List<PickListView> getList(int userId);

	List<Double> getPointList(List<Integer> accIds);
}
