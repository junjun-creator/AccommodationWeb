package com.teum.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teum.dao.AccDao;
import com.teum.entity.Acc;

public class JdbcAccDao implements AccDao{

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Acc get(int id) {
		Acc a = null;

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM ACCOMMODATION_LIST WHERE REGISTRATION ='1'";//조건 추가(accName)

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);




			while(rs.next()) {

				String accName = rs. getString("acc_name");
				String location = rs.getString("location");
				Date regdate = rs.getDate("regdate");
				String phone = rs.getString("phone");
				String email = rs. getString("email");
				int accTypeId = rs.getInt("acc_type_id");
				int regStatus = rs.getInt("reg_status");
				Date approvalDate = rs.getDate("approval_date");
				int adiminId = rs.getInt("adimin_id");
				int companyId = rs.getInt("company_id");

				 a = new Acc(
						id,
						accName,
						location,
						regdate,
						phone,
						email,
						accTypeId,
						regStatus,
						approvalDate,
						adiminId,
						companyId
						);

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
		return a;
	}

	@Override
	public List<Acc> getList() {
		String url = DBContext.URL;
		String sql = "SELECT * FROM ACCOMMODATION_LIST WHERE REGISTRATION ='1'";

		List<Acc> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);




			while(rs.next()) {

				int id = rs.getInt("id"); 
				String accName = rs. getString("acc_name");
				String location = rs.getString("location");
				Date regdate = rs.getDate("regdate");
				String phone = rs.getString("phone");
				String email = rs. getString("email");
				int accTypeId = rs.getInt("acc_type_id");
				int regStatus = rs.getInt("reg_status");
				Date approvalDate = rs.getDate("approval_date");
				int adiminId = rs.getInt("adimin_id");
				int companyId = rs.getInt("company_id");

				Acc a = new Acc(
						id,
						accName,
						location,
						regdate,
						phone,
						email,
						accTypeId,
						regStatus,
						approvalDate,
						adiminId,
						companyId
						);


				list.add(a);
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
	public Acc applyGet(int id) {
		Acc a = null;

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM ACCOMMODATION_LIST WHERE REGISTRATION ='0'";//조건 추가(accName)

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"TEUM","4444");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);




			while(rs.next()) {

				String accName = rs. getString("acc_name");
				String location = rs.getString("location");
				Date regdate = rs.getDate("regdate");
				String phone = rs.getString("phone");
				String email = rs. getString("email");
				int accTypeId = rs.getInt("acc_type_id");
				int regStatus = rs.getInt("reg_status");
				Date approvalDate = rs.getDate("approval_date");
				int adiminId = rs.getInt("adimin_id");
				int companyId = rs.getInt("company_id");

				 a = new Acc(
						id,
						accName,
						location,
						regdate,
						phone,
						email,
						accTypeId,
						regStatus,
						approvalDate,
						adiminId,
						companyId
						);

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
		return a;
	}

	@Override
	public List<Acc> applyGetList() {
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM ACCOMMODATION_LIST WHERE REGISTRATION ='0'";
		Connection con;
		List<Acc> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,"TEUM","4444");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);




			while(rs.next()) {

				int id = rs.getInt("id"); 
				String accName = rs. getString("acc_name");
				String location = rs.getString("location");
				Date regdate = rs.getDate("regdate");
				String phone = rs.getString("phone");
				String email = rs. getString("email");
				int accTypeId = rs.getInt("acc_type_id");
				int regStatus = rs.getInt("reg_status");
				Date approvalDate = rs.getDate("approval_date");
				int adiminId = rs.getInt("adimin_id");
				int companyId = rs.getInt("company_id");

				Acc a = new Acc(
						id,
						accName,
						location,
						regdate,
						phone,
						email,
						accTypeId,
						regStatus,
						approvalDate,
						adiminId,
						companyId
						);


				list.add(a);
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

	
	@Override//수정필요
	public int[] deleteAll(int[] ids) {
		// TODO Auto-generated method stub
		return null;
	}



}
