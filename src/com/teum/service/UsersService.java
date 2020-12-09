package com.teum.service;

import java.util.List;

import com.teum.dao.UsersDao;
import com.teum.entity.Users;

public class UsersService {
	private UsersDao usersDao;
	
	public List<Users> getList(){
		return usersDao.getList();
	}
	
	public Users get(int id) {
		return usersDao.get(id);
	}
	
	public int insert(Users users) {
		int result = 0;
		
		result = usersDao.insert(users);
		
		return result;
	}
	
	public int update(Users users) {
		int result = 0;
		
		result = usersDao.update(users);
		
		return result;
	}
	
	public int delete(int id) {
		int result=0;
		
		result = usersDao.delete(id);
		
		return result;
	}
}
