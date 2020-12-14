package com.teum.controller.admin.promotion.event;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.Event;
import com.teum.service.EventService;

@WebServlet("/admin/promotion/event/edit")
public class EditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		EventService service = new EventService();
		Event event = service.get(id);
		
		request.setAttribute("event", event);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String openStatus_ = request.getParameter("open");
		int openStatus = 0;
		
		if (openStatus_ != null && !openStatus_.equals(""))
			openStatus = Integer.parseInt(openStatus_);
		
		// String -> Date 변환
		DateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = dateFormat.parse(request.getParameter("start-date"));
			endDate = dateFormat.parse(request.getParameter("end-date"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Event event = new Event(id, title, openStatus, startDate, endDate);
		
		EventService service = new EventService();
		service.update(event);
		
		response.sendRedirect("detail?id=" + id);
	}
	
}