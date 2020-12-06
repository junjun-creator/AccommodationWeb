package com.teum.controller.admin.userinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.Member;
import com.teum.service.MemberService;

@WebServlet("/admin/userInfo/list")
public class ListController extends HttpServlet{
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = "all";
		if(request.getParameter("type") != null && !request.getParameter("type").equals(""))
			type = request.getParameter("type");
		
		MemberService service = new MemberService();
		List<Member> list = null;
		RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
		if(type.equals("기업회원")) {
			list = service.getListByType(request.getParameter("type"));
			rd = request.getRequestDispatcher("corporateMemberList.jsp");
		}
		else if(type.equals("개인회원")) {
			list = service.getListByType(request.getParameter("type"));
			rd = request.getRequestDispatcher("privateMemberList.jsp");
		}
		else
			list = service.getList();
		System.out.println(list);
		request.setAttribute("list", list);
		rd.forward(request, response);
	}
	
}
