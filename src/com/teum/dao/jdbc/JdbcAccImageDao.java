package com.teum.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.teum.dao.AccImageDao;
import com.teum.entity.AccImage;

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

}
