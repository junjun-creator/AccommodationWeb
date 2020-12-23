package com.teum.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.teum.dao.MemberDao;
import com.teum.dao.entity.Member;

public class JdbcMemberDao implements MemberDao {

	@Override
	public int valid(String email, String password) {
		int result = 0;
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "SELECT COUNT(*) FROM MEMBER_LIST WHERE EMAIL=? AND PASSWORD=?";
		
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

	@Override
	public Member get(String email, String password) {
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "SELECT * FROM MEMBER_LIST WHERE EMAIL=? AND PASSWORD=?";
		
		Member m = new Member();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String birthday = rs.getString("birthday");
				String phone = rs.getString("phone");
				int type = rs.getInt("type");
				Date regdate = rs.getDate("regdate");
				m.setId(id);
				m.setName(name);
				m.setEmail(email);
				m.setPassword(password);
				m.setBirthday(birthday);
				m.setPhone(phone);
				m.setType(type);
				m.setRegdate(regdate);
				
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return m;
	}

	@Override
	public String getEmail(String name, String phone) {
		String result = "";
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "SELECT EMAIL FROM MEMBER_LIST WHERE NAME=? AND PHONE=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,phone);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				result = rs.getString("email");
				
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
	public String getPwd(String name, String email, String phone) {
		String result = "";
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "SELECT PASSWORD FROM MEMBER_LIST WHERE NAME=? AND EMAIL=? AND PHONE=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3, phone);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				result = rs.getString("password");
				
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
