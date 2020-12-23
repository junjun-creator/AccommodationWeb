package com.teum.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.teum.dao.entity.Member;
import com.teum.service.LoginService;

@WebServlet("/signin")
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String returnURL = request.getParameter("return-url");
		
		if(session.getAttribute("email")!=null) {
			response.sendRedirect("/index");
		}else {
			
			request.setAttribute("returnURL",returnURL);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String returnURL = request.getParameter("return-url");
		
		LoginService service = new LoginService();
		
		Member m = service.get(email,password);
		JSONObject obj = new JSONObject();
		int emailValid=0;
		
		if(m.getId() != 0)
			emailValid = 1;
		
		obj.put("valid", emailValid);
		obj.put("returnURL", returnURL);
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
