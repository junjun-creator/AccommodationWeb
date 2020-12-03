package com.teum.controller.reg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.Member;
import com.teum.service.MemberService;

@WebServlet("/reg")
public class RegController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("GET"))
			request.getRequestDispatcher("reg.jsp").forward(request, response);
		else if(request.getMethod().equals("POST")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String pwd = request.getParameter("pwd");
			String birthday = request.getParameter("birthday");
			String phone = request.getParameter("phone");
			String type = request.getParameter("type");
			
			Member m = new Member();
			m.setName(name);
			m.setEmail(email);
			m.setPwd(pwd);
			m.setBirthday(birthday);
			m.setPhone(phone);
			m.setType(type);
			
			MemberService service = new MemberService();
			int result = service.insert(m);
			
			response.sendRedirect("/admin/userInfo/list");
			
		}
	}
	
}
