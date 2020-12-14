package com.teum.controller.admin.promotion.event;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.service.EventService;

@WebServlet("/admin/promotion/event/delete")
public class DeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		EventService service = new EventService();
		service.delete(id);
		
		response.sendRedirect("list");
	}
	
}
