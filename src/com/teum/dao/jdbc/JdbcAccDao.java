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
import com.teum.dao.entity.AccImageListView;
import com.teum.dao.entity.AccListForAdminView;
import com.teum.dao.entity.AccommodationListView;
import com.teum.dao.entity.GoldenTimeView;
import com.teum.dao.entity.ReservationForCompanyView;
import com.teum.entity.Acc;
import com.teum.entity.Event;

public class JdbcAccDao implements AccDao{

	@Override
	public List<AccListForAdminView> getViewList() {

		return getViewList("","companyName","", 1,10);
	}

	@Override
	public List<AccListForAdminView> getViewList(int startIndex, int endIndex) {

		return getViewList("","companyName","", startIndex, endIndex);
	}

	@Override
	public List<AccListForAdminView> getViewList(String ac, String field,  String query, int startIndex, int endIndex ) {

		List<AccListForAdminView> list = new ArrayList<AccListForAdminView>();

		String url = DBContext.URL;
		String sql;
		
		if(query == null || query.equals("")) {
			sql = "SELECT * FROM ( SELECT ROWNUM NUM, A.* " +
					"FROM (SELECT * FROM ACC_LIST_FOR_ADMIN WHERE REG_STATUS = 1 ORDER BY REGDATE DESC) A ) " +
					"WHERE NUM BETWEEN ? AND ?"; 
		}else {
			sql = "SELECT * FROM "+
					"(SELECT ROWNUM NUM, A.* FROM "+
					"(SELECT * FROM ACC_LIST_FOR_ADMIN WHERE REG_STATUS = 1 "+
					"AND ACC_TYPE = ? AND " + field + " LIKE ? ORDER BY REGDATE DESC) A )" + 
					"WHERE NUM BETWEEN ? AND ?";
		}
		

		

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			if(query == null || query.equals("")) {
				st.setInt(1, startIndex);
				st.setInt(2, endIndex);
			} else {
				st.setString(1, ac);
				st.setString(2, query);
				st.setInt(3, startIndex);
				st.setInt(4, endIndex);
			}
			
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

		return getApplyViewList("","companyName","",1,10);
	}

	@Override
	public List<AccListForAdminView> getApplyViewList(int startIndex, int endIndex) {

		return getApplyViewList("","companyName","",startIndex, endIndex);
	}

