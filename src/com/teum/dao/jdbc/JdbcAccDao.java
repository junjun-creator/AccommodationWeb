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

import com.teum.dao.AccDao;
import com.teum.dao.entity.AccListForAdminView;
import com.teum.entity.Acc;

public class JdbcAccDao implements AccDao{



	@Override
	public Acc get(int id) {
		Acc a = null;

		String url = "DBContext.URL";
		String sql = "SELECT * FROM ACC_LIST_FOR_ADMIN WHERE REG_STATUS=1";//조건 추가(accName)

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
				Date startDate = rs.getDate("START_DATE");
				Date endDate = rs.getDate("END_DATE");
				int saleprice = rs.getInt("SALEPRICE");

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
						companyId,
						startDate,
						endDate,
						saleprice
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
		return getList(1,10,"");
	}
	@Override
	public List<Acc> getList(int startIndex, int endIndex) {
		
		return getList( startIndex,  endIndex, "");
	}
	@Override
	public List<Acc> getList(int startIndex, int endIndex, String qeury) {
		String url = DBContext.URL;
		String sql = "SELECT * FROM ACC WHERE REG_STATUS=1";

		List<Acc> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);




			while(rs.next()) {

				int id = rs.getInt("id"); 
				String name = rs. getString("name");
				String location = rs.getString("location");
				Date regdate = rs.getDate("regdate");
				String phone = rs.getString("phone");
				String email = rs. getString("email");
				int accTypeId = rs.getInt("acc_type_id");
				int regStatus = rs.getInt("reg_status");
				Date approvalDate = rs.getDate("approval_date");
				int adminId = rs.getInt("admin_id");
				int companyId = rs.getInt("company_id");
				Date startDate = rs.getDate("START_DATE");
				Date endDate = rs.getDate("END_DATE");
				int saleprice = rs.getInt("SALEPRICE");

				Acc a = new Acc(
						id,
						name,
						location,
						regdate,
						phone,
						email,
						accTypeId,
						regStatus,
						approvalDate,
						adminId,
						companyId,
						startDate,
						endDate,
						saleprice
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

		String url = "DBContext.URL";
		String sql = "SELECT * FROM ACC_LIST_FOR_ADMIN WHERE REG_STATUS=0";//조건 추가(accName)

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
				Date startDate = rs.getDate("START_DATE");
				Date endDate = rs.getDate("END_DATE");
				int saleprice = rs.getInt("SALEPRICE");

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
						companyId,
						startDate,
						endDate,
						saleprice
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
		return applyGetList(1, 10,"");
	}
	@Override
	public List<Acc> applyGetList(int startIndex, int endIndex) {
		
		return applyGetList(startIndex, endIndex,"");
	}
	
	@Override
	public List<Acc> applyGetList(int startIndex, int endIndex, String qeury) {
		String url = "DBContext.URL";
		String sql = "SELECT * FROM ACC_LIST_FOR_ADMIN WHERE REG_STATUS=0";
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
				Date startDate = rs.getDate("START_DATE");
				Date endDate = rs.getDate("END_DATE");
				int saleprice = rs.getInt("SALEPRICE");

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
						companyId,
						startDate,
						endDate,
						saleprice
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
	public int delete(int id) {
		int result=0;

		String url = "DBContext.URL";
		String sql = "DELETE FROM ACC_LIST_FOR_ADMIN WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);         
			st.setInt(1, id);
			result = st.executeUpdate();    
			st.close();
			con.close();         
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	@Override//수정필요
	public int[] deleteAll(int[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int approval(int id) {
		int result=0;

		String url = "DBContext.URL";
		String sql = "UPDATE ACC_LIST_FOR_ADMIN SET REG_STATUS=1 WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);         
			st.setInt(1, id);
			result = st.executeUpdate();    
			st.close();
			con.close();         
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int[] approvalAll(int[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccListForAdminView> getViewList() {

		return getViewList(1,10, "");
	}

	@Override
	public List<AccListForAdminView> getViewList(int startIndex, int endIndex) {

		return getViewList(startIndex, endIndex, "");
	}

	@Override
	public List<AccListForAdminView> getViewList(int startIndex, int endIndex, String qeury) {

		List<AccListForAdminView> list = new ArrayList<AccListForAdminView>();

		String url = DBContext.URL;
		String sql = "SELECT * FROM( " + 
				"    SELECT ROWNUM NUM, N.* FROM( " + 
				"    SELECT * FROM ACC_LIST_FOR_ADMIN ORDER BY REGDATE DESC " + 
				"    ) N " + 
				" ) WHERE NUM BETWEEN ? AND ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,  startIndex);
			st.setInt(2, endIndex);

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
				Date startDate = rs.getDate("START_DATE");
				Date endDate = rs.getDate("END_DATE");
				int saleprice = rs.getInt("SALEPRICE");
				String companyName = rs.getNString("company_name");
				String accType = rs.getString("acc_type");

				AccListForAdminView a = new AccListForAdminView(
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
						companyId,
						startDate,
						endDate,
						saleprice,
						companyName,
						accType
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

	

	
}
