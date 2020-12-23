package com.teum.controller.user.userinfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teum.dao.entity.PickListView;
import com.teum.entity.Pick;
import com.teum.entity.Users;
import com.teum.service.PickService;
import com.teum.service.UsersService;

@WebServlet("/user/userInfo/pickList")
public class PickController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("email")==null) {
			response.sendRedirect("/signin?return-url=/user/userInfo/pickList");
		}
		else if(((int)session.getAttribute("type")) != 0) {
			response.sendRedirect("/index");
		}
		else {
			PickService service = new PickService();
			List<PickListView> list = service.getList((int)session.getAttribute("id"));
			List<Integer> accIds = new ArrayList<>();
			for(PickListView pl : list) {
				accIds.add(pl.getAccId());
			}
			
			List<Double> pointList = service.getPointList(accIds);
			request.setAttribute("list", list);
			request.setAttribute("pointList", pointList);
			request.getRequestDispatcher("goodsOnMyList.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int accId = Integer.parseInt(request.getParameter("accId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		Pick p = new Pick(accId,userId);
		
		PickService service = new PickService();
		int delete = 0;
				
		delete = service.delete(p);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(delete);
	}
	
	
	
}
