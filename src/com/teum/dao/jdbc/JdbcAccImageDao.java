package com.teum.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.teum.dao.AccImageDao;
import com.teum.entity.AccImage;
import com.teum.entity.Event;

public class JdbcAccImageDao implements AccImageDao {

	@Override
	public int insert(AccImage accImage) {
		int result = 0;

		String url = DBContext.URL;
		String sql = "INSERT INTO ACC_IMAGE(FILENAME, FILEROUTE, ACC_ID) VALUES(?, ?, ?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, accImage.getFilename());
			pst.setString(2, accImage.getFileroute());
			pst.setInt(3, accImage.getAccId());

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
	public AccImage get(int accId) {
		AccImage accImage = null;

		String url = DBContext.URL;
		String sql = "SELECT * FROM ACC_IMAGE WHERE ACC_ID = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(1, accId);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String filename = rs.getString("FILENAME");
				String fileroute = rs.getString("FILEROUTE");

				accImage = new AccImage(id, filename, fileroute, accId);
			}

			// 꼭 닫아줘야함!!! 안그럼 나중에 오류남
			rs.close();
			pst.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return accImage;
	}

	@Override
	public int delete(int accId) {
		int result =0;
		
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "DELETE FROM ACC_IMAGE WHERE ACC_ID=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,accId);
			result = ps.executeUpdate();
			
			
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return result;
	}

}
