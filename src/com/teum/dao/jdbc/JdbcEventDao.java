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
import com.teum.dao.entity.EventView;
import com.teum.entity.Event;
import com.teum.entity.Event;


public class JdbcEventDao implements EventDao {

	@Override
	public int insert(Event event) {
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
	public int update(Event event) {
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
	public Event get(int id) {
		Event event = null;
		
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
			     int adminId	= rs.getInt("ADMIN_ID");
			     
			     event = new Event();
			     event.setId(id);
			     event.setOpenStatus(openStatus);
			     event.setImageName(imageName);
			     event.setImageRoute(imageRoute);
			     event.setStatus(status);
			     event.setTitle(title);
			     event.setStartDate(startDate);
			     event.setEndDate(endDate);
			     event.setRegdate(regdate);
			     event.setAdminId(adminId);
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
	public List<Event> getList(int startIndex, int endIndex, String query) {
		List<Event> list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = "SELECT NUM, ID, TITLE, OPEN_STATUS, STATUS, TO_CHAR(END_DATE, 'YYYY-MM-DD') END_DATE, TO_CHAR(REGDATE, 'YYYY-MM-DD') REGDATE" + 
					"FROM (" + 
					"    SELECT ROWNUM NUM, E.*" + 
					"    FROM (" + 
					"        SELECT * FROM EVENT ORDER BY REGDATE DESC" + 
					"    ) E" + 
					" )" + 
					" WHERE NUM BETWEEN ? AND ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setInt(1, startIndex);
			pst.setInt(2, endIndex);
			//pst.setString(1, query);
			
			ResultSet rs = pst.executeQuery();
			
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
			     int adminId	= rs.getInt("ADMIN_ID");
			     
			     Event event = new Event();
			     
			     event.setId(id);
			     event.setOpenStatus(openStatus);
			     event.setImageName(imageName);
			     event.setImageRoute(imageRoute);
			     event.setStatus(status);
			     event.setTitle(title);
			     event.setStartDate(startDate);
			     event.setEndDate(endDate);
			     event.setRegdate(regdate);
			     event.setAdminId(adminId);
			     
			     list.add(event);
			}
			
			//꼭 닫아줘야함!!! 안그럼 나중에 오류남
			rs.close();
			pst.close();
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Event> getList(int startIndex, int endIndex) {
		return getList(startIndex, endIndex, "");
	}

	@Override
	public List<Event> getList() {
		return getList(1, 10, "");
	}

	@Override
	public List<EventView> getViewList(int startIndex, int endIndex, String query) {
		List<EventView> list = new ArrayList<EventView>();
		
		String sql = "SELECT * FROM EVENT_VIEW WHERE";
		
		String url = DBContext.URL;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setInt(1, startIndex);
			pst.setInt(2, endIndex);
			
			ResultSet rs = pst.executeQuery();
			
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
			     int adminId	= rs.getInt("ADMIN_ID");
			     
			     EventView event = new EventView(id, title, openStatus, imageName, imageRoute,
			    		 status, startDate, endDate, regdate, adminId);
			     
			     list.add(event);
			}
			
			//꼭 닫아줘야함!!! 안그럼 나중에 오류남
			rs.close();
			pst.close();
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<EventView> getViewList(int startIndex, int endIndex) {
		return getViewList(startIndex, endIndex, "");
	}

	@Override
	public List<EventView> getViewList() {
		
		return getViewList(1, 10, "");
	}


}
