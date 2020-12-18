package com.teum.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.teum.dao.OfferDao;
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

}
