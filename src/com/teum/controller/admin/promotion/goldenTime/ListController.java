package com.teum.controller.admin.promotion.goldenTime;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/promotion/goldenTime/list")
public class ListController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * GoldenTimeService service = new GoldenTimeService(); List<GoldenTime> list =
		 * service.getList();
		 */
		
		//request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
	}
}
