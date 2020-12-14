package com.teum.controller.admin.userinfo.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.Company;
import com.teum.entity.Users;
import com.teum.service.CompanyService;
import com.teum.service.UsersService;

@WebServlet("/admin/userInfo/company/companyList")
public class ListController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CompanyService service = new CompanyService();
		List<Company> list = new ArrayList<>();
		list = service.getList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("corporateMemberList.jsp").forward(request, response);
	}
	
}
