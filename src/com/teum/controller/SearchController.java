package com.teum.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.teum.dao.entity.Member;
import com.teum.service.LoginService;

@WebServlet("/search")
public class SearchController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name_ = request.getParameter("name");
		String phone_ = request.getParameter("phone");
		String email_ = request.getParameter("email");
		
		String name = "";
		String phone = "";
		String email="";
		
		if(name_ != null && !name_.equals(""))
			name = name_;
		if(phone_ != null && !phone_.equals(""))
			phone = phone_;
		if(email_ != null && !email_.equals(""))
			email = email_;
		
		LoginService service = new LoginService();
		JSONObject obj = new JSONObject();
		System.out.println(name);
		System.out.println(phone);

		if(Integer.parseInt(request.getParameter("category")) == 0) {
			String userEmail = service.getEmail(name,phone);
			if(userEmail==null || userEmail.equals("")) {
				obj.put("result", 0);
			}
			else {
				obj.put("userEmail", userEmail);
				obj.put("result", 1);
			}
		}
		else {
			String password = service.getPwd(name,email,phone);
			if(password==null || password.equals("")) {
				obj.put("result", 0);
			}
			else {
				obj.put("password", password);
				obj.put("result", 1);
			}
		}
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
	}
	
	
	
}
