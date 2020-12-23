package com.teum.dao;

import com.teum.dao.entity.Member;

public interface MemberDao {
	int valid(String email, String password);
	
	Member get(String email, String password);

	String getEmail(String name, String phone);

	String getPwd(String name, String email, String phone);
}
