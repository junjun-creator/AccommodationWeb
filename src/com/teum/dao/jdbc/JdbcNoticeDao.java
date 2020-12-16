package com.teum.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teum.dao.NoticeDao;
import com.teum.entity.Notice;

public class JdbcNoticeDao implements NoticeDao {

	@Override
	public int insert(Notice notice) {
		int result =0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO NOTICE(TITLE,CONTENT,ADMIN_ID,OPEN_STATUS,IMAGE_NAME) VALUES(?,?,?,?,?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, notice.getTitle());
			st.setString(2, notice.getContent());
			st.setInt(3, notice.getAdminId());
			st.setInt(4, notice.getOpenStatus());
			st.setString(5, notice.getImageName());
			
		
			//ResultSet rs = st.executeQuery(sql); // select 문장에만
			result =st.executeUpdate();//insert,update,delete 문장일 떄
			
			st.close();
			con.close();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(Notice notice) {
		int result =0;
		
		String url = DBContext.URL;
		String sql = "UPDATE NOTICE SET TITLE=?,CONTENT=?,OPEN_STATUS=?,IMAGE_NAME=? WHERE ID=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, notice.getTitle());
			st.setString(2, notice.getContent());
			st.setInt(3, notice.getOpenStatus());
			st.setString(4, notice.getImageName());
			st.setInt(5, notice.getId());
		
			//ResultSet rs = st.executeQuery(sql); // select 문장에만
			result =st.executeUpdate();//insert,update,delete 문장일 떄
			
			st.close();
			con.close();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(int id) {
		int result =0;
		
		String url = DBContext.URL;
		String sql = "DELETE FROM NOTICE WHERE ID=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st =con.prepareStatement(sql);
			
			st.setInt(1, id);
		
			//ResultSet rs = st.executeQuery(sql); // select 문장에만
			result =st.executeUpdate();//insert,update,delete 문장일 떄
			
			st.close();
			con.close();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Notice get(int id) {
		Notice n = null ;
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM NOTICE where ID="+id;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			

			if(rs.next()) {
				//int id =rs.getInt("ID");
			     String title=rs.getString("TITLE");
			     int adminId =rs.getInt("ADMIN_ID");
			     String content=rs.getString("CONTENT");
			     Date regdate=rs.getDate("REGDATE");
			     int openStatus =rs.getInt("OPEN_STATUS");
			     String imageName =rs.getString("IMAGE_NAME");
			 	 String imageRoute =rs.getString("IMAGE_ROUTE");;
			     
			     n = new Notice(
			    		 id,
			    		 title,
			    		 adminId,
			    		 content,
			    		 regdate,
			    		 openStatus,
			    		 imageName,
			    		 imageRoute);
				}

			
			rs.close();
			st.close();
			con.close();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public List<Notice> getList() {
		List<Notice>list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM NOTICE ";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			

			while(rs.next()) {
				 int id =rs.getInt("ID");
			     String title=rs.getString("TITLE");
			     int adminId =rs.getInt("ADMIN_ID");
			     String content=rs.getString("CONTENT");
			     Date regdate=rs.getDate("REGDATE");
			     int openStatus =rs.getInt("OPEN_STATUS");
			     
			     Notice n = new Notice();
			     n.setId(id);
			     n.setTitle(title);
			     n.setAdminId(adminId);
			     n.setContent(content);
			     n.setRegdate(regdate);
			     n.setOpenStatus(openStatus);
			     
			     list.add(n);
				}

			
			rs.close();
			st.close();
			con.close();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Notice getLast() {
		Notice n = null ;
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM NOTICE WHERE ID=(SELECT MAX(ID) FROM NOTICE)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			

			if(rs.next()) {
				int id =rs.getInt("ID");
			     String title=rs.getString("TITLE");
			     int adminId =rs.getInt("ADMIN_ID");
			     String content=rs.getString("CONTENT");
			     Date regdate=rs.getDate("REGDATE");
			     int openStatus =rs.getInt("OPEN_STATUS");
			     String imageName =rs.getString("IMAGE_NAME");
			 	 String imageRoute =rs.getString("IMAGE_ROUTE");;
			     
			     n = new Notice(
			    		 id,
			    		 title,
			    		 adminId,
			    		 content,
			    		 regdate,
			    		 openStatus,
			    		 imageName,
			    		 imageRoute);
				}

			
			rs.close();
			st.close();
			con.close();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public List<Notice> getUserList() {
List<Notice>list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM NOTICE WHERE OPEN_STATUS=1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			

			while(rs.next()) {
				 int id =rs.getInt("ID");
			     String title=rs.getString("TITLE");
			     int adminId =rs.getInt("ADMIN_ID");
			     String content=rs.getString("CONTENT");
			     Date regdate=rs.getDate("REGDATE");
			     int openStatus =rs.getInt("OPEN_STATUS");
			     
			     Notice n = new Notice();
			     n.setId(id);
			     n.setTitle(title);
			     n.setAdminId(adminId);
			     n.setContent(content);
			     n.setRegdate(regdate);
			     n.setOpenStatus(openStatus);
			     
			     list.add(n);
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
