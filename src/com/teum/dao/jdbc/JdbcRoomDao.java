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

import com.teum.dao.RoomDao;
import com.teum.entity.Acc;
import com.teum.entity.Offer;
import com.teum.entity.Room;

public class JdbcRoomDao implements RoomDao {

	@Override
	public int insert(Room room) {
		int result = 0;

		String url = DBContext.URL;
		String sql = "INSERT INTO ROOM(NAME, PRICE, ACC_ID, MAX_HEADCOUNT, BED_COUNT) VALUES(?, ?, ?, ?, ?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, room.getName());
			pst.setInt(2, room.getPrice());
			pst.setInt(3, room.getAccId());
			pst.setInt(4, room.getMaxHeadcount());
			pst.setInt(5, room.getBedCount());

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
	public Room getLast() {
		// 마지막 인덱스의 event를 뽑아오는 쿼리문을 작성하자
		Room room = null;

		String url = DBContext.URL;
		String sql = "SELECT * FROM ROOM WHERE ID = (SELECT MAX(ID) FROM ROOM)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				int accId = rs.getInt("ACC_ID");
				int maxHeadcount = rs.getInt("MAX_HEADCOUNT");
				int bedCount = rs.getInt("BED_COUNT");

				room = new Room();
				
				room.setId(id);
				room.setName(name);
				room.setAccId(accId);
				room.setMaxHeadcount(maxHeadcount);
				room.setBedCount(bedCount);
			}
			
			// 꼭 닫아줘야함!!! 안그럼 나중에 오류남
			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return room;
	}

	@Override
	public List<Room> getList(String accIdsCSV) {
		List<Room> list = new ArrayList<>();

		String url = DBContext.URL;
		String sql = String.format("SELECT * FROM ROOM WHERE ACC_ID IN (%s)", accIdsCSV);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				int accId = rs.getInt("ACC_ID");
				int maxHeadcount = rs.getInt("MAX_HEADCOUNT");
				int bedCount = rs.getInt("BED_COUNT");
				String bookedDate = rs.getString("BOOKED_DATE");
				
				Room room = new Room();
				
				room.setId(id);
				room.setName(name);
				room.setAccId(accId);
				room.setMaxHeadcount(maxHeadcount);
				room.setBedCount(bedCount);
				room.setBookedDate(bookedDate);
				
				list.add(room);
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

}
