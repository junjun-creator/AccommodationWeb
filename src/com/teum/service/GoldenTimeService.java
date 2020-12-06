package com.teum.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teum.entity.GoldenTime;


public class GoldenTimeService {
	public List<GoldenTime> getList() {
		List<GoldenTime>list = new ArrayList<>();
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM GOLDENTIME ";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "TEUM", "4444");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			

			while(rs.next()) {
				 int id =rs.getInt("ID");
			     String name=rs.getString("NAME");
			     String accName=rs.getString("ACC_NAME");
			     String location=rs.getString("LOCATION");
			     Date regdate=rs.getDate("REGDATE");
			     String phone =rs.getString("phone");
			     String email =rs.getString("EMAIL");
			     String accType =rs.getString("ACC_TYPE");
			     int registration =rs.getInt("registration");
			     
			     GoldenTime gt = new GoldenTime();
			     
			     gt.setId(id);
			     gt.setName(accName);
			     gt.setAccName(accName);
			     gt.setLocation(location);
			     gt.setRegdate(regdate);
			     gt.setPhone(phone);
			     gt.setEmail(email);
			     gt.setAccType(accType);
			     gt.setRegistration(registration);
			     
			     list.add(gt);
				}

			
			rs.close();
			st.close();
			con.close();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
