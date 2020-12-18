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
import com.teum.dao.entity.EventListView;
import com.teum.entity.Event;

public class JdbcEventDao implements EventDao {

	@Override
	public int insert(Event event) {
		int result = 0;

		String url = DBContext.URL;
		String sql = "INSERT INTO EVENT(TITLE, OPEN_STATUS, START_DATE, END_DATE, IMAGE_NAME, IMAGE_ROUTE, ADMIN_ID) VALUES(?, ?, ?, ?, ?, ?, ?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, event.getTitle());
			pst.setInt(2, event.getOpenStatus());
			pst.setDate(3, new java.sql.Date(event.getStartDate().getTime()));
			pst.setDate(4, new java.sql.Date(event.getEndDate().getTime()));
			pst.setString(5, event.getImageName());
			pst.setString(6, event.getImageRoute());
			pst.setInt(7, 1);

			result = pst.executeUpdate();

			// 꼭 닫아줘야함!!! 안그럼 나중에 오류남
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
		String sql = "UPDATE EVENT SET TITLE=?, OPEN_STATUS=?, START_DATE=?, END_DATE=?, IMAGE_NAME=?, IMAGE_ROUTE=?, ADMIN_ID=? WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, event.getTitle());
			pst.setInt(2, event.getOpenStatus());
			pst.setDate(3, new java.sql.Date(event.getStartDate().getTime()));
			pst.setDate(4, new java.sql.Date(event.getEndDate().getTime()));
			pst.setString(5, event.getImageName());
			pst.setString(6, event.getImageRoute());
			pst.setInt(7, 1);
			pst.setInt(8, event.getId());

			result = pst.executeUpdate();

			// 꼭 닫아줘야함!!! 안그럼 나중에 오류남
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

			// 꼭 닫아줘야함!!! 안그럼 나중에 오류남
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

			if (rs.next()) {
				String title = rs.getString("TITLE");
				int openStatus = rs.getInt("OPEN_STATUS");
				String imageName = rs.getString("IMAGE_NAME");
				String imageRoute = rs.getString("IMAGE_ROUTE");
				int status = rs.getInt("STATUS");
				Date startDate = rs.getDate("START_DATE");
				Date endDate = rs.getDate("END_DATE");
				Date regdate = rs.getDate("REGDATE");
				int adminId = rs.getInt("ADMIN_ID");

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

			// 꼭 닫아줘야함!!! 안그럼 나중에 오류남
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
	public List<Event> getList(int startIndex, int endIndex, String search) {
		List<Event> list = new ArrayList<>();

		String url = DBContext.URL;
		String sql = "SELECT * FROM EVENT_LIST_VIEW " + "WHERE NUM BETWEEN ? AND ? AND TITLE LIKE ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(1, startIndex);
			pst.setInt(2, endIndex);
			pst.setString(3, "%" + search + "%");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int rownum = rs.getInt("NUM");
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				int openStatus = rs.getInt("OPEN_STATUS");
				int status = rs.getInt("STATUS");
				Date startDate = rs.getDate("START_DATE");
				Date endDate = rs.getDate("END_DATE");
				Date regdate = rs.getDate("REGDATE");

				EventListView event = new EventListView();

				event.setRownum(rownum);
				event.setId(id);
				event.setOpenStatus(openStatus);
				event.setStatus(status);
				event.setTitle(title);
				event.setStartDate(startDate);
				event.setEndDate(endDate);
				event.setRegdate(regdate);

				list.add(event);
			}

			// 꼭 닫아줘야함!!! 안그럼 나중에 오류남
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
	public List<EventListView> getViewList(int startIndex, int endIndex, String search) {
		List<EventListView> list = new ArrayList<EventListView>();

		String sql = "SELECT * FROM EVENT_LIST_VIEW WHERE NUM BETWEEN ? AND ? AND TITLE LIKE ?";

		String url = DBContext.URL;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(1, startIndex);
			pst.setInt(2, endIndex);
			pst.setString(3, "%" + search + "%");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int rownum = rs.getInt("NUM");
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				int openStatus = rs.getInt("OPEN_STATUS");
				int status = rs.getInt("STATUS");
				Date startDate = rs.getDate("START_DATE");
				Date endDate = rs.getDate("END_DATE");
				Date regdate = rs.getDate("REGDATE");
				String imageName = rs.getString("IMAGE_NAME");
				String imageRoute = rs.getString("IMAGE_ROUTE");
				
				EventListView event = new EventListView();
				
				event.setRownum(rownum);
				event.setId(id);
				event.setTitle(title);
				event.setOpenStatus(openStatus);
				event.setStatus(status);
				event.setStartDate(startDate);
				event.setEndDate(endDate);
				event.setRegdate(regdate);
				event.setImageName(imageName);
				event.setImageRoute(imageRoute);

				list.add(event);
			}

			// 꼭 닫아줘야함!!! 안그럼 나중에 오류남
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
	public List<EventListView> getViewList(int startIndex, int endIndex) {
		return getViewList(startIndex, endIndex, "");
	}

	@Override
	public List<EventListView> getViewList() {
		return getViewList(1, 10, "");
	}

	@Override
	public Event getLast() {
		// 마지막 인덱스의 event를 뽑아오는 쿼리문을 작성하자
		Event event = null;

		String url = DBContext.URL;
		String sql = "SELECT * FROM EVENT WHERE ID = (SELECT MAX(ID) FROM EVENT)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				int openStatus = rs.getInt("OPEN_STATUS");
				String imageName = rs.getString("IMAGE_NAME");
				String imageRoute = rs.getString("IMAGE_ROUTE");
				int status = rs.getInt("STATUS");
				Date startDate = rs.getDate("START_DATE");
				Date endDate = rs.getDate("END_DATE");
				Date regdate = rs.getDate("REGDATE");
				int adminId = rs.getInt("ADMIN_ID");

				event = new Event(
						id, title, openStatus, imageName, 
						imageRoute, status, startDate, 
						endDate, regdate, adminId);
			}
			System.out.printf("가져온 id: %d", event.getId());
			// 꼭 닫아줘야함!!! 안그럼 나중에 오류남
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
	public int openAll(String oIdsCSV, String cIdsCSV) {
		int result = 0;

		String url = DBContext.URL;
		String openSql = String.format("UPDATE EVENT SET OPEN_STATUS = 1 WHERE ID IN (%s)", oIdsCSV);
		String closeSql = String.format("UPDATE EVENT SET OPEN_STATUS = 0 WHERE ID IN (%s)", cIdsCSV);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement openSt = con.createStatement();
			result += openSt.executeUpdate(openSql);
			
			Statement closeSt = con.createStatement();
			result += closeSt.executeUpdate(closeSql);
			
			openSt.close();
			closeSt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int getCount(String search) {
		int result = 0;

		String url = DBContext.URL;
		String sql = "SELECT COUNT(*) COUNT FROM EVENT WHERE TITLE LIKE ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, "%" + search + "%");
			
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				result = rs.getInt(1);
			}
			System.out.println(result);

			rs.close();
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
	public int getId() {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "SELECT EVENT_ID_SEQ.NEXTVAL FROM DUAL";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				result = rs.getInt(1);
			}
			System.out.println(result);

			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
