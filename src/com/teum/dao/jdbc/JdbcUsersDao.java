package com.teum.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teum.dao.UsersDao;
import com.teum.dao.entity.UsersListView;
import com.teum.entity.Member;
import com.teum.entity.Users;

public class JdbcUsersDao implements UsersDao {

	@Override
	public int insert(Users users) {
		int result=0;
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		//String sql = "SELECT * FROM MEMBER";
		
		List<Users> list = new ArrayList<>();
		//DriverManager;//Class.forName~
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			String sql = "INSERT INTO USERS(name,email,password,birthday,phone) VALUES(?,?,?,?,?)";
			//Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,users.getName());
			ps.setString(2,users.getEmail());
			ps.setString(3,users.getPassword());
			ps.setString(4,users.getBirthday());
			ps.setString(5,users.getPhone());
			result = ps.executeUpdate();
			
			
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int update(Users users) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		int result=0;
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		//String sql = "SELECT * FROM MEMBER";
		
		List<Member> list = new ArrayList<>();
		//DriverManager;//Class.forName~
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			String sql = "DELETE FROM USERS WHERE id=?";
			//Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			result = ps.executeUpdate();
			
			
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Users get(int id) {
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String dbid = "TEUM";
		String dbpwd = "4444";
		//String sql = "SELECT * FROM MEMBER";
		
		Users u = new Users();
		//DriverManager;//Class.forName~
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			String sql = "SELECT * FROM USERS WHERE id = ?";
			//Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String birthday = rs.getString("birthday");
				String phone = rs.getString("phone");
				int rankId = rs.getInt("rank_id");
				Date regdate = rs.getDate("regdate");
				u.setId(id);
				u.setName(name);
				u.setEmail(email);
				u.setBirthday(birthday);
				u.setPhone(phone);
				u.setRankId(rankId);
				u.setRegdate(regdate);
				
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return u;
	}
	
//	@Override
//	public int getCount() {
//		
//		return getCount("","");
//	}
	
	@Override
	public int getCount(String field, String query) {
		int result = 0;
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "SELECT COUNT(*) FROM USERS WHERE "+field + " LIKE ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//String sql = "SELECT * FROM MEMBER WHERE TYPE = ?";
			//PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,"%"+query+"%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt(1);
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	@Override
	public ArrayList<Integer> getRankCount() {
		ArrayList<Integer> result = new ArrayList<>();
		
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "SELECT COUNT(id),RANK_ID FROM USERS GROUP BY RANK_ID";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//String sql = "SELECT * FROM MEMBER WHERE TYPE = ?";
			//PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int i=0;
			while(rs.next()) {
				result.add(Integer.parseInt(rs.getString("count(id)")));
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Users> getList() {
		return getList(1,10,"","");
	}
	@Override
	public List<Users> getList(int startIndex, int endIndex) {
		return getList(startIndex,endIndex,"","");
	}

	@Override
	public List<Users> getList(int startIndex, int endIndex,String field, String query) {
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		String sql = "SELECT * FROM (" +
				"SELECT ROWNUM NUM, U.* " +
				"FROM (SELECT * FROM USERS WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) U) "+
				"WHERE NUM BETWEEN ? AND ?";
				
//		
//		if(!field.equals("")) {
//			String sql_ = " AND "+ field + " LIKE ?";
//			sql = sql + sql_;
//		}
//		
//		System.out.println(startIndex);
//		System.out.println(endIndex);
//		System.out.println(text);
		List<Users> list = new ArrayList<>();
		//DriverManager;//Class.forName~
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//String sql = "SELECT * FROM MEMBER WHERE TYPE = ?";
			//PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,"%"+query+"%");
			ps.setInt(2, startIndex);
			ps.setInt(3, endIndex);
//			if(!field.equals("")) {
//			}
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int rownum = rs.getInt("num");
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String birthday = rs.getString("birthday");
				String phone = rs.getString("phone");
				int rankId = rs.getInt("rank_id");
				Date regdate = rs.getDate("regdate");
				int type = rs.getInt("type");
				UsersListView u = new UsersListView();
				u.setRownum(rownum);
				u.setId(id);
				u.setName(name);
				u.setEmail(email);
				u.setBirthday(birthday);
				u.setPhone(phone);
				u.setRankId(rankId);
				u.setRegdate(regdate);
				u.setType(type);
				
				list.add(u);
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int valid(String email, String password) {
		int result = 0;
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "SELECT COUNT(*) FROM USERS WHERE EMAIL=? AND PASSWORD=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//String sql = "SELECT * FROM MEMBER WHERE TYPE = ?";
			//PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt(1);
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	

}
