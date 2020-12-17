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
import com.teum.dao.entity.GoldenTimeView;
import com.teum.entity.Acc;
import com.teum.entity.Event;

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
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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

		return getViewList(1,10, "","companyName","");
	}

	@Override
	public List<AccListForAdminView> getViewList(int startIndex, int endIndex) {

		return getViewList(startIndex, endIndex,"","companyName","");
	}

	@Override
	public List<AccListForAdminView> getViewList( int startIndex, int endIndex, String ac, String field,  String query) {

		List<AccListForAdminView> list = new ArrayList<AccListForAdminView>();

		String url = DBContext.URL;
		String sql = "SELECT * FROM ACC_LIST_FOR_ADMIN " +
						" WHERE REG_STATUS=1 AND NUM BETWEEN ? AND ? AND" +
						" ACC_TYPE = ? AND "+ field +" LIKE ? ORDER BY REGDATE DESC"; 

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, startIndex);
			st.setInt(2, endIndex);
			st.setString(3, ac);
			st.setString(4, query);
			
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

	@Override
	public Acc getLast() {
		// 마지막 인덱스의 event를 뽑아오는 쿼리문을 작성하자
		Acc acc = null;

		String url = DBContext.URL;
		String sql = "SELECT * FROM ACC WHERE ID = (SELECT MAX(ID) FROM ACC)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String phone = rs.getString("PHONE");
				String location = rs.getString("LOCATION");
				int regStatus = rs.getInt("REG_STATUS");
				Date approvalDate = rs.getDate("APPROVAL_DATE");
				int adminId = rs.getInt("ADMIN_ID");
				int companyId = rs.getInt("COMPANY_ID");
				Date regdate = rs.getDate("REGDATE");
				int accTypeId = rs.getInt("ACC_TYPE_ID");
				Date gtStartDate = rs.getDate("GT_START_DATE");
				Date gtEndDate = rs.getDate("GT_END_DATE");
				int salePrice = rs.getInt("SALEPRICE");
				int goldenTimeStatus = rs.getInt("GOLDENTIME_STATUS");

				acc = new Acc(
						id, name, phone, location,
						regStatus, approvalDate, adminId,
						companyId, regdate, accTypeId, gtStartDate,
						gtEndDate, salePrice, goldenTimeStatus);
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
		return acc;
	}

	@Override
	public int insert(Acc acc) {
		int result = 0;

		String url = DBContext.URL;
		String sql = "INSERT INTO ACC(NAME, PHONE, LOCATION, ACC_TYPE_ID, COMPANY_ID, ADMIN_ID) VALUES(?, ?, ?, ?, ?, ?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, acc.getName());
			pst.setString(2, acc.getPhone());
			pst.setString(3, acc.getLocation());
			pst.setInt(4, acc.getAccTypeId());
			pst.setInt(5, acc.getCompanyId());
			pst.setInt(6, acc.getAdminId());
			
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
	public int update(Acc acc) {
		return 0;
	}

	@Override
	public List<GoldenTimeView> getGoldenList() {
		List<GoldenTimeView> list = new ArrayList<GoldenTimeView>();
		String url = DBContext.URL;
		String sql = "SELECT * FROM GOLDENTIME_LIST_VIEW WHERE REG_STATUS = 1 AND COMPANY_ID = 1 "; 

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

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

				GoldenTimeView G = new GoldenTimeView();
				
			
				
				list.add(G);
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
