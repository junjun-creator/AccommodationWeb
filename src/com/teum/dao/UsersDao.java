package com.teum.dao;

import java.util.List;

import com.teum.entity.Users;

public interface UsersDao {
	int insert(Users users);
	int update(Users users);
	int delete(int id);
	
	Users get(int id);
	List<Users> getList();
}
