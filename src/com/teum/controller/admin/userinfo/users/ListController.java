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

import com.teum.dao.entity.Member;
import com.teum.entity.Users;
import com.teum.service.MemberService;
import com.teum.service.UsersService;

@WebServlet("/admin/userInfo/users/usersList")
public class ListController extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsersService service = new UsersService();
		List<Users> list = new ArrayList<>();
		
		String field_ = request.getParameter("field");
		String query_ = request.getParameter("query");
		String page_ = request.getParameter("page");
		
		String field = "name";
		String query = "";
		int page = 1;
		if(field_ != null && !field_.equals("")) {
			field = field_;
		}
		if(query_ != null && !query_.equals("")) {
			query = query_;
		}
		if(page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		
		list = service.getList(page, field, query);
		int count = service.getCount(field,query);

		//페이저 전체 수
		double pageLastCount = Math.ceil(count/10.0);
		
		ArrayList<Integer> rankCount = service.getRankCount();
		
//		
		request.setAttribute("list", list);
		request.setAttribute("pageLastCount",(int)pageLastCount);
		request.setAttribute("rankCount",rankCount);
		
		request.getRequestDispatcher("privateMemberList.jsp").forward(request, response);
	}
	
	
}
