package com.teum.controller.admin.userinfo.company;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.Company;
import com.teum.entity.Users;
import com.teum.service.CompanyService;
import com.teum.service.UsersService;

@WebServlet("/admin/userInfo/company/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		
		CompanyService service = new CompanyService();
		Company c = service.get(Integer.parseInt(id));
		request.setAttribute("member", c);
		
//		MemberService service = new MemberService();
//		Member m = service.getDetail(email);
//		System.out.println(m.getName());
		
//		request.setAttribute("member", m);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/userInfo/company/corporateMemberDetail.jsp");
		rd.forward(request, response);
	}
	
}
