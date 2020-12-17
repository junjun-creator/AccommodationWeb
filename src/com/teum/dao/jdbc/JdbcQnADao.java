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
		
		String url = DBContext.URL;
		String sql = "UPDATE QNA SET TITLE=?,ANSWER_CONTENT=?,ANSWER_STATUS=? WHERE ID=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, qna.getTitle());
			st.setString(2, qna.getAnswerContent());
			st.setInt(3, qna.getAnswerStatus());
			st.setInt(4, qna.getId());
		
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

		return getViewList(1,3,"","");
	}

	@Override
	public List<QnAView> getViewList(int startIndex, int endIndex) {
		
		return getViewList(startIndex,endIndex,"","");
	}


	@Override
	public List<QnAView> getViewList(int startIndex, int endIndex, String category) {
		
		return getViewList(startIndex,endIndex,category,"");
	}
	@Override
	public List<QnAView> getViewList(int startIndex, int endIndex, String category, String query) {
		List<QnAView> list = new ArrayList<QnAView>();
		
		String sql = "SELECT * FROM (SELECT ROWNUM NUM, Q.* FROM QNA_LIST_FOR_ADMIN Q)\r\n" + 
				"WHERE NUM BETWEEN ? AND ? AND CATEGORY LIKE ? AND USER_NAME LIKE ?";
		String url = DBContext.URL;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			 
			st.setInt(1, startIndex); 
			st.setInt(2, endIndex);
			st.setString(3, "%"+category+"%");
			st.setString(4, "%"+query+"%");
			
			ResultSet rs = st.executeQuery();
			

			while(rs.next()) {
				 int id =rs.getInt("ID");
				 String userName =rs.getString("USER_NAME");
			     String title=rs.getString("TITLE");
			     Date regdate=rs.getDate("REGDATE");
			     int answerStatus =rs.getInt("ANSWER_STATUS");
			     String phone = rs.getString("PHONE");
			     String categoryType= rs.getString("CATEGORY");
			     
			     QnAView qv = new QnAView();
			     qv.setId(id);
			     qv.setUserName(userName);
			     qv.setTitle(title);
			     qv.setRegdate(regdate);
			     qv.setAnswerStatus(answerStatus);
			     qv.setPhone(phone);
			     qv.setCategoryType(categoryType);
			     
			     list.add(qv);
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
	public int getCount(String category, String query) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql ="SELECT COUNT(*) FROM qna_list_for_admin WHERE USER_NAME LIKE ? AND CATEGORY LIKE ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1,"%"+query+"%" );
			st.setString(2, "%"+category+"%");
			/*
			 * if(!query.equals("")) { st.setString(1,"%"+query+"%" ); }
			 */
			//ResultSet rs = st.executeQuery(sql); // select 문장에만
			ResultSet rs =st.executeQuery();//insert,update,delete 문장일 떄
			
			while(rs.next()) {
				result = rs.getInt(1);
			}
			
			
			st.close();
			con.close();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	

}
