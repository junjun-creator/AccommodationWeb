package com.teum.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teum.dao.CompanyDao;
import com.teum.dao.entity.CompanyListView;
import com.teum.dao.entity.UsersListView;
import com.teum.entity.Company;
import com.teum.entity.Member;
import com.teum.entity.Users;

public class JdbcCompanyDao implements CompanyDao {

	@Override
	public int insert(Company company) {
		int result=0;
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			String sql = "INSERT INTO COMPANY(name,email,password,birthday,phone) VALUES(?,?,?,?,?)";
			//Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,company.getName());
			ps.setString(2,company.getEmail());
			ps.setString(3,company.getPassword());
			ps.setString(4,company.getBirthday());
			ps.setString(5,company.getPhone());
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
	public int update(Company company) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		int result=0;
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			String sql = "DELETE FROM COMPANY WHERE id=?";
			//Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
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
	public Company get(int id) {
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String dbid = "TEUM";
		String dbpwd = "4444";
		//String sql = "SELECT * FROM MEMBER";
		
		Company c = new Company();
		//DriverManager;//Class.forName~
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			String sql = "SELECT * FROM COMPANY WHERE id = ?";
			//Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String birthday = rs.getString("birthday");
				String phone = rs.getString("phone");
				Date regdate = rs.getDate("regdate");
				c.setId(id);
				c.setName(name);
				c.setEmail(email);
				c.setBirthday(birthday);
				c.setPhone(phone);
				c.setRegdate(regdate);
				
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public List<Company> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> getList(int startIndex, int endIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> getList(int startIndex, int endIndex, String field, String query) {
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		String sql = "SELECT * FROM COMPANY_LIST WHERE NUM BETWEEN ? AND ?";
		
		if(!field.equals("")) {
			String sql_ = " AND "+ field + " LIKE ?";
			sql = sql + sql_;
		}
		
		List<Company> list = new ArrayList<>();
		//DriverManager;//Class.forName~
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//String sql = "SELECT * FROM MEMBER WHERE TYPE = ?";
			//PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			if(!field.equals("")) {
				ps.setString(3,"%"+query+"%");
			}
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int rownum = rs.getInt("num");
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String birthday = rs.getString("birthday");
				String phone = rs.getString("phone");
				Date regdate = rs.getDate("regdate");
				int type = rs.getInt("type");
				CompanyListView c = new CompanyListView();
				c.setRownum(rownum);
				c.setId(id);
				c.setName(name);
				c.setEmail(email);
				c.setBirthday(birthday);
				c.setPhone(phone);
				c.setRegdate(regdate);
				c.setType(type);
				
				list.add(c);
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
	public int getCount(String field, String query) {
		int result = 0;
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "SELECT COUNT(*) FROM COMPANY";
		
		if(!field.equals("")) {
			String sql_ = " WHERE "+ field + " LIKE ?";
			sql = sql + sql_;
		}
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//String sql = "SELECT * FROM MEMBER WHERE TYPE = ?";
			//PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			if(!field.equals("")) {
				ps.setString(1,"%"+query+"%");
			}
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
	
	
	

}
