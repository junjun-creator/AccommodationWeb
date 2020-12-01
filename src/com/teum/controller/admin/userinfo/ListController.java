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
		MemberService service = new MemberService();
		List<Member> list=null;
		list = service.getList();
		RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
		try {
			if(request.getParameter("type").equals("기업회원")) {
				list = service.getListByType(request.getParameter("type"));
				rd = request.getRequestDispatcher("corporateMemberList.jsp");
			}
			else if(request.getParameter("type").equals("개인회원")) {
				list = service.getListByType(request.getParameter("type"));
				rd = request.getRequestDispatcher("privateMemberList.jsp");
			}
			
		}catch(Exception e) {
		}
		System.out.println(list);
		request.setAttribute("list", list);
		rd.forward(request, response);
	}
	
}
