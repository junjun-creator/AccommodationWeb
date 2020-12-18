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

import com.teum.dao.GoldenTimeDao;
import com.teum.dao.entity.GoldenTimeView;
import com.teum.entity.Acc;

public class JdbcGoldenTimeDao implements GoldenTimeDao {
	@Override
	public int updateStatus(Acc acc) {
		int result =0;
		
		String url = DBContext.URL;
		String sql = "UPDATE ACC SET GOLDENTIME_STATUS=? WHERE ID=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st =con.prepareStatement(sql);
			
			if(acc.getGoldentimeStatus()==1) {
				acc.setGoldentimeStatus(0);
			}else {
				acc.setGoldentimeStatus(1);
			}
			
			
			st.setInt(1, acc.getGoldentimeStatus());
			st.setInt(2, acc.getId());
			
		
			//ResultSet rs = st.executeQuery(sql); // select 문장에만
			result =st.executeUpdate();//insert,update,delete 문장일 떄
			
			st.close();
			con.close();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(Acc acc) {
		int result =0;
		
		String url = DBContext.URL;
		String sql = "UPDATE ACC SET GT_START_DATE=?,GT_END_DATE=?,SALEPRICE=? WHERE ID=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st =con.prepareStatement(sql);
			st.setDate(1, new java.sql.Date(acc.getGtStartDate().getTime()));
			st.setDate(2, new java.sql.Date(acc.getGtEndDate().getTime()));
			st.setInt(3, acc.getSaleprice());
			st.setInt(4, acc.getId());
			
		
			//ResultSet rs = st.executeQuery(sql); // select 문장에만
			result =st.executeUpdate();//insert,update,delete 문장일 떄
			
			st.close();
			con.close();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<GoldenTimeView> getGoldenList(int id) {
		List<GoldenTimeView> list = new ArrayList<GoldenTimeView>();
		String url = DBContext.URL;
		String sql = "SELECT * FROM GOLDENTIME_LIST_VIEW WHERE REG_STATUS = 1 AND COMPANY_ID ="+id; 

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				int accId = rs.getInt("ACC_ID");
				int companyId = rs.getInt("COMPANY_ID");
				int regStatus = rs.getInt("REG_STATUS");
				String name = rs. getString("NAME");
				String location = rs. getString("LOCATION");
				int goldentimeStatus = rs.getInt("GOLDENTIME_STATUS");
				int saleprice = rs.getInt("SALEPRICE");
				Date gtStartDate = rs.getDate("GT_START_DATE");
				Date gtEndDate = rs.getDate("GT_END_DATE");
				String fileroute = rs. getString("FILEROUTE");

				GoldenTimeView g = new GoldenTimeView();
				g.setId(accId);
				g.setCompanyId(companyId);
				g.setRegStatus(regStatus);
				g.setName(name);
				g.setLocation(location);
				g.setGoldentimeStatus(goldentimeStatus);
				g.setSaleprice(saleprice);
				g.setGtStartDate(gtStartDate);
				g.setGtEndDate(gtEndDate);
				g.setFileroute(fileroute);
				
				list.add(g);
			};

			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	

	
}
