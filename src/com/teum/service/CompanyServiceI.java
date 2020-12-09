package com.teum.service;

import java.util.List;

public class CompanyServiceI {
	List<Company> getList(int page, String text);//text 는 문자열로 검
	int delete(int[] id);
}
