package com.teum.service;

import java.util.ArrayList;
import java.util.List;

import com.teum.dao.GoldenTimeDao;
import com.teum.dao.entity.GoldenTimeView;
import com.teum.dao.jdbc.JdbcGoldenTimeDao;
import com.teum.entity.Acc;

public class GoldenTimeService {

	private GoldenTimeDao goldenTimeDao;	
	
	
	public GoldenTimeService() {
		goldenTimeDao =new JdbcGoldenTimeDao();
	}
	
	public List<GoldenTimeView> getGoldenList(int id) {
		List<GoldenTimeView> list = new ArrayList<GoldenTimeView>();
			list =goldenTimeDao.getGoldenList(id);
		return list;
	}

	public int update(Acc acc) {
		int result =0;
		
		result = goldenTimeDao.update(acc);
		return result;
		
	}

	public int updateStatus(Acc acc) {
		int result =0;
		
		result = goldenTimeDao.updateStatus(acc);
		return result;
		
	}


}
