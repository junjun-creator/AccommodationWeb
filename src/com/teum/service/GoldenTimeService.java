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

	public List<GoldenTimeView> getGoldenList() {
		
		return getGoldenList(0);
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

	public int closeStatus(int chk) {
	int result =0;
		int status = 0;
		result = goldenTimeDao.updateStatus(status,chk);
		
		return result;
	}

	public int openStatus(int chk) {
	int result =0;
	int status = 1;
	result = goldenTimeDao.updateStatus(status,chk);
		
		return result;
		
	}


	public List<GoldenTimeView> getVIewList(int page, int size, String category, String query) {
		
		 List<GoldenTimeView> list = new ArrayList<GoldenTimeView>();
		 
		 int startIndex = 1 + (page-1)*size;
		int endIndex = page*size;
		
		list = goldenTimeDao.getVIewList(startIndex,endIndex,category,query);
		return list;
	}
	public List<GoldenTimeView> getViewList(int page,int size, String category){
		
		
		return goldenTimeDao.getVIewList(page, size, category,"");
	}
	
	public List<GoldenTimeView> getViewList(int page,int size){
		
		
		return goldenTimeDao.getVIewList(page,size,"","");
	}
	
	public List<GoldenTimeView> getViewList(){
		
		
		return goldenTimeDao.getVIewList(1, 3, "", "");
	}

	public int getCount(String category, String query) {
		int result = 0;
		
		result = goldenTimeDao.getCount(category,query);
		
		return result;
	}


	
	

}
