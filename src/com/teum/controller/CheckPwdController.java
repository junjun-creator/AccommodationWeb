package com.teum.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

@WebServlet("/checkPwd")
public class CheckPwdController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		int valid = 0;
		if(session.getAttribute("password") != null) {
			if(session.getAttribute("password").equals(request.getParameter("password")))
				valid = 1;
		}
		
		JSONObject obj = new JSONObject();
		obj.put("valid", valid);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
	}
	
}
