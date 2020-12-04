package com.teum.controller.admin.promotion.event;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.service.EventService;

@WebServlet("/admin/promotion/event/del")
public class DelController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eventNo = Integer.parseInt(request.getParameter("eventNo"));
		
		EventService service = new EventService();
		service.delete(eventNo);
		
		response.sendRedirect("list");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eventNo = Integer.parseInt(request.getParameter("eventNo"));
		String[] delChks = request.getParameterValues("delChk");
		
		for (String s : delChks) 
			System.out.println(s);
		
		EventService service = new EventService();
		//service.delete(eventNo);
	}
}
