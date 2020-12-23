package com.teum.controller.user.userinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teum.entity.Users;
import com.teum.service.UsersService;

@WebServlet("/user/userInfo/updateInfo")
public class UpdateInfoController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("email")==null) {
			response.sendRedirect("/signin?return-url=/user/userInfo/updateInfo");
		}
		else if(((int)session.getAttribute("type")) != 0) {
			response.sendRedirect("/index");
		}
		else {
			
			UsersService service = new UsersService();
			Users u = service.get((int)session.getAttribute("id"));
			System.out.println(session.getAttribute("password"));
			
			request.setAttribute("u", u);
			request.getRequestDispatcher("updateInfo.jsp").forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		UsersService service = new UsersService();
		Users u = service.get((int)session.getAttribute("id"));
		
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		
		if(password != null && !password.equals("")) {
			u.setPassword(password);
		}
		if(phone != null && !phone.equals("")) {
			u.setPhone(phone);
		}
		
		int update = service.update(u);
		session.setAttribute("password", u.getPassword());
		
		response.sendRedirect("memberInfo");
	}
	
	
	
}
