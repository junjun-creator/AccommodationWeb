package com.teum.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teum.dao.ReservationDao;
import com.teum.dao.entity.OfferInfoView;
import com.teum.dao.entity.ReservationDetailView;
import com.teum.dao.entity.ReservationForCompanyView;
import com.teum.dao.entity.ReservationListView;
import com.teum.dao.entity.ReviewView;
import com.teum.entity.Notice;
import com.teum.entity.Reservation;

public class JdbcReservationDao implements ReservationDao {

	@Override
	public List<ReservationListView> getListByUser(int startIndex, int endIndex,int id) {
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "SELECT * FROM (SELECT ROWNUM NUM, RLV.* FROM RESERVATION_LIST_VIEW RLV) WHERE NUM BETWEEN ? AND ? AND USER_ID=?";
		
		List<ReservationListView> list = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//String sql = "SELECT * FROM MEMBER WHERE TYPE = ?";
			//PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,startIndex);
			ps.setInt(2,endIndex);
			ps.setInt(3,id);
//			if(!field.equals("")) {
//			}
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int reservationId = rs.getInt("id");
				int userId = rs.getInt("user_id");
				int accId = rs.getInt("acc_id");
				int roomId = rs.getInt("room_id");
				int price = rs.getInt("price");
				Date checkinDate = rs.getDate("checkin_date");
				Date checkoutDate = rs.getDate("checkout_date");
				String accName = rs.getString("acc_name");
				String fileName = rs.getString("filename");
				int cancelStatus = rs.getInt("cancel_status");
				int reviewScore = rs.getInt("review_score");
				
				ReservationListView rlv = new ReservationListView();
				
				rlv.setId(reservationId);
				rlv.setUserId(userId);
				rlv.setAccId(accId);
				rlv.setRoomId(roomId);
				rlv.setPrice(price);
				rlv.setCheckinDate(checkinDate);
				rlv.setCheckoutDate(checkoutDate);
				rlv.setAccName(accName);
				rlv.setFileName(fileName);
				rlv.setCancelStatus(cancelStatus);
				rlv.setReviewScore(reviewScore);
				
				list.add(rlv);
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int getCount(int userId) {
		int result = 0;
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		
		String sql = "SELECT COUNT(*) FROM RESERVATION_LIST_VIEW WHERE USER_ID=?";
		
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

	@Override
	public List<ReservationForCompanyView> getList(int startIndex, int endIndex, String accIdsCSV, int accType) {
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		List<ReservationForCompanyView> list = new ArrayList<>();
		
		String sql;
		if(accIdsCSV.equals("") || accIdsCSV == null) {
			return list;
			
		}
		else {
			if(accType != 0)
				sql = String.format("SELECT * FROM (SELECT ROWNUM NUM, RFCV.* FROM RESERVATION_FOR_COMPANY_VIEW RFCV WHERE ACC_ID IN(%s) AND ACC_TYPE_ID=?) WHERE NUM BETWEEN ? AND ?", accIdsCSV);
			else
				sql = String.format("SELECT * FROM (SELECT ROWNUM NUM, RFCV.* FROM RESERVATION_FOR_COMPANY_VIEW RFCV WHERE ACC_ID IN(%s)) WHERE NUM BETWEEN ? AND ?", accIdsCSV);
		}
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//String sql = "SELECT * FROM MEMBER WHERE TYPE = ?";
			//PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			if(accType !=0) {
				ps.setInt(1,accType);
				ps.setInt(2,startIndex);
				ps.setInt(3,endIndex);
			}else {

				ps.setInt(1,startIndex);
				ps.setInt(2,endIndex);
			}
			
			
//			if(!field.equals("")) {
//			}
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int rownum = rs.getInt("num");
				int id = rs.getInt("id");
				int userId = rs.getInt("user_id");
				Date regdate = rs.getDate("regdate");
				Date reviewRegdate = rs.getDate("review_regdate");
				int reviewScore = rs.getInt("review_score");
				int accId = rs.getInt("acc_id");
				int cancelStatus = rs.getInt("cancel_status");
				int roomId = rs.getInt("room_id");
				String reviewContent = rs.getString("review_content");
				Date checkinDate = rs.getDate("checkin_date");
				Date checkoutDate = rs.getDate("checkout_date");
				int price = rs.getInt("price");
				String userName = rs.getString("user_name");
				String accName = rs.getString("acc_name");
				int accTypeId = rs.getInt("acc_type_id");
				int headcount = rs.getInt("headcount");
				
				ReservationForCompanyView r = new ReservationForCompanyView();
				
				r.setRownum(rownum);
				r.setId(id);
				r.setUserId(userId);
				r.setRegdate(regdate);
				r.setReviewRegdate(reviewRegdate);
				r.setReviewScore(reviewScore);
				r.setAccId(accId);
				r.setCancelStatus(cancelStatus);
				r.setRoomId(roomId);
				r.setReviewContent(reviewContent);
				r.setCheckinDate(checkinDate);
				r.setCheckoutDate(checkoutDate);
				r.setPrice(price);
				r.setUserName(userName);
				r.setAccName(accName);
				r.setAccTypeId(accTypeId);
				r.setHeadcount(headcount);
				
				list.add(r);
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int getItemCount(String accIdsCSV, int accType) {
		int result = 0;
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql;
		if(accIdsCSV.equals("") || accIdsCSV == null) {
			return 0;
			
		}
		else {
			
			if(accType != 0)
				sql = String.format("SELECT COUNT(*) FROM (SELECT ROWNUM NUM, RFCV.* FROM RESERVATION_FOR_COMPANY_VIEW RFCV WHERE ACC_ID IN(%s) AND ACC_TYPE_ID=?)", accIdsCSV);
			else
				sql = String.format("SELECT COUNT(*) FROM (SELECT ROWNUM NUM, RFCV.* FROM RESERVATION_FOR_COMPANY_VIEW RFCV WHERE ACC_ID IN(%s))", accIdsCSV);
			
		}
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//String sql = "SELECT * FROM MEMBER WHERE TYPE = ?";
			//PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			if(accType!=0)
				ps.setInt(1,accType);
			
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

	@Override
	public int update(Reservation rese) {
		int result =0;
		
		String url = DBContext.URL;
		String sql = "UPDATE RESERVATION SET REVIEW_SCORE=?,REVIEW_CONTENT=?,REVIEW_REGDATE=SYSTIMESTAMP WHERE USER_ID= ? AND ID= ?";
		System.out.println(rese.getUserId());
		System.out.println( rese.getId());
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st =con.prepareStatement(sql);
			st.setInt(1, rese.getReviewScore());
			st.setString(2, rese.getReviewContent());
			st.setInt(3, rese.getUserId());
			st.setInt(4, rese.getId());
			
			result =st.executeUpdate();
			
			st.close();
			con.close();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ReviewView get(int userId,int id) {
		ReviewView rv = null ;
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM  RESERVATION_FOR_COMPANY_VIEW WHERE USER_ID="+userId+"and ID="+id;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			

			if(rs.next()) {
				Date regdate = rs.getDate("regdate");
				int reviewScore = rs.getInt("review_score");
				Date reviewRegdate = rs.getDate("review_regdate");
				int accId =rs.getInt("acc_Id");
				int cancelStatus = rs.getInt("cancel_status");
				int roomId = rs.getInt("room_id");
				String reviewContent = rs.getString("review_content");
				Date checkinDate = rs.getDate("checkin_date");
				Date checkoutDate = rs.getDate("checkout_date");
				int price = rs.getInt("price");
				int headcount = rs.getInt("headcount");
				String userName = rs.getString("user_name");
				String accName = rs.getString("acc_name");
				
			    
				rv = new ReviewView(
			    		 id,
			    		 userId, 
			    		 regdate, 
			    		 reviewScore, 
			    		 reviewRegdate, 
			    		 accId, 
			    		 cancelStatus, 
			    		 roomId, 
			    		 reviewContent, 
			    		 checkinDate,
			    		 checkoutDate,
			    		 price, 
			    		 headcount, 
			    		 userName, 
			    		 accName
			    		 );
			     
			     
			     
				}

			
			rs.close();
			st.close();
			con.close();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rv;
	}
  
	public ReservationDetailView getDetail(int id) {
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		ReservationDetailView rd = new ReservationDetailView();
		
		String sql = "SELECT * FROM RESERVATION_DETAIL_VIEW WHERE RESERVATION_ID=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int reservationId = rs.getInt("reservation_id");
				String accName = rs.getString("acc_name");
				String roomName = rs.getString("room_name");
				Date checkinDate = rs.getDate("checkin_date");
				Date checkoutDate = rs.getDate("checkout_date");
				String userName = rs.getString("user_name");
				String phone = rs.getString("phone");
				int price = rs.getInt("price");
				int cancelStatus = rs.getInt("cancel_status");
				
				rd.setReservationId(reservationId);
				rd.setAccName(accName);
				rd.setRoomName(roomName);
				rd.setCheckinDate(checkinDate);
				rd.setCheckoutDate(checkoutDate);
				rd.setUserName(userName);
				rd.setPhone(phone);
				rd.setPrice(price);
				rd.setCancelStatus(cancelStatus);
				
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return rd;

	}

}
