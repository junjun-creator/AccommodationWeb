package com.teum.service;

import com.teum.dao.entity.Member;

public interface LoginServiceI {
	int valid(String email,String password);
	Member get(String email, String password);
}
