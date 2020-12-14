//package com.teum.service;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import com.teum.entity.AccommodationList;
//
//public class AccService {
//
//	   public List<AccommodationListServiceI> getList() {
//		      String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//		      String sql = "SELECT * FROM ACCOMMODATION_LIST WHERE REGISTRATION ='1'";
//		      
//		      List<AccommodationListServiceI> list = new ArrayList<>();
//		      try {
//		         Class.forName("oracle.jdbc.driver.OracleDriver");
//		         Connection con = DriverManager.getConnection(url,"TEUM","4444");
//		         Statement st = con.createStatement();
//		         ResultSet rs = st.executeQuery(sql);
//		         
//		      
//		         
//		         
//		         while(rs.next()) {
//		         
//		            int id = rs.getInt("id"); 
//		            String name = rs.getString("name");
//		            String accName = rs. getString("acc_name");
//		            String location = rs.getString("location");
//		            String regdate = rs.getString("regdate");
//		            String phone = rs.getString("phone");
//		            String email = rs. getString("email");
//		            String accType = rs.getString("acc_type");
//		            int registration = rs.getInt("registration");
//		            
//		            AccommodationListServiceI al = new AccommodationListServiceI(
//		                  id,
//		                  name,
//		                  accName,
//		                  location,
//		                  regdate,
//		                  phone,
//		                  email,
//		                  accType,
//		                  registration
//		            );
//		            
//		            
//		            list.add(al);
//		         };
//		         
//		                  
//		         rs.close();
//		         st.close();
//		         con.close();
//		         
//		      } catch (SQLException e) {
//		         // TODO Auto-generated catch block
//		         e.printStackTrace();
//		      } catch (ClassNotFoundException e) {
//		         // TODO Auto-generated catch block
//		         e.printStackTrace();
//		      }
//		      return list;
//		   }
//
//	public AccommodationListServiceI get(String accName) {
//		AccommodationListServiceI al = null;
//		
//		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//	    String sql = "SELECT * FROM ACCOMMODATION_LIST WHERE REGISTRATION ='1'";//조건 추가(accName)
//	    
//	      try {
//	         Class.forName("oracle.jdbc.driver.OracleDriver");
//	         Connection con = DriverManager.getConnection(url,"TEUM","4444");
//	         Statement st = con.createStatement();
//	         ResultSet rs = st.executeQuery(sql);
//	         
//	      
//	         
//	         
//	         while(rs.next()) {
//	         
//	            int id = rs.getInt("id"); 
//	            String name = rs.getString("name");
//	            String location = rs.getString("location");
//	            String regdate = rs.getString("regdate");
//	            String phone = rs.getString("phone");
//	            String email = rs. getString("email");
//	            String accType = rs.getString("acc_type");
//	            int registration = rs.getInt("registration");
//	            
//	             al = new AccommodationListServiceI(
//	                  id,
//	                  name,
//	                  accName,
//	                  location,
//	                  regdate,
//	                  phone,
//	                  email,
//	                  accType,
//	                  registration
//	            );
//
//	         };
//	         
//	                  
//	         rs.close();
//	         st.close();
//	         con.close();
//	         
//	      } catch (SQLException e) {
//	         // TODO Auto-generated catch block
//	         e.printStackTrace();
//	      } catch (ClassNotFoundException e) {
//	         // TODO Auto-generated catch block
//	         e.printStackTrace();
//	      }
//		return al;
//	}
//	
//	public List<AccommodationListServiceI> applyGetList() {
//	      String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//	      String sql = "SELECT * FROM ACCOMMODATION_LIST WHERE REGISTRATION ='0'";
//	      Connection con;
//	      List<AccommodationListServiceI> list = new ArrayList<>();
//	      try {
//	         Class.forName("oracle.jdbc.driver.OracleDriver");
//	         con = DriverManager.getConnection(url,"TEUM","4444");
//	         Statement st = con.createStatement();
//	         ResultSet rs = st.executeQuery(sql);
//	         
//	      
//	         
//	         
//	         while(rs.next()) {
//	         
//	            int id = rs.getInt("id"); 
//	            String name = rs.getString("name");
//	            String accName = rs. getString("acc_name");
//	            String location = rs.getString("location");
//	            String regdate = rs.getString("regdate");
//	            String phone = rs.getString("phone");
//	            String email = rs. getString("email");
//	            String accType = rs.getString("acc_type");
//	            int registration = rs.getInt("registration");
//	            
//	            AccommodationListServiceI al = new AccommodationListServiceI(
//	                  id,
//	                  name,
//	                  accName,
//	                  location,
//	                  regdate,
//	                  phone,
//	                  email,
//	                  accType,
//	                  registration
//	            );
//	            
//	            
//	            list.add(al);
//	         };
//	         
//	                  
//	         rs.close();
//	         st.close();
//	         con.close();
//	         
//	      } catch (SQLException e) {
//	         // TODO Auto-generated catch block
//	         e.printStackTrace();
//	      } catch (ClassNotFoundException e) {
//	         // TODO Auto-generated catch block
//	         e.printStackTrace();
//	      }
//	      return list;
//	   }
//	
//	public AccommodationListServiceI applyGet(String accName) {
//		AccommodationListServiceI al = null;
//		
//		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//	    String sql = "SELECT * FROM ACCOMMODATION_LIST WHERE REGISTRATION ='0'";//조건 추가(accName)
//	    
//	      try {
//	         Class.forName("oracle.jdbc.driver.OracleDriver");
//	         Connection con = DriverManager.getConnection(url,"TEUM","4444");
//	         Statement st = con.createStatement();
//	         ResultSet rs = st.executeQuery(sql);
//	         
//	      
//	         
//	         
//	         while(rs.next()) {
//	         
//	            int id = rs.getInt("id"); 
//	            String name = rs.getString("name");
//	            String location = rs.getString("location");
//	            String regdate = rs.getString("regdate");
//	            String phone = rs.getString("phone");
//	            String email = rs. getString("email");
//	            String accType = rs.getString("acc_type");
//	            int registration = rs.getInt("registration");
//	            
//	             al = new AccommodationListServiceI(
//	                  id,
//	                  name,
//	                  accName,
//	                  location,
//	                  regdate,
//	                  phone,
//	                  email,
//	                  accType,
//	                  registration
//	            );
//
//	         };
//	         
//	                  
//	         rs.close();
//	         st.close();
//	         con.close();
//	         
//	      } catch (SQLException e) {
//	         // TODO Auto-generated catch block
//	         e.printStackTrace();
//	      } catch (ClassNotFoundException e) {
//	         // TODO Auto-generated catch block
//	         e.printStackTrace();
//	      }
//		return al;
//	}
//}
