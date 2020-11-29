package com.teum.controller.admin.userinfo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.Member;
import com.teum.service.MemberDetailService;

@WebServlet("/admin/userInfo/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		
		MemberDetailService service = new MemberDetailService();
		Member m = service.getDetail(email);
		
		request.setAttribute("member", m);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/userInfo/detail.jsp");
		rd.forward(request, response);
	}
	
}
