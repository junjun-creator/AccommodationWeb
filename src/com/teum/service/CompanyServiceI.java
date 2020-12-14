package com.teum.service;

import java.util.List;

import com.teum.entity.Company;

public interface CompanyServiceI {
	
	List<Company> getList(int page, String text);//text 는 문자열로 검
	int delete(int[] id);
}
