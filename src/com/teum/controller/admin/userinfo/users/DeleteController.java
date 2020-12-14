package com.teum.controller.admin.userinfo.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.service.CompanyService;
import com.teum.service.MemberService;
import com.teum.service.UsersService;

@WebServlet("/admin/userInfo/users/delete")
public class DeleteController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] id_ = request.getParameterValues("selected");
		int[] id = new int[id_.length];
		for(int i=0;i<id_.length;i++) {
			id[i] = Integer.parseInt(id_[i]);
		}
		
		UsersService service = new UsersService();
		System.out.println(id[0]);
		service.delete(id);
		response.sendRedirect("/admin/userInfo/users/usersList");
		
		
//		MemberService service = new MemberService();
//		service.delete(email);
//		response.sendRedirect("list");
	}
	
}
