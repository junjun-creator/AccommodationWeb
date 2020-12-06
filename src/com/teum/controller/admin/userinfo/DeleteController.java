package com.teum.controller.admin.userinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.service.MemberService;

@WebServlet("/admin/userInfo/delete")
public class DeleteController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		MemberService service = new MemberService();
		service.delete(email);
		response.sendRedirect("list");
	}
	
}
