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
			String sql = "INSERT INTO MEMBER(name,email,password,birthday,phone,rank_id) VALUES(?,?,?,?,?,?)";
			//Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,users.getName());
			ps.setString(2,users.getEmail());
			ps.setString(3,users.getPassword());
			ps.setString(4,users.getBirthday());
			ps.setString(5,users.getPhone());
			ps.setInt(6, users.getRankId());
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
			String sql = "DELETE FROM MEMBER WHERE id=?";
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
			String sql = "SELECT * FROM MEMBER WHERE id = ?";
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

	@Override
	public List<Users> getList() {
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		String sql = "SELECT * FROM MEMBER";
		
		List<Users> list = new ArrayList<>();
		//DriverManager;//Class.forName~
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//String sql = "SELECT * FROM MEMBER WHERE TYPE = ?";
			Statement st = con.createStatement();
			//PreparedStatement ps = con.prepareStatement(sql);
			//ps.setInt(1,t);
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String birthday = rs.getString("birthday");
				String phone = rs.getString("phone");
				int rankId = rs.getInt("rank_id");
				Date regdate = rs.getDate("regdate");
				Users u = new Users();
				u.setId(id);
				u.setName(name);
				u.setEmail(email);
				u.setBirthday(birthday);
				u.setPhone(phone);
				u.setRankId(rankId);
				u.setRegdate(regdate);
				
				list.add(u);
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return list;
	}

}
