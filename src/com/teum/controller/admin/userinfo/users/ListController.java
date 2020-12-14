package com.teum.controller.admin.userinfo.users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.Member;
import com.teum.entity.Users;
import com.teum.service.MemberService;
import com.teum.service.UsersService;

@WebServlet("/admin/userInfo/users/usersList")
public class ListController extends HttpServlet{
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsersService service = new UsersService();
		List<Users> list = new ArrayList<>();
		list = service.getList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("privateMemberList.jsp").forward(request, response);
	}
	
}
