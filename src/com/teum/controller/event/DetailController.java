package com.teum.controller.event;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.dao.entity.EventListView;
import com.teum.entity.Event;
import com.teum.service.EventService;

@WebServlet("/event/detail")
public class DetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		EventService service = new EventService();
		List<EventListView> list = service.getViewList(); // 구현부에서 문제가 있는거같은데
		int size = list.size();
		
		Event currEvent = service.get(id);
		Event prevEvent = null;
		Event nextEvent = null;
		
		if (size != 1) 
			for (int i = 0; i < size; i++) {
				if (list.get(i).getId() == id) {
					if (i == 0) {
						nextEvent = service.get(list.get(i + 1).getId());
						break;
					} else if (i + 1 == size) {
						prevEvent = service.get(list.get(i - 1).getId());
						break;
					} else {
						prevEvent = service.get(list.get(i - 1).getId());
						nextEvent = service.get(list.get(i + 1).getId());
						break;
					}
				}
			}
		
		request.setAttribute("currEvent", currEvent);
		request.setAttribute("prevEvent", prevEvent);
		request.setAttribute("nextEvent", nextEvent);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}
}
