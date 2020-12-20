package com.teum.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teum.dao.ReservationDao;
import com.teum.dao.entity.OfferInfoView;
import com.teum.dao.entity.ReservationListView;

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
				int userId = rs.getInt("user_id");
				int accId = rs.getInt("acc_id");
				int roomId = rs.getInt("room_id");
				int price = rs.getInt("price");
				Date checkinDate = rs.getDate("checkin_date");
				Date checkoutDate = rs.getDate("checkout_date");
				String accName = rs.getString("acc_name");
				String fileName = rs.getString("filename");
				
				ReservationListView rlv = new ReservationListView();
				
				rlv.setUserId(userId);
				rlv.setAccId(accId);
				rlv.setRoomId(roomId);
				rlv.setPrice(price);
				rlv.setCheckinDate(checkinDate);
				rlv.setCheckoutDate(checkoutDate);
				rlv.setAccName(accName);
				rlv.setFileName(fileName);
				
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

}
