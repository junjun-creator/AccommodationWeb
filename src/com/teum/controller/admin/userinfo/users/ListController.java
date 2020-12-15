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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsersService service = new UsersService();
		List<Users> list = new ArrayList<>();
		int count = service.getCount();
		ArrayList<Integer> rankCount = service.getRankCount();
		
		String queryString = request.getQueryString();
		
		if(queryString ==null) {
			list = service.getList();
		}
		else if(queryString.contains("field")){
			count = service.getCount(request.getParameter("field"),request.getParameter("query"));
			if(queryString.contains("page")) {
				int page = Integer.parseInt(request.getParameter("page"));
				list = service.getList(page, request.getParameter("field"),request.getParameter("query"));
			}
			else {
				list = service.getList(request.getParameter("field"),request.getParameter("query"));
			}
		}
		else {
			int page = Integer.parseInt(request.getParameter("page"));
			list = service.getList(page);
			request.setAttribute("page", page);
		}
		//페이저 전체 수
		int pageCount = count/10 +1;
		
		if(count % 10 == 0)
			pageCount = count/10;
//		System.out.println(pageCount);
		
		request.setAttribute("list", list);
		request.setAttribute("pageCount",pageCount);
		request.setAttribute("rankCount",rankCount);
		
		request.getRequestDispatcher("privateMemberList.jsp").forward(request, response);
	}
	
	
}
