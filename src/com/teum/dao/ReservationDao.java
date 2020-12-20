package com.teum.dao;

import java.util.List;

import com.teum.dao.entity.ReservationForCompanyView;
import com.teum.dao.entity.ReservationListView;

public interface ReservationDao {

	List<ReservationListView> getListByUser(int startIndex, int endIndex,int id);

	int getCount(int userId);

	List<ReservationForCompanyView> getList(int startIndex, int endIndex, String accIdsCSV, int accType);

}
