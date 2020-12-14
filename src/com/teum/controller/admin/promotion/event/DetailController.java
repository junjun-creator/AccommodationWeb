package com.teum.controller.admin.promotion.event;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.Event;
import com.teum.service.EventService;

@WebServlet("/admin/promotion/event/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
	      
		int id = Integer.parseInt(request.getParameter("id"));
		
		EventService service = new EventService();
		List<Event> list = service.getList();
		Event currEvent = service.get(id);
		Event prevEvent = null;
		Event nextEvent = null;
		
		if (list.size() == 1) { 		// 이벤트 글이 하나밖에 없을 경우 
			// 아무런 동작 X
		} else {
			if (id == list.size()) // 맨 마지막 번호인 경우
				prevEvent = service.get(id - 1);
			else if (id == 1) 		// 맨 처음 번호인 경우
				nextEvent = service.get(id + 1);
			else {
				prevEvent = service.get(id - 1);
				nextEvent = service.get(id + 1);
			}
		}
			
		request.setAttribute("currEv", currEvent);
		request.setAttribute("prevEv", prevEvent);
		request.setAttribute("nextEv", nextEvent);
		
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}
	
}
