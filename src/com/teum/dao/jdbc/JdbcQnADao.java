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
import com.teum.dao.entity.PrivateQnaView;
import com.teum.dao.entity.PrivateReservationListView;
import com.teum.dao.entity.QnAView;
import com.teum.entity.QnA;

public class JdbcQnADao implements QnADao {

	@Override
	public int insert(QnA qna) {
	int result =0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO QNA(TITLE,CONTENT,USER_ID,ADMIN_ID,CATEGORY_ID) VALUES(?,?,?,?,?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, qna.getTitle());
			st.setString(2, qna.getContent());
			st.setInt(3, qna.getUserId());
			st.setInt(4, 1);
			st.setInt(5, qna.getCategoryId());
			
		
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
		
		String sql = "SELECT * FROM\r\n" + 
				"(SELECT ROWNUM NUM, Q.* FROM QNA_LIST_FOR_ADMIN Q WHERE CATEGORY LIKE ? AND USER_NAME LIKE ?)\r\n" + 
				"WHERE NUM BETWEEN ? AND ?";
		String url = DBContext.URL;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			 
			st.setString(1, "%"+category+"%");
			st.setString(2, "%"+query+"%");
			st.setInt(3, startIndex); 
			st.setInt(4, endIndex);
			
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
			     qv.setCategory(categoryType);
			     
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

	@Override
	public List<QnA> getList(int id) {
		List<QnA>list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM QNA where user_id ="+id+"and answer_status=1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,  DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			

			while(rs.next()) {
				 int id2 =rs.getInt("ID");
			     String title=rs.getString("TITLE");
			     String content=rs.getString("CONTENT");
			     int userId =rs.getInt("USER_ID");
			     Date answerRegdate=rs.getDate("ANSWER_REGDATE");
			     String answerContent =rs.getString("ANSWER_CONTENT");
			     
			     QnA q = new QnA();
			     q.setId(id2);
			     q.setTitle(title);
			     q.setContent(content);
			     q.setUserId(userId);
			     q.setAnswerRegdate(answerRegdate);
			     q.setAnswerContent(answerContent);
			   
			     
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
	public List<PrivateQnaView> getPrivateList(int userId, int startIndex, int endIndex) {
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "SELECT * FROM (SELECT ROWNUM NUM, PRIVATE_QNA_VIEW.* FROM PRIVATE_QNA_VIEW WHERE USER_ID=?) WHERE NUM BETWEEN ? AND ?";
		
		List<PrivateQnaView> list = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, dbid, dbpwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, startIndex);
			ps.setInt(3, endIndex);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int rownum = rs.getInt("num");
				int qnaId = rs.getInt("qna_id");
				String userName = rs.getString("user_name");
				String title = rs.getString("title");
				String phone = rs.getString("phone");
				Date regdate = rs.getDate("regdate");
				int answerStatus = rs.getInt("answer_status");
				
				PrivateQnaView pqv= new PrivateQnaView();
				pqv.setRownum(rownum);
				pqv.setQnaId(qnaId);
				pqv.setUserName(userName);
				pqv.setTitle(title);
				pqv.setPhone(phone);
				pqv.setRegdate(regdate);
				pqv.setAnswerStatus(answerStatus);
				
				list.add(pqv);
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int getPrivateCount(int userId) {

		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "SELECT COUNT(*) FROM PRIVATE_QNA_VIEW WHERE USER_ID=?";
		
		int result = 0;
		
		//DriverManager;//Class.forName~
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//String sql = "SELECT * FROM MEMBER WHERE TYPE = ?";
			//PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,userId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt(1);
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		
		return result;
	}

	

}
