package com.teum.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teum.entity.Notice;


public class NoticeService {
	public List<Notice> getList() {
		List<Notice>list = new ArrayList<>();
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE ";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "TEUM", "4444");
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
	public Notice get(int id) {
		Notice n = null ;
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE where ID="+id;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "TEUM", "4444");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			

			if(rs.next()) {
				//int id =rs.getInt("ID");
			     String title=rs.getString("TITLE");
			     int adminId =rs.getInt("ADMIN_ID");
			     String content=rs.getString("CONTENT");
			     Date regdate=rs.getDate("REGDATE");
			     int openStatus =rs.getInt("OPEN_STATUS");
			     
			     n = new Notice(
			    		 id,
			    		 title,
			    		 adminId,
			    		 content,
			    		 regdate,
			    		 openStatus);
				}

			
			rs.close();
			st.close();
			con.close();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return n;
	}
	public int insert(Notice notice) {
		int result =0;
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "INSERT INTO NOTICE(TITLE,CONTENT,WRITER_ID,PUB) VALUES(?,?,?,?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "TEUM", "4444");
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, notice.getTitle());
			st.setString(2, notice.getContent());
			st.setString(3, notice.getWriterId());
			st.setString(4, notice.getPub());
		
			//ResultSet rs = st.executeQuery(sql); // select 문장에만
			result =st.executeUpdate();//insert,update,delete 문장일 떄
			
			st.close();
			con.close();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
		
	}
	public int update(Notice notice) {
		int result =0;
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "UPDATE NOTICE SET TITLE=?,CONTENT=?,PUB=? WHERE ID=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "TEUM", "4444");
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, notice.getTitle());
			st.setString(2, notice.getContent());
			st.setString(3, notice.getPub());
			st.setInt(4, notice.getId());
		
			//ResultSet rs = st.executeQuery(sql); // select 문장에만
			result =st.executeUpdate();//insert,update,delete 문장일 떄
			
			st.close();
			con.close();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
		
	}
	public int delete(int id) {
		int result =0;
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "DELETE FROM NOTICE WHERE ID=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "TEUM", "4444");
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
	
}
