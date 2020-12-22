package com.teum.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.teum.service.UsersService;

@WebServlet("/checkId")
public class DuplicationCheckController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		UsersService service = new UsersService();
		
		int duplicate=0;
		
		duplicate = service.checkDuplicate(email);
		
		JSONObject obj = new JSONObject();
		obj.put("duplicate", duplicate);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
	}
}
