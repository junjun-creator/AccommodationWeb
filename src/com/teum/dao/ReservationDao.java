package com.teum.dao;

import java.util.List;

import com.teum.dao.entity.ReservationListView;

public interface ReservationDao {

	List<ReservationListView> getListByUser(int startIndex, int endIndex,int id);

	int getCount(int userId);

}
