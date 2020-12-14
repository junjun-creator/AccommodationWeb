package com.teum.service;

import java.util.ArrayList;
import java.util.List;

import com.teum.dao.CompanyDao;
import com.teum.dao.jdbc.JdbcCompanyDao;
import com.teum.entity.Company;
import com.teum.entity.Users;

public class CompanyService implements CompanyServiceI {

	private CompanyDao companyDao;
	
	public CompanyService() {
		companyDao = new JdbcCompanyDao();
	}
	
	@Override
	public int delete(int[] id) {
		int result = 0;
		
		for(int i=0;i<id.length;i++) {
			result += companyDao.delete(id[i]);
		}
		return result;
	}

	@Override
	public int delete(int id) {
		int result=0;
		
		result = companyDao.delete(id);
		
		return result;
	}

	@Override
	public List<Company> getList() {
		return getList(1,"");
	}

	@Override
	public List<Company> getList(int page) {
		return getList(page,"");
	}

	@Override
	public List<Company> getList(int page, String text) {

		List<Company> list = new ArrayList<>();
		
		int startIndex = 1+(page-1)*10;
		int endIndex = page*10;
		
		list = companyDao.getList(startIndex,endIndex,text);
		
		return list;
	}

	@Override
	public Company get(int id) {
		return companyDao.get(id);
	}

	@Override
	public int update(Company company) {
		int result = 0;
		
		result = companyDao.update(company);
		
		return result;
	}

	@Override
	public int insert(Company company) {
		int result = 0;
		
		result = companyDao.insert(company);
		
		return result;
	}

}
