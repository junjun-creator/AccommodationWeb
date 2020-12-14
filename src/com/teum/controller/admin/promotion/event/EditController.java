package com.teum.controller.admin.promotion.event;

import java.io.IOException;
import java.io.PrintWriter;
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
		
		EventService service = new EventService();
		Event event = new Event(title);
		
		event.setId(id);
		service.update(event);
		
		response.sendRedirect("detail?id=" + id);
	}
	
}