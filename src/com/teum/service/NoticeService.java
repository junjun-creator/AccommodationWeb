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
			     String writerId=rs.getString("WRITER_ID");
			     String content=rs.getString("CONTENT");
			     Date regdate=rs.getDate("REGDATE");
			     String pub =rs.getString("PUB");
			     
			     Notice n = new Notice();
			     n.setId(id);
			     n.setTitle(title);
			     n.setWriterId(writerId);
			     n.setContent(content);
			     n.setRegdate(regdate);
			     n.setPub(pub);
			     
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
			     String writerId=rs.getString("WRITER_ID");
			     String content=rs.getString("CONTENT");
			     Date regdate=rs.getDate("REGDATE");
			     String pub =rs.getString("PUB");
			     
			     n = new Notice(
			    		 id,
			    		 title,
			    		 writerId,
			    		 content,
			    		 regdate,
			    		 pub);
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
		String sql = "INSERT INTO NOTICE(TITLE,CONTENT,PUB) VALUES(?,?,?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "TEUM", "4444");
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, notice.getTitle());
			st.setString(2, notice.getContent());
			st.setString(3, notice.getPub());
		
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
