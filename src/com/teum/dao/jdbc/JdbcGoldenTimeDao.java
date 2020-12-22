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
import com.teum.dao.entity.QnAView;
import com.teum.entity.Acc;

public class JdbcGoldenTimeDao implements GoldenTimeDao {
	
	@Override
	public int updateStatus(int status, int chk) {
		int result =0;
		
		String url = DBContext.URL;
		String sql = "UPDATE ACC SET GOLDENTIME_STATUS=? WHERE ID=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st =con.prepareStatement(sql);
			
			
			
			st.setInt(1,status);
			st.setInt(2,chk);
			
		
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
	public List<GoldenTimeView> getGoldenList() {
		
		return getGoldenList(0,0);
	}
	
	@Override
	public List<GoldenTimeView> getGoldenList(int open) {
		
		return getGoldenList(0,open);
	}

	
	@Override
	public List<GoldenTimeView> getGoldenList(int id,int open) {
		List<GoldenTimeView> list = new ArrayList<GoldenTimeView>();
		String url = DBContext.URL;
		String sql = "SELECT * FROM GOLDENTIME_LIST_VIEW WHERE REG_STATUS = 1 "; 
		
		if(id>0) {
			String sql_="AND COMPANY_ID LIKE "+id;
			
			sql+=sql_;
		}
		else if(open>0) {
			String sql2="AND GOLDENTIME_STATUS LIKE "+open;
			
			sql+=sql2;
		}
		
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
				String phone =rs.getString("phone");
				String userName = rs.getString("USER_NAME");
				
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
				g.setPhone(phone);
				g.setUserName(userName);
				
				
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
	
	@Override
	public List<GoldenTimeView> getVIewList() {
		
		return getVIewList(1,3,"","");
	}
	
	@Override
	public List<GoldenTimeView> getVIewList(int startIndex, int endIndex) {
		
		return getVIewList(startIndex,endIndex,"","");
	}
	
	@Override
	public List<GoldenTimeView> getVIewList(int startIndex, int endIndex, String category) {
		
		return getVIewList(startIndex,endIndex,category,"");
	}
	
	@Override
	public List<GoldenTimeView> getVIewList(int startIndex, int endIndex, String category, String query) {
		 List<GoldenTimeView> list = new ArrayList<GoldenTimeView>();
		 
			String sql = "SELECT * FROM\r\n" + 
					"(SELECT ROWNUM NUM, G.* FROM GOLDENTIME_LIST_VIEW G WHERE  REG_STATUS = 1 AND TYPE LIKE ? AND USER_NAME LIKE ?)\r\n" + 
					"WHERE NUM BETWEEN ? AND ? ";
			String url = DBContext.URL;
		 
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
				PreparedStatement st = con.prepareStatement(sql);
				 
				st.setString(1, "%"+category+"%");
				st.setString(2, "%"+query+"%");
				st.setInt(3, startIndex); 
				st.setInt(4, endIndex);
				
				ResultSet rs = st.executeQuery();
				

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
					String phone =rs.getString("phone");
					String userName = rs.getString("USER_NAME");
					String type = rs.getNString("TYPE");
					
					GoldenTimeView gt = new GoldenTimeView();
					gt.setId(accId);
					gt.setCompanyId(companyId);
					gt.setRegStatus(regStatus);
					gt.setName(name);
					gt.setLocation(location);
					gt.setGoldentimeStatus(goldentimeStatus);
					gt.setSaleprice(saleprice);
					gt.setGtStartDate(gtStartDate);
					gt.setGtEndDate(gtEndDate);
					gt.setFileroute(fileroute);
					gt.setPhone(phone);
					gt.setUserName(userName);
				    gt.getType();
					
				     list.add(gt);
					}

				
				rs.close();
				st.close();
				con.close();
				
			
			} catch(Exception e) {
				e.printStackTrace();
			}
		return list;
	}


	
	@Override
	public int getCount(String category, String query) {
	int result = 0;
		
		String url = DBContext.URL;
		String sql ="SELECT COUNT(*) FROM GOLDENTIME_LIST_VIEW WHERE REG_STATUS = 1 AND USER_NAME LIKE ? AND TYPE LIKE ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1,"%"+query+"%" );
			st.setString(2, "%"+category+"%");
			/*
			 * if(!query.equals("")) { st.setString(1,"%"+query+"%" ); }
			 */
			//ResultSet rs = st.executeQuery(sql); // select 문장에만
			ResultSet rs =st.executeQuery();//insert,update,delete 문장일 떄
			
			while(rs.next()) {
				result = rs.getInt(1);
			}
			
			
			st.close();
			con.close();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}






	
	
}
