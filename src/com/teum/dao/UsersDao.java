package com.teum.dao;

import java.util.ArrayList;
import java.util.List;

import com.teum.entity.Users;

public interface UsersDao {
	int insert(Users users);
	int update(Users users);
	int delete(int id);
	
	Users get(int id);
	List<Users> getList();
	List<Users> getList(int startIndex, int endIndex);
	List<Users> getList(int startIndex, int endIndex, String field, String query);
//	int getCount();
	int getCount(String field, String query);
	ArrayList<Integer> getRankCount();
}
