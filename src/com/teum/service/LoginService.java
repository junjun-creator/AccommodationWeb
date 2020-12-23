package com.teum.service;

import com.teum.dao.MemberDao;
import com.teum.dao.UsersDao;
import com.teum.dao.entity.Member;
import com.teum.dao.jdbc.JdbcMemberDao;
import com.teum.dao.jdbc.JdbcUsersDao;

public class LoginService implements LoginServiceI {
	private MemberDao memberDao;
	
	public LoginService() {
		memberDao = new JdbcMemberDao();
	}
	
	@Override
	public int valid(String email, String password) {
		int result = 0;
		
		result = memberDao.valid(email, password);
		
		return result;
	}

	@Override
	public Member get(String email, String password) {
		return memberDao.get(email, password);
	}

	@Override
	public String getEmail(String name, String phone) {
		String result = "";
		
		result = memberDao.getEmail(name,phone);
		
		return result;
	}

	public String getPwd(String name, String email, String phone) {
		String result="";
		
		result = memberDao.getPwd(name,email,phone);
		
		return result;
	}

}
