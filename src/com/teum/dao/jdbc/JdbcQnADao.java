package com.teum.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teum.dao.QnADao;
import com.teum.dao.entity.QnAView;
import com.teum.entity.QnA;

public class JdbcQnADao implements QnADao {

	@Override
	public int insert(QnA qna) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(QnA qna) {
		int result =0;
		
		return result;
	}

	@Override
	public int delete(int id) {
		int result =0;
		
		String url =  DBContext.URL;
		String sql = "DELETE FROM QNA WHERE ID=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,  DBContext.UID, DBContext.PWD);
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
	public QnA get(int id) {
		QnA q = null;
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM QNA where ID="+id;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			

			if(rs.next()) {
				 //int id =rs.getInt("ID");
			     String title=rs.getString("TITLE");
			     String content=rs.getString("CONTENT");
			     Date regdate=rs.getDate("REGDATE");
			     int categoryId =rs.getInt("CATEGORY_ID");
			     int adminId =rs.getInt("ADMIN_ID");
			     int answerStatus =rs.getInt("ANSWER_STATUS");
			     int userId =rs.getInt("USER_ID");
			     Date answerRegdate=rs.getDate("ANSWER_REGDATE");
			     String answerContent =rs.getString("ANSWER_CONTENT");
			    
			     
			     q = new QnA(
			    		 id,
					     title,
					     content,
					     regdate,
					     categoryId,
					     adminId,
					     answerStatus,
					     userId,
					     answerRegdate,
					     answerContent
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

	@Override
	public List<QnA> getList() {
		List<QnA>list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM QNA ";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,  DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			

			while(rs.next()) {
				 int id =rs.getInt("ID");
			     String title=rs.getString("TITLE");
			     String content=rs.getString("CONTENT");
			     Date regdate=rs.getDate("REGDATE");
			     int categoryId =rs.getInt("CATEGORY_ID");
			     int adminId =rs.getInt("ADMIN_ID");
			     int answerStatus =rs.getInt("ANSWER_STATUS");
			     int userId =rs.getInt("USER_ID");
			     Date answerRegdate=rs.getDate("ANSWER_REGDATE");
			     String answerContent =rs.getString("ANSWER_CONTENT");
			     
			     QnA q = new QnA();
			     q.setId(id);
			     q.setTitle(title);
			     q.setContent(content);
			     q.setRegdate(regdate);
			     q.setCategoryId(categoryId);
			     q.setAdminId(adminId);
			     q.setAnswerStatus(answerStatus);
			     q.setUserId(userId);
			     q.setAnswerRegdate(answerRegdate);
			     q.setContent(answerContent);
			   
			     
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

	@Override
	public List<QnAView> getViewList() {
		// TODO Auto-generated method stub
		return getViewList(1,10,"");
	}

	@Override
	public List<QnAView> getViewList(int startIndex, int endIndex) {
		// TODO Auto-generated method stub
		return getViewList(startIndex,endIndex,"");
	}


	@Override
	public List<QnAView> getViewList(int startIndex, int endIndex, String category) {
		
		List<QnAView> list = new ArrayList<QnAView>();
		
		String sql = "SELECT * FROM QNA_LIST_FOR_ADMIN";
		String url = DBContext.URL;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			

			while(rs.next()) {
				 int id =rs.getInt("ID");
				 String userName =rs.getString("USER_NAME");
			     String title=rs.getString("TITLE");
			     Date regdate=rs.getDate("REGDATE");
			     int answerStatus =rs.getInt("ANSWER_STATUS");
			     String phone = rs.getString("PHONE");
			     String categoryType= rs.getString("CATEGORY");
			     
			     QnAView QnA = new QnAView(
			    		 id,
			    		 userName,
					     title,
					     regdate,
					     answerStatus,
					     phone,
					     categoryType
					     );
			     
			     list.add(QnA);
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
