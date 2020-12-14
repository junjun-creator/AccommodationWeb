package com.teum.service;

import java.util.List;

import com.teum.entity.Company;
import com.teum.entity.Users;

public interface CompanyServiceI {
	int delete(int[] id);
	int delete(int id);
	
	List<Company> getList();
	List<Company> getList(int page);
	List<Company> getList(int page, String text);//text 는 문자열로 검
	
	Company get(int id);
	int update(Company company);
	int insert(Company company);
}
