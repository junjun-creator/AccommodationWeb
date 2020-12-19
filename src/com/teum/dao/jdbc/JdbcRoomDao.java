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
import com.teum.dao.entity.OfferInfoView;
import com.teum.dao.entity.OfferableRoomListView;
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
				int price = rs.getInt("PRICE");
				int maxHeadcount = rs.getInt("MAX_HEADCOUNT");
				int bedCount = rs.getInt("BED_COUNT");
				String bookedDate = rs.getString("BOOKED_DATE");
				
				Room room = new Room();
				
				room.setId(id);
				room.setName(name);
				room.setAccId(accId);
				room.setPrice(price);
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

	@Override
	public List<OfferInfoView> getOfferInfoList(int startIndex,int endIndex,int offerId) {
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		
		String sql = "SELECT * FROM (SELECT ROWNUM RN, OFFER_INFO_VIEW.* FROM OFFER_INFO_VIEW WHERE FILENAME LIKE '%메인%' AND OFFER_ID=?) WHERE RN BETWEEN ? AND ?";
		
		List<OfferInfoView> list = new ArrayList<>();
		//DriverManager;//Class.forName~
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//String sql = "SELECT * FROM MEMBER WHERE TYPE = ?";
			//PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,offerId);
			ps.setInt(2, startIndex);
			ps.setInt(3, endIndex);
//			if(!field.equals("")) {
//			}
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int roomId = rs.getInt("room_id");
				String roomName = rs.getString("room_name");
				int accId = rs.getInt("acc_id");
				int price = rs.getInt("price");
				int maxHeadcount = rs.getInt("max_headcount");
				int bedCount = rs.getInt("bed_count");
				String fileName = rs.getString("filename");
				String fileRoute = rs.getString("fileroute");
				String accName = rs.getString("acc_name");
				
				OfferInfoView oiv = new OfferInfoView();
				oiv.setRoomId(roomId);
				oiv.setRoomName(roomName);
				oiv.setMaxHeadcount(maxHeadcount);
				oiv.setBedCount(bedCount);
				oiv.setFileName(fileName);
				oiv.setFileRoute(fileRoute);
				oiv.setAccId(accId);
				oiv.setPrice(price);
				oiv.setAccName(accName);
				
				list.add(oiv);
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
   public List<OfferableRoomListView> getOfferableRoomList(int offerId) {
      String url = DBContext.URL;
      
      String sql = "SELECT * FROM OFFERABLE_ROOM_LIST_VIEW WHERE FILENAME LIKE '%메인%' AND OFFER_ID = ?";
      
      List<OfferableRoomListView> list = new ArrayList<>();
      
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
         PreparedStatement ps = con.prepareStatement(sql);
         
         ps.setInt(1, offerId);

         ResultSet rs = ps.executeQuery();
         
         while(rs.next()) {
            int id = rs.getInt("ID");
            String name = rs.getString("NAME");
            int price = rs.getInt("PRICE");
            int accId = rs.getInt("ACC_ID");
            int maxHeadcount = rs.getInt("MAX_HEADCOUNT");
            int bedCount = rs.getInt("BED_COUNT");
            String bookedDate = rs.getString("BOOKED_DATE");
            int roomImageId = rs.getInt("ROOM_IMAGE_ID");
            String fileName = rs.getString("FILENAME");
            String fileRoute = rs.getString("FILEROUTE");
            Date checkinDate = rs.getDate("CHECKIN_DATE");
            Date checkoutDate = rs.getDate("CHECKOUT_DATE");
            
            OfferableRoomListView orlv = new OfferableRoomListView();
            
            orlv.setId(id);
            orlv.setName(name);
            orlv.setPrice(price);
            orlv.setAccId(accId);
            orlv.setMaxHeadcount(maxHeadcount);
            orlv.setBedCount(bedCount);
            orlv.setRoomImageId(roomImageId);
            orlv.setFileName(fileName);
            orlv.setFileRoute(fileRoute);
            orlv.setCheckinDate(checkinDate);
            orlv.setCheckoutDate(checkoutDate);
            
            list.add(orlv);
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
	public int getOfferCount(int offerId) {
		int result = 0;
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		
		String sql = "SELECT COUNT(*) FROM OFFER_INFO_VIEW WHERE FILENAME LIKE '%메인%' AND OFFER_ID=?";
		
		//DriverManager;//Class.forName~
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//String sql = "SELECT * FROM MEMBER WHERE TYPE = ?";
			//PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,offerId);
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
public int getId(int roomId) {
	int result = 0;

	String url = DBContext.URL;
	String sql = "SELECT ACC_ID FROM ROOM WHERE ID = ?";

	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
		PreparedStatement pst = con.prepareStatement(sql);
		
		pst.setInt(1, roomId);
		
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			result = rs.getInt("ACC_ID");
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

}
