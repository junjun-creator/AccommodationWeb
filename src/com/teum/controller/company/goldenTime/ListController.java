package com.teum.controller.company.goldenTime;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teum.dao.entity.GoldenTimeView;
import com.teum.service.GoldenTimeService;

@WebServlet("/company/goldenTime/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();	
			
		
		//int id = (int)session.getAttribute("id");
		int id =1;
		GoldenTimeService service = new GoldenTimeService();
		List<GoldenTimeView> list = service.getGoldenList(id); 
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chk_ = request.getParameter("check");
		String cmd = request.getParameter("cmd");
		String ids_ = request.getParameter("ids");
		
		int chk = Integer.parseInt(chk_);
		GoldenTimeService service = new GoldenTimeService();
		
		
	
		switch (cmd) {
		case "진행":
			
			service.open(chk);
			
			break;
			
		case "대기":
			
			service.close(chk);
			
			break;
		case "수정":
			
			break;
		}
		
		response.sendRedirect("list");
	}
}
