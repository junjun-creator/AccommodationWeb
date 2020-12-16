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
				
				String name = rs. getString("name");
				String phone = rs.getString("phone");
				String location = rs.getString("location");
				String email = rs. getString("email");
				int regStatus = rs.getInt("reg_status");
				Date approvalDate = rs.getDate("approval_date");
				int adminId = rs.getInt("admin_id");
				int companyId = rs.getInt("company_id");
				Date regdate = rs.getDate("regdate");
				int accTypeId = rs.getInt("acc_type_id");
				Date gtStartDate = rs.getDate("GT_START_DATE");
				Date gtEndDate = rs.getDate("GT_END_DATE");
				int saleprice = rs.getInt("SALEPRICE");
				int goldentimeStatus = rs.getInt("goldentimeStatus");
				a = new Acc(
						id,
						name,
						phone,
						location,
						email,
						regStatus,
						approvalDate,
						adminId,
						companyId,
						regdate,
						accTypeId,
						gtStartDate,
						gtEndDate,
						saleprice,
						goldentimeStatus
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
		String sql = "SELECT * FROM ACC_LIST_FOR_ADMIN WHERE REG_STATUS=1";

		List<Acc> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);




			while(rs.next()) {

				int id = rs.getInt("id"); 
				String name = rs. getString("name");
				String phone = rs.getString("phone");
				String location = rs.getString("location");
				String email = rs. getString("email");
				int regStatus = rs.getInt("reg_status");
				Date approvalDate = rs.getDate("approval_date");
				int adminId = rs.getInt("admin_id");
				int companyId = rs.getInt("company_id");
				Date regdate = rs.getDate("regdate");
				int accTypeId = rs.getInt("acc_type_id");
				Date gtStartDate = rs.getDate("GT_START_DATE");
				Date gtEndDate = rs.getDate("GT_END_DATE");
				int saleprice = rs.getInt("SALEPRICE");
				int goldentimeStatus = rs.getInt("goldentimeStatus");
				Acc a = new Acc(
						id,
						name,
						phone,
						location,
						email,
						regStatus,
						approvalDate,
						adminId,
						companyId,
						regdate,
						accTypeId,
						gtStartDate,
						gtEndDate,
						saleprice,
						goldentimeStatus
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


				String name = rs. getString("name");
				String phone = rs.getString("phone");
				String location = rs.getString("location");
				String email = rs. getString("email");
				int regStatus = rs.getInt("reg_status");
				Date approvalDate = rs.getDate("approval_date");
				int adminId = rs.getInt("admin_id");
				int companyId = rs.getInt("company_id");
				Date regdate = rs.getDate("regdate");
				int accTypeId = rs.getInt("acc_type_id");
				Date gtStartDate = rs.getDate("GT_START_DATE");
				Date gtEndDate = rs.getDate("GT_END_DATE");
				int saleprice = rs.getInt("SALEPRICE");
				int goldentimeStatus = rs.getInt("goldentimeStatus");
				 a = new Acc(
						id,
						name,
						phone,
						location,
						email,
						regStatus,
						approvalDate,
						adminId,
						companyId,
						regdate,
						accTypeId,
						gtStartDate,
						gtEndDate,
						saleprice,
						goldentimeStatus
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
				String name = rs. getString("name");
				String phone = rs.getString("phone");
				String location = rs.getString("location");
				String email = rs. getString("email");
				int regStatus = rs.getInt("reg_status");
				Date approvalDate = rs.getDate("approval_date");
				int adminId = rs.getInt("admin_id");
				int companyId = rs.getInt("company_id");
				Date regdate = rs.getDate("regdate");
				int accTypeId = rs.getInt("acc_type_id");
				Date gtStartDate = rs.getDate("GT_START_DATE");
				Date gtEndDate = rs.getDate("GT_END_DATE");
				int saleprice = rs.getInt("SALEPRICE");
				int goldentimeStatus = rs.getInt("goldentimeStatus");
				Acc a = new Acc(
						id,
						name,
						phone,
						location,
						email,
						regStatus,
						approvalDate,
						adminId,
						companyId,
						regdate,
						accTypeId,
						gtStartDate,
						gtEndDate,
						saleprice,
						goldentimeStatus
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

		return getViewList(1,10, "","","");
	}

	@Override
	public List<AccListForAdminView> getViewList(int startIndex, int endIndex) {

		return getViewList(startIndex, endIndex, "","","");
	}

	@Override
	public List<AccListForAdminView> getViewList(int startIndex, int endIndex,String ac, String field,  String query) {

		List<AccListForAdminView> list = new ArrayList<AccListForAdminView>();

		String url = DBContext.URL;
		String sql = "SELECT * FROM ACC_LIST_FOR_ADMIN WHERE REG_STATUS=1 AND NUM BETWEEN ? AND ?  ORDER BY REGDATE DESC"; 


		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,  startIndex);
			st.setInt(2, endIndex);
			st.setString(3, ac);
			st.setString(4, field);
			st.setString(5, query);
			
			ResultSet rs = st.executeQuery();




			while(rs.next()) {
				int id = rs.getInt("id");
				int num = rs.getInt("NUM"); 
				String companyName = rs.getString("company_name");
				String accName = rs. getString("acc_name");
				String location = rs.getString("location");
				Date regdate = rs.getDate("regdate");
				String phone = rs.getString("phone");
				int regStatus = rs.getInt("reg_status");
				String accType = rs.getString("acc_type");

				AccListForAdminView a = new AccListForAdminView();
				
				a.setId(id);
				a.setNum(num);
				a.setCompanyName(companyName);
				a.setName(accName);
				a.setLocation(location);
				a.setRegdate(regdate);
				a.setPhone(phone);
				a.setRegStatus(regStatus);
				a.setAccType(accType);
				
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
	public List<AccListForAdminView> getApplyViewList() {

		return getApplyViewList(1,10, "","","");
	}

	@Override
	public List<AccListForAdminView> getApplyViewList(int startIndex, int endIndex) {

		return getApplyViewList(startIndex, endIndex, "","","");
	}

	@Override
	public List<AccListForAdminView> getApplyViewList(int startIndex, int endIndex, String ac,String field, String query) {

		List<AccListForAdminView> list = new ArrayList<AccListForAdminView>();

		String url = DBContext.URL;
		String sql = "SELECT * FROM ACC_LIST_FOR_ADMIN WHERE REG_STATUS=0 AND NUM BETWEEN ? AND ?  ORDER BY REGDATE DESC"; 


		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,  startIndex);
			st.setInt(2, endIndex);
			st.setString(3, ac);
			st.setString(4, field);
			st.setString(5, query);		

			ResultSet rs = st.executeQuery();




			while(rs.next()) {
				int id = rs.getInt("id");
				int num = rs.getInt("NUM"); 
				String companyName = rs.getString("company_name");
				String accName = rs. getString("acc_name");
				String location = rs.getString("location");
				Date regdate = rs.getDate("regdate");
				String phone = rs.getString("phone");
				int regStatus = rs.getInt("reg_status");
				String accType = rs.getString("acc_type");

				AccListForAdminView a = new AccListForAdminView();
				
				a.setId(id);
				a.setNum(num);
				a.setCompanyName(companyName);
				a.setName(accName);
				a.setLocation(location);
				a.setRegdate(regdate);
				a.setPhone(phone);
				a.setRegStatus(regStatus);
				a.setAccType(accType);
				
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
