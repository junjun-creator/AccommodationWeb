package com.teum.controller.admin.userinfo.company;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.service.CompanyService;
import com.teum.service.UsersService;

@WebServlet("/admin/userInfo/company/delete")
public class DeleteController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] id_ = request.getParameterValues("selected");
		int[] id = new int[id_.length];
		for(int i=0;i<id_.length;i++) {
			id[i] = Integer.parseInt(id_[i]);
		}
		
		CompanyService service = new CompanyService();
		service.delete(id);
		response.sendRedirect("/admin/userInfo/company/usersList");
		
		
//		MemberService service = new MemberService();
//		service.delete(email);
//		response.sendRedirect("list");
	}
	
}