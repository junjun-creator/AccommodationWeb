package com.teum.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			     Date startDate = rs.getDate("START_DATE");
			     Date endDate 	= rs.getDate("END_DATE");
			     int pub 		= rs.getInt("PUB");
			     
			     Event e = new Event();
			     
			     e.setEventNo(eventNo);
			     e.setStatus(status);
			     e.setTitle(title);
			     e.setRegDate(regDate);
			     e.setStartDate(startDate);
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
	
	public Event getNo(int eventNo) {
		Event ev = null;
		
		String url = "jdbc:oracle:thin:@HI.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM EVENT WHERE EVENT_NO=" + eventNo;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "TEUM", "4444");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				 int status		= rs.getInt("STATUS");
			     String title 	= rs.getString("TITLE");
			     Date regDate 	= rs.getDate("REG_DATE");
			     Date startDate = rs.getDate("START_DATE");
			     Date endDate 	= rs.getDate("END_DATE");
			     int pub 		= rs.getInt("PUB");
			     
			     ev = new Event();
			     
			     ev.setEventNo(eventNo);
			     ev.setStatus(status);
			     ev.setTitle(title);
			     ev.setRegDate(regDate);
			     ev.setStartDate(startDate);
			     ev.setEndDate(endDate);
			     ev.setPub(pub);
			}
			
			//꼭 닫아줘야함!!! 안그럼 나중에 오류남
			rs.close();
			st.close();
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ev;
	}

	public int insert(Event event) {
		int result = 0;
		
		String url = "jdbc:oracle:thin:@HI.namoolab.com:1521/xepdb1";
		String sql = "INSERT INTO EVENT(TITLE) VALUES(?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "TEUM", "4444");
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, event.getTitle());
			
			result = pst.executeUpdate();
			
			//꼭 닫아줘야함!!! 안그럼 나중에 오류남
			pst.close();
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int update(Event ev) {
		int result = 0;
		
		String url = "jdbc:oracle:thin:@HI.namoolab.com:1521/xepdb1";
		String sql = "UPDATE EVENT SET TITLE=? WHERE EVENT_NO=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "TEUM", "4444");
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ev.getTitle());
			pst.setInt(2, ev.getEventNo());
			
			result = pst.executeUpdate();
			
			//꼭 닫아줘야함!!! 안그럼 나중에 오류남
			pst.close();
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
