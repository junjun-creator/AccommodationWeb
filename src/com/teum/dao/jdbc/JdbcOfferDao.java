package com.teum.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teum.dao.OfferDao;
import com.teum.dao.entity.UsersListView;
import com.teum.entity.Acc;
import com.teum.entity.Offer;

public class JdbcOfferDao implements OfferDao {

	@Override
	public int insert(Offer offer) {
		int result = 0;

		String url = DBContext.URL;
		String sql = "INSERT INTO OFFER(ACC_ID, USER_ID, PRICE, LOCATION, CHECKIN_DATE, CHECKOUT_DATE, HEADCOUNT) VALUES(?, ?, ?, ?, ?, ?, ?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, offer.getAccId());
			pst.setInt(2, offer.getUserId());
			pst.setInt(3, offer.getPrice());
			pst.setString(4, offer.getLocation());
			pst.setDate(5, new java.sql.Date(offer.getCheckinDate().getTime()));
			pst.setDate(6, new java.sql.Date(offer.getCheckoutDate().getTime()));
			pst.setInt(7, offer.getHeadcount());
			
			result = pst.executeUpdate();
			
			pst.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Offer> getList(int id, int type) {
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "SELECT * FROM OFFER WHERE "+((type==0)?"USER_ID":"ACC_ID")+"=?";
		
		List<Offer> list = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//String sql = "SELECT * FROM MEMBER WHERE TYPE = ?";
			//PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
//			if(!field.equals("")) {
//			}
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int offerId = rs.getInt("id");
				int accId = rs.getInt("acc_id");
				int userId = rs.getInt("user_id");
				int price = rs.getInt("price");
				String location = rs.getString("location");
				Date checkIn = rs.getDate("checkin_date");
				Date checkOut = rs.getDate("checkout_date");
				Date regdate = rs.getDate("regdate");
				int headcount = rs.getInt("headcount");
				
				Offer o = new Offer();
				o.setId(offerId);
				o.setAccId(accId);
				o.setUserId(userId);
				o.setPrice(price);
				o.setLocation(location);
				o.setCheckinDate(checkIn);
				o.setCheckoutDate(checkOut);
				o.setRegdate(regdate);
				o.setHeadcount(headcount);
				
				list.add(o);
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
	public List<Offer> getList(String accIdsCSV) {
		List<Offer> list = new ArrayList<>();

		String url = DBContext.URL;
		String sql = String.format("SELECT * FROM OFFER WHERE ACC_ID IN (%s) AND APPROVAL_DATE IS NULL", accIdsCSV);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int offerId = rs.getInt("id");
				int accId = rs.getInt("acc_id");
				int userId = rs.getInt("user_id");
				int price = rs.getInt("price");
				String location = rs.getString("location");
				Date checkIn = rs.getDate("checkin_date");
				Date checkOut = rs.getDate("checkout_date");
				Date regdate = rs.getDate("regdate");
				int headcount = rs.getInt("headcount");
				
				Offer o = new Offer();
				o.setId(offerId);
				o.setAccId(accId);
				o.setUserId(userId);
				o.setPrice(price);
				o.setLocation(location);
				o.setCheckinDate(checkIn);
				o.setCheckoutDate(checkOut);
				o.setRegdate(regdate);
				o.setHeadcount(headcount);
				
				list.add(o);
			}
			
			pst.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int getId(int accId) {
		int result = 0;

		String url = DBContext.URL;
		String sql = "SELECT * FROM OFFER WHERE ACC_ID = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setInt(1, accId);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt("ID");
			}
			
			pst.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<Integer> getIds(String accIdsCSV) {
		List<Integer> list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = String.format("SELECT ID FROM OFFER WHERE ACC_ID IN (%s)", accIdsCSV);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt("ID"); 
				
				list.add(id);
			};

			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Offer> getListByOfferIds(String finalOfferIdsCSV) {
		List<Offer> list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = String.format("SELECT * FROM OFFER WHERE ID IN (%s)", finalOfferIdsCSV);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				int accId = rs.getInt("acc_id");
				int userId = rs.getInt("user_id");
				int price = rs.getInt("price");
				String location = rs.getString("location");
				Date checkIn = rs.getDate("checkin_date");
				Date checkOut = rs.getDate("checkout_date");
				Date regdate = rs.getDate("regdate");
				int headcount = rs.getInt("headcount");
				
				Offer o = new Offer();
				o.setId(id);
				o.setAccId(accId);
				o.setUserId(userId);
				o.setPrice(price);
				o.setLocation(location);
				o.setCheckinDate(checkIn);
				o.setCheckoutDate(checkOut);
				o.setRegdate(regdate);
				o.setHeadcount(headcount);
				
				list.add(o);
			}
			
			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
