package com.teum.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.teum.dao.RoomImageDao;
import com.teum.entity.RoomImage;

public class JdbcRoomImageDao implements RoomImageDao {

	@Override
	public int insert(RoomImage roomImage) {
		int result = 0;

		String url = DBContext.URL;
		String sql = "INSERT INTO ROOM_IMAGE(FILENAME, FILEROUTE, ROOM_ID) VALUES(?, ?, ?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, roomImage.getFilename());
			pst.setString(2, roomImage.getFileroute());
			pst.setInt(3, roomImage.getRoomId());

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
