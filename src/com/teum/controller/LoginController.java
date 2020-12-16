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
		
		UsersService service = new UsersService();
		
		int emailValid = service.valid(email,password);
		
		JSONObject obj = new JSONObject();
		
		//if(emailValid == 1){
		obj.put("valid", emailValid);
		//}
		System.out.println("valid = " +emailValid);
		
		HttpSession session = request.getSession();
		session.setAttribute("email", email);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
	}
	
}
