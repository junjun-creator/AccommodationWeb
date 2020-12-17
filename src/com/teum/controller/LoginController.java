package com.teum.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.teum.dao.entity.Member;
import com.teum.service.LoginService;
import com.teum.service.UsersService;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//UsersService service = new UsersService();
		LoginService service = new LoginService();
		
//		int emailValid = service.valid(email,password);
		Member m = service.get(email,password);
		
		JSONObject obj = new JSONObject();
		int emailValid=0;
		
		if(m.getId() != 0)
			emailValid = 1;
		
		obj.put("valid", emailValid);
		//}
		
		HttpSession session = request.getSession();
		if(emailValid == 1) {
			session.setAttribute("email", email);
			session.setAttribute("id",m.getId());
			session.setAttribute("type",m.getType());
			session.setAttribute("password", m.getPassword());
		}


		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
	}
	
}
