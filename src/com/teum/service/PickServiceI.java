package com.teum.service;

import java.util.List;

import com.teum.dao.entity.PickListView;

public interface PickServiceI {
	List<PickListView> getList(int userId);
	List<Double> getPointList(List<Integer> accIds);
}
