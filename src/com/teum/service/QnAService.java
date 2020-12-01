package com.teum.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teum.entity.QnA;

public class QnAService {
	public List<QnA> getList() {
		List<QnA>list = new ArrayList<>();
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM QNA ";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "TEUM", "4444");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			

			while(rs.next()) {
				 int id =rs.getInt("ID");
				 String name =rs.getString("NAME");
			     String title=rs.getString("TITLE");
			     String content=rs.getString("CONTENT");
			     String phone=rs.getString("phone");
			     Date regdate=rs.getDate("REGDATE");
			     int answer =rs.getInt("answer");
			     
			     QnA q = new QnA();
			     q.setId(id);
			     q.setName(name);
			     q.setTitle(title);
			     q.setContent(content);
			     q.setPhone(phone);
			     q.setRegdate(regdate);
			     q.setAnswer(answer);
			     
			     list.add(q);
				}

			
			rs.close();
			st.close();
			con.close();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public QnA get(int id) {
		QnA q = null;
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM QNA where ID="+id;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "TEUM", "4444");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			

			if(rs.next()) {
				 //int id =rs.getInt("ID");
				 String name =rs.getString("NAME");
			     String title=rs.getString("TITLE");
			     String content=rs.getString("CONTENT");
			     String phone=rs.getString("phone");
			     Date regdate=rs.getDate("REGDATE");
			     int answer =rs.getInt("answer");
			     
			     q = new QnA(
			    		 id,
					     name,
					     title,
					     content,
					     phone,
					     regdate,
					     answer
					     );
			     
				}

			
			rs.close();
			st.close();
			con.close();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return q;
	}
}
