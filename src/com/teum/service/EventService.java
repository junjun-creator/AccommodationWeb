package com.teum.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teum.entity.Event;;

public class EventService {

	public List<Event> getList() {
		List<Event> list = new ArrayList<>();
		
		String url = "jdbc:oracle:thin:@HI.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM EVENT";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "TEUM", "4444");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				 int eventNo 	= rs.getInt("EVENT_NO");
				 int status		= rs.getInt("STATUS");
			     String title 	= rs.getString("TITLE");
			     Date regDate 	= rs.getDate("REG_DATE");
			     Date endDate 	= rs.getDate("END_DATE");
			     int pub 		= rs.getInt("PUB");
			     
			     Event e = new Event();
			     
			     e.setEventNo(eventNo);
			     e.setStatus(status);
			     e.setTitle(title);
			     e.setRegDate(regDate);
			     e.setEndDate(endDate);
			     e.setPub(pub);
			     
			     list.add(e);
			}
			
			//꼭 닫아줘야함!!! 안그럼 나중에 오류남
			rs.close();
			st.close();
			con.close();
			

		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
