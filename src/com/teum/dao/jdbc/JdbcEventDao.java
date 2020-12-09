package com.teum.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teum.dao.EventDao;
import com.teum.entity.Event;
import com.teum.entity.Event2;


public class JdbcEventDao implements EventDao {

	@Override
	public int insert(Event2 event) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO EVENT(TITLE) VALUES(?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
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

	@Override
	public int update(Event2 event) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "UPDATE EVENT SET TITLE=? WHERE ID=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, event.getTitle());
			pst.setInt(2, event.getId());
			
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

	@Override
	public int delete(int id) {
		int result = 0;
		
		String url = "jdbc:oracle:thin:@HI.namoolab.com:1521/xepdb1";
		String sql = "DELETE FROM EVENT WHERE ID=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			
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

	@Override
	public Event2 get(int id) {
		Event2 event = null;
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM EVENT WHERE ID=" + id;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				 String title 	= rs.getString("TITLE");
				 int openStatus = rs.getInt("OPEN_STATUS");
				 String imageName = rs.getString("IMAGE_NAME");
				 String imageRoute = rs.getString("IMAGE_ROUTE");
				 int status		= rs.getInt("STATUS");
				 Date startDate = rs.getDate("START_DATE");
			     Date endDate 	= rs.getDate("END_DATE");
			     Date regdate 	= rs.getDate("REGDATE");
			     
			     event = new Event2();
			     event.setId(id);
			     event.setOpenStatus(openStatus);
			     event.setImageName(imageName);
			     event.setImageRoute(imageRoute);
			     event.setStatus(status);
			     event.setTitle(title);
			     event.setStartDate(startDate);
			     event.setEndDate(endDate);
			     event.setRegdate(regdate);
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
		return event;
	}

	@Override
	public List<Event2> getList() {
		List<Event2> list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM EVENT";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				 int id 		= rs.getInt("ID");
				 String title 	= rs.getString("TITLE");
				 int openStatus = rs.getInt("OPEN_STATUS");
				 String imageName = rs.getString("IMAGE_NAME");
				 String imageRoute = rs.getString("IMAGE_ROUTE");
				 int status		= rs.getInt("STATUS");
				 Date startDate = rs.getDate("START_DATE");
				 Date endDate 	= rs.getDate("END_DATE");
			     Date regdate 	= rs.getDate("REGDATE");
			     
			     Event2 event = new Event2();
			     
			     event.setId(id);
			     event.setOpenStatus(openStatus);
			     event.setImageName(imageName);
			     event.setImageRoute(imageRoute);
			     event.setStatus(status);
			     event.setTitle(title);
			     event.setStartDate(startDate);
			     event.setEndDate(endDate);
			     event.setRegdate(regdate);
			     
			     list.add(event);
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
		return list;
	}


}
