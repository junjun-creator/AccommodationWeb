package com.teum.controller.company.userinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teum.entity.Company;
import com.teum.entity.Users;
import com.teum.service.CompanyService;
import com.teum.service.UsersService;

@WebServlet("/company/userInfo/updateInfo")
public class UpdateInfoController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("email")==null) {
			response.sendRedirect("/signin");
		}
		else if(((int)session.getAttribute("type")) != 1) {
			response.sendRedirect("/index");
		}
		else {
			
			CompanyService service = new CompanyService();
			Company c = service.get((int)session.getAttribute("id"));
			System.out.println(session.getAttribute("password"));
			
			request.setAttribute("c", c);
			request.getRequestDispatcher("updateInfo.jsp").forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		CompanyService service = new CompanyService();
		Company c = service.get((int)session.getAttribute("id"));
		
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		
		if(password != null && !password.equals("")) {
			c.setPassword(password);
		}
		if(phone != null && !phone.equals("")) {
			c.setPhone(phone);
		}
		
		int update = service.update(c);
		session.setAttribute("password", c.getPassword());
		
		response.sendRedirect("memberInfo");
	}
	
}
