package com.teum.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teum.dao.ReverseOfferDao;
import com.teum.entity.ReverseOffer;

public class JdbcReverseOfferDao implements ReverseOfferDao{

	@Override
	public List<Integer> getRoomIds(int id) {
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "SELECT ROOM_ID FROM REVERSE_OFFER WHERE OFFER_ID=?";
		
		List<Integer> list = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getInt("room_id"));
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
	public int insert(ReverseOffer reverseOffer) {
		int result = 0;

		String url = DBContext.URL;
		String sql = "INSERT INTO REVERSE_OFFER(OFFER_ID, ROOM_ID) VALUES(?, ?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, reverseOffer.getOfferId());
			pst.setInt(2, reverseOffer.getRoomId());

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
	public List<ReverseOffer> getList(String offerIdsCSV) {
		List<ReverseOffer> list = new ArrayList<>();
		
		String url = DBContext.URL;
		if(offerIdsCSV == null || offerIdsCSV.equals(""))
			offerIdsCSV += 0;
		String sql = String.format("SELECT * FROM REVERSE_OFFER WHERE OFFER_ID IN(%s)", offerIdsCSV);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("ID");
				int offerId = rs.getInt("OFFER_ID"); 
				int roomId = rs.getInt("ROOM_ID");
				Date approvalDate = rs.getDate("APPROVAL_DATE");
				
				ReverseOffer ro = new ReverseOffer();
				
				ro.setId(id);
				ro.setOfferId(offerId);
				ro.setRoomId(roomId);
				ro.setApprovalDate(approvalDate);
				
				list.add(ro);
			};

			rs.close();
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
	public int delete(int roomId) {
		int result = 0;

		String url = DBContext.URL;
		String sql = "DELETE FROM REVERSE_OFFER WHERE ROOM_ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, roomId);
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

}
