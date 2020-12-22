package com.teum.service;

import java.util.ArrayList;
import java.util.List;

import com.teum.dao.UsersDao;
import com.teum.dao.jdbc.JdbcUsersDao;
import com.teum.entity.Users;

public class UsersService implements UsersServiceI{
	private UsersDao usersDao;
	
	public UsersService() {
		usersDao = new JdbcUsersDao();
	}
	
	public Users get(int id) {
		return usersDao.get(id);
	}
	
	public int insert(Users users) {
		int result = 0;
		
		result = usersDao.insert(users);
		
		return result;
	}
	
	@Override
	public int delete(int id) {
		int result=0;
		
		result = usersDao.delete(id);
		
		return result;
	}
	
	@Override
	public List<Users> getList(){
		return getList(1,"","");
	}
	@Override
	public List<Users> getList(String field, String query){
		return getList(1,field,query);
	}
	
	@Override
	public List<Users> getList(int page){
		return getList(page,"","");
	}
	@Override
	public List<Users> getList(int page, String field, String query) {
		List<Users> list = new ArrayList<>();
		
		int startIndex = 1+(page-1)*10;
		int endIndex = page*10;
		
		list = usersDao.getList(startIndex,endIndex,field,query);
		
		return list;
	}

	@Override
	public int delete(int[] id) {
		int result = 0;
		
		for(int i=0;i<id.length;i++) {
			result += usersDao.delete(id[i]);
		}
		return result;
	}
	
	@Override
	public int update(Users users) {
		int result = 0;
		
		result = usersDao.update(users);
		
		return result;
	}
	
	@Override
	public int getCount() {
		return getCount("","");
	}
	
	@Override
	public int getCount(String field, String query) {
		int result = 0;
		
		result = usersDao.getCount(field,query);
		
		return result;
	}
	
	@Override
	public ArrayList<Integer> getRankCount() {
		ArrayList<Integer> result = null;
		
		result = usersDao.getRankCount();
		
		return result;
	}
	
	@Override
	public int valid(String email, String password) {
		int result = 0;
		
		result = usersDao.valid(email,password);
		
		return result;
	}
	@Override
	public int checkDuplicate(String email) {
		int result=0;
		
		result = usersDao.checkDuplicate(email);
		
		return result;
		
	}
}