	@Override
	public List<AccListForAdminView> getApplyViewList(String ac,String field, String query, int startIndex, int endIndex ) {

		List<AccListForAdminView> list = new ArrayList<AccListForAdminView>();

		String url = DBContext.URL;
		String sql;
		
		if(query == null || query.equals("")) {
			sql = "SELECT * FROM ( SELECT ROWNUM NUM, A.* " +
					"FROM (SELECT * FROM ACC_LIST_FOR_ADMIN WHERE REG_STATUS = 0 ORDER BY REGDATE DESC) A ) " +
					"WHERE NUM BETWEEN ? AND ?"; 
		}else {
			sql = "SELECT * FROM "+
					"(SELECT ROWNUM NUM, A.* FROM "+
					"(SELECT * FROM ACC_LIST_FOR_ADMIN WHERE REG_STATUS = 0 "+
					"AND ACC_TYPE = ? AND " + field + " LIKE ? ORDER BY REGDATE DESC) A )" + 
					"WHERE NUM BETWEEN ? AND ?";
		}

		

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			if(query == null || query.equals("")) {
				st.setInt(1, startIndex);
				st.setInt(2, endIndex);
			} else {
				st.setString(1, ac);
				st.setString(2, query);
				st.setInt(3, startIndex);
				st.setInt(4, endIndex);
				

			}
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
	public Acc get(int id) {

		Acc acc = null;
		String url = DBContext.URL;
		String sql = "SELECT * FROM ACC WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if(rs.next()) {
				int nid = rs.getInt("ID");
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
				int goldentimeStatus = rs.getInt("goldentime_Status");
				
				acc = new Acc(
						nid,
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
		return acc;
	}
	
	
	@Override
	public Acc applyGet(int id) {
		Acc a = null;

		String url = DBContext.URL;
		String sql = "SELECT * FROM ACC_LIST_FOR_ADMIN WHERE REG_STATUS=0 AND ID=?";//조건 추가(accName)

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, id);
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				int nid = rs.getInt("id");
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
						nid,
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
	public int delete(int id) {
		int result=0;
		String url = DBContext.URL;
		String sql = "DELETE FROM ACC WHERE ID=?";

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
	public int deleteAll(int[] ids) {
		int result = 0;
		
		String url = DBContext.URL;
		
		String params = "";
		for(int i = 0; i<ids.length; i++) {
			params += ids[i];
			if(i < ids.length-1)
				params+= ",";
			System.out.println(params);
		}
		String sql = "DELETE ACC WHERE ID IN("+params+")";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			result = st.executeUpdate(sql);//이 업데이트 문은 insert, update, delete를 실행할때 사용
			
			st.close();
			con.close();         
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

	@Override
	public int approval(int id) {
		int result=0;
		String url = DBContext.URL;
		String sql = "UPDATE ACC SET REG_STATUS=1, APPROVAL_DATE=SYSTIMESTAMP WHERE ID=?";
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
	public int approvalAll(int[] ids) {
		int result = 0;
		String url = DBContext.URL;
		String params = "";
		for(int i = 0; i<ids.length; i++) {
			params += ids[i];
			if(i < ids.length-1)
				params+= ",";
		}
		String sql = "UPDATE ACC SET REG_STATUS=1 , APPROVAL_DATE=SYSTIMESTAMP WHERE ID IN("+params+")";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			result = st.executeUpdate(sql);//이 업데이트 문은 insert, update, delete를 실행할때 사용
			
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

	@Override
	public List<Acc> getList(String location) {
		List<Acc> list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM ACC WHERE LOCATION LIKE ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, "%" + location + "%");
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("ID"); 
				int accTypeId = rs.getInt("ACC_TYPE_ID");
				
				Acc acc = new Acc();
				
				acc.setId(id);
				acc.setAccTypeId(accTypeId);
				
				list.add(acc);
			};

			rs.close();
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
	public List<Acc> getList(int companyId) {
		List<Acc> list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM ACC WHERE COMPANY_ID = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setInt(1, companyId);
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("ID"); 
				int goldentimeStatus =rs.getInt("GOLDENTIME_STATUS");
				
				Acc acc = new Acc();
				
				acc.setId(id);
				acc.setGoldentimeStatus(goldentimeStatus);
				list.add(acc);
			};

			rs.close();
			pst.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return list;
	}
  
	public int getAccCount(String ac,String field, String query) {
		int count = 0;
		
		String url = DBContext.URL;
		String sql;
		
		if(query == null || query.equals("")) {
			sql = "SELECT COUNT(ID) COUNT FROM ( SELECT ROWNUM NUM, A.* " +
					"FROM (SELECT * FROM ACC_LIST_FOR_ADMIN WHERE REG_STATUS = 1 ORDER BY REGDATE DESC) A ) "; 
		}else {
			sql = "SELECT COUNT(ID) COUNT FROM "+
					"(SELECT ROWNUM NUM, A.* FROM "+
					"(SELECT * FROM ACC_LIST_FOR_ADMIN WHERE REG_STATUS = 1 "+
					"AND ACC_TYPE = ? AND " + field + " LIKE ? ORDER BY REGDATE DESC) A )";
		}
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			if(query == null || query.equals("")) {
				
			} else {
				st.setString(1, ac);
				st.setString(2, query);
			}
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next())
				count = rs.getInt("count");

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
		
		return count;
	}
	@Override
	public int getApplyAccCount(String ac, String field, String query) {
int count = 0;
		
		String url = DBContext.URL;
		String sql;
		
		if(query == null || query.equals("")) {
			sql = "SELECT COUNT(ID) COUNT FROM ( SELECT ROWNUM NUM, A.* " +
					"FROM (SELECT * FROM ACC_LIST_FOR_ADMIN WHERE REG_STATUS = 0 ORDER BY REGDATE DESC) A ) "; 
		}else {
			sql = "SELECT COUNT(ID) COUNT FROM "+
					"(SELECT ROWNUM NUM, A.* FROM "+
					"(SELECT * FROM ACC_LIST_FOR_ADMIN WHERE REG_STATUS = 0 "+
					"AND ACC_TYPE = ? AND " + field + " LIKE ? ORDER BY REGDATE DESC) A )";
		}
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			if(query == null || query.equals("")) {
				
			} else {
				st.setString(1, ac);
				st.setString(2, query);
			}
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next())
				count = rs.getInt("count");

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
		
		return count;
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
	public List<Acc> applyGetList() {
		String url = DBContext.URL;
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
	public List<Integer> getIds(int companyId, int accType) {
		List<Integer> list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql;
		if(accType == 0)
			sql = "SELECT ID FROM ACC WHERE COMPANY_ID = ?";
		else
			sql = "SELECT ID FROM ACC WHERE COMPANY_ID = ? AND ACC_TYPE_ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, companyId);
			if(accType != 0)
				pst.setInt(2, accType);
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("ID"); 
				
				list.add(id);
			};

			rs.close();
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
	public List<AccImageListView> getList(int type, String location, String search) {
		List<AccImageListView> list = new ArrayList<>();
		String url = DBContext.URL;
		String sql = "";
		
		if (search.equals(""))
			sql = "SELECT * FROM ACC_IMAGE_LIST_VIEW WHERE ACC_TYPE_ID=? AND LOCATION LIKE ? AND REG_STATUS = 1";
		else
			sql = "SELECT * FROM ACC_IMAGE_LIST_VIEW WHERE NAME LIKE ? OR LOCATION LIKE ? AND REG_STATUS = 1";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement pst = con.prepareStatement(sql);
			
			if (search.equals("")) {
				pst.setInt(1, type);
				pst.setString(2, "%" + location + "%");
			} else {
				pst.setString(1, "%" + search + "%");
				pst.setString(2, "%" + search + "%");
			}
			
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("id"); 
				String name = rs. getString("name");
				String phone = rs.getString("phone");
				String filename = rs.getString("FILENAME");
				String fileroute = rs.getString("FILEROUTE");
				String location2 = rs.getString("LOCATION");
				int regStatus = rs.getInt("reg_status");
				Date approvalDate = rs.getDate("approval_date");
				int adminId = rs.getInt("admin_id");
				int companyId = rs.getInt("company_id");
				Date regdate = rs.getDate("regdate");
				int accTypeId = rs.getInt("acc_type_id");
				Date gtStartDate = rs.getDate("GT_START_DATE");
				Date gtEndDate = rs.getDate("GT_END_DATE");
				int saleprice = rs.getInt("SALEPRICE");
				int goldentimeStatus = rs.getInt("goldentime_Status");
				
				AccImageListView accImageListView = new AccImageListView(
						id, name, 
						filename, fileroute,
						phone, location2, regStatus,
						approvalDate, adminId, companyId, regdate,
						accTypeId, gtStartDate, gtEndDate,
						saleprice, goldentimeStatus);
				
				list.add(accImageListView);
			};

			rs.close();
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
	public List<AccommodationListView> getAccListByCompany(int companyId, int accType) {
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "SELECT * FROM ACCOMMODATION_LIST_VIEW WHERE COMPANY_ID=? AND REG_STATUS > 0";
		String sql_ = " AND ACC_TYPE=?";
		
		if(accType != 0)
			sql = sql+sql_;
		
		List<AccommodationListView> list = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//String sql = "SELECT * FROM MEMBER WHERE TYPE = ?";
			//PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,companyId);
			if(accType !=0) {
				ps.setInt(2,accType);
			}
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int accId = rs.getInt("acc_id");
				String accName = rs.getString("acc_name");
				String accLocation = rs.getString("acc_location");
				String accFileName = rs.getString("acc_filename");
				String accFileRoute = rs.getString("acc_fileroute");
				int price = rs.getInt("price");
				int score = rs.getInt("score");
				
				AccommodationListView alv = new AccommodationListView();
				
				alv.setAccId(accId);;
				alv.setCompanyId(companyId);
				alv.setAccType(accType);
				alv.setAccName(accName);
				alv.setAccLocation(accLocation);
				alv.setAccFileName(accFileName);
				alv.setAccFileRoute(accFileRoute);
				alv.setPrice(price);
				alv.setScore(score);
				
				list.add(alv);
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
	public List<Acc> getRegList(int companyId, int regStatus, int startIndex,int endIndex) {
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "SELECT * FROM (SELECT ROWNUM NUM, ACC.* FROM ACC WHERE COMPANY_ID=? AND REG_STATUS=?) WHERE NUM BETWEEN ? AND ?";
		
		
		List<Acc> list = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//String sql = "SELECT * FROM MEMBER WHERE TYPE = ?";
			//PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,companyId);
			ps.setInt(2, regStatus);
			ps.setInt(3, startIndex);
			ps.setInt(4, endIndex);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int rownum = rs.getInt("num");
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String location = rs.getString("location");
				Date approvalDate = rs.getDate("approval_date");
				int accTypeId = rs.getInt("acc_type_id");
				Date regdate = rs.getDate("regdate");
				
				Acc a = new Acc();
				
				a.setId(id);
				a.setName(name);
				a.setPhone(phone);
				a.setCompanyId(companyId);
				a.setRegStatus(regStatus);
				a.setLocation(location);
				a.setApprovalDate(approvalDate);
				a.setAccTypeId(accTypeId);
				a.setRownum(rownum);
				a.setRegdate(regdate);
				
				list.add(a);
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
	public int getRegCount(int companyId, int regStatus) {
		int result = 0;
		String url = DBContext.URL;
		String dbid = DBContext.UID;
		String dbpwd = DBContext.PWD;
		
		String sql = "SELECT COUNT(*) FROM ACC WHERE COMPANY_ID=? AND REG_STATUS=?";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			//String sql = "SELECT * FROM MEMBER WHERE TYPE = ?";
			//PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,companyId);
			ps.setInt(2, regStatus);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt(1);
			}
			System.out.println(result);
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
