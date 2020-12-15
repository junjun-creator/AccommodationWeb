package com.teum.dao;

import java.util.List;

import com.teum.entity.Company;

public interface CompanyDao {
	int insert(Company company);
	int update(Company company);
	int delete(int id);
	
	Company get(int id);
	List<Company> getList();
	List<Company> getList(int startIndex, int endIndex);
	List<Company> getList(int startIndex, int endIndex, String field, String query);
	int getCount(String field, String query);
}
