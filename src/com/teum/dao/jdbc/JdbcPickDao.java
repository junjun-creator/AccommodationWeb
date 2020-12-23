package com.teum.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teum.dao.PickDao;
import com.teum.dao.entity.PickListView;
import com.teum.dao.entity.UsersListView;
import com.teum.entity.Pick;
import com.teum.entity.Users;

public class JdbcPickDao implements PickDao {

	@Override
	public List<PickListView> getList(int userId) {
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "SELECT * FROM PICK_LIST WHERE USER_ID=?";
		
		List<PickListView> list = new ArrayList<>();
		//DriverManager;//Class.forName~
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//String sql = "SELECT * FROM MEMBER WHERE TYPE = ?";
			//PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,userId);
//			if(!field.equals("")) {
//			}
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int accId = rs.getInt("acc_id");
				String accName = rs.getString("acc_name");
				String accLocation = rs.getString("acc_location");
				String accFileName = rs.getString("acc_filename");
				String accFileRoute = rs.getString("acc_fileroute");
				int price = rs.getInt("price");
				
				PickListView p = new PickListView();
				p.setAccId(accId);
				p.setUserId(userId);
				p.setAccName(accName);
				p.setAccLocation(accLocation);
				p.setAccFileName(accFileName);
				p.setAccFileRoute(accFileRoute);
				p.setPrice(price);
				
				list.add(p);
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
	public List<Double> getPointList(List<Integer> accIds) {
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "SELECT AVG(REVIEW_SCORE) AVG FROM RESERVATION WHERE ACC_ID=?";
		
		List<Double> list = new ArrayList<>();
		//DriverManager;//Class.forName~
		
		for(int accId : accIds) {
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,dbid,dbpwd);
				//String sql = "SELECT * FROM MEMBER WHERE TYPE = ?";
				//PreparedStatement ps = con.prepareStatement(sql);
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1,accId);
//			if(!field.equals("")) {
//			}
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					double point = rs.getDouble("AVG");
					
					list.add(point);
				}
				
				
				rs.close();
				ps.close();
				con.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public int delete(Pick p) {
		int result =0;
		
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "DELETE FROM PICK WHERE ACC_ID=? AND USER_ID=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,p.getAccId());
			ps.setInt(2, p.getUserId());
			result = ps.executeUpdate();
			
			
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int checkZzim(int userId, int accId) {
		int result = 0;
		
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "SELECT COUNT(*) FROM PICK WHERE ACC_ID=? AND USER_ID=?";
		

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, accId);
			ps.setInt(2, userId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt(1);
			}
			
			
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int insertZzim(int userId, int accId) {
		int result =0;
		
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "INSERT INTO PICK(ACC_ID,USER_ID) VALUES(?,?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,accId);
			ps.setInt(2, userId);
			result = ps.executeUpdate();
			
			
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteZzim(int userId, int accId) {
		int result =0;
		
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "DELETE FROM PICK WHERE ACC_ID=? AND USER_ID=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,accId);
			ps.setInt(2, userId);
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
