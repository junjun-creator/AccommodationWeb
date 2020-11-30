package com.teum.service;

import java.sql.Connection;
import java.sql.DriverManager;
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
			     int pub =rs.getInt("PUB");
			     
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

}
