package com.teum.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teum.entity.Member;

public class MemberDetailService {
	public Member getDetail(String email) {
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String dbid = "TEUM";
		String dbpwd = "4444";
		//String sql = "SELECT * FROM MEMBER";
		
		Member m = new Member();
		//DriverManager;//Class.forName~
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			String sql = "SELECT * FROM MEMBER WHERE EMAIL = ?";
			//Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				String birthday = rs.getString("birthday");
				String phone = rs.getString("phone");
				String type = rs.getString("type");
				int rank = rs.getInt("rank");
				Date regdate = rs.getDate("regdate");
				m.setName(name);
				m.setEmail(email);
				m.setBirthday(birthday);
				m.setPhone(phone);
				m.setType(type);
				m.setRank(rank);
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
}
