package com.teum.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teum.entity.Member;

public class MemberService {
	public List<Member> getList(int t) {
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String dbid = "TEUM";
		String dbpwd = "4444";
		//String sql = "SELECT * FROM MEMBER";
		
		List<Member> list = new ArrayList<>();
		//DriverManager;//Class.forName~
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			String sql = "SELECT * FROM MEMBER WHERE TYPE = ?";
			//Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,t);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String pwd = rs.getString("pwd");
				String birthday = rs.getString("birthday");
				String phone = rs.getString("phone");
				int type = rs.getInt("type");
				int rank = rs.getInt("rank");
				Date regdate = rs.getDate("regdate");
				Member m = new Member();
				m.setId(id);
				m.setName(name);
				m.setEmail(email);
				m.setPwd(pwd);
				m.setBirthday(birthday);
				m.setPhone(phone);
				m.setType(type);
				m.setRank(rank);
				m.setRegdate(regdate);
				
				list.add(m);
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
}
