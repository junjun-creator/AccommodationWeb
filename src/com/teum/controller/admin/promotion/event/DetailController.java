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
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
	      
		int eventNo = Integer.parseInt(request.getParameter("eventNo"));
		
		EventService service = new EventService();
		List<Event> list = service.getList();
		Event currEv = service.getNo(eventNo);
		Event prevEv = null;
		Event nextEv = null;
		
		
		if (list.size() == 1) { // 이벤트 글이 하나밖에 없을 경우 
			// 아무런 동작 X
		} else {
			if (eventNo == list.size()) // 맨 마지막 번호인 경우
				prevEv = service.getNo(eventNo - 1);
			else if (eventNo == 1) 		// 맨 처음 번호인 경우
				nextEv = service.getNo(eventNo + 1);
			else {
				prevEv = service.getNo(eventNo - 1);
				nextEv = service.getNo(eventNo + 1);
			}
		}
			
		request.setAttribute("currEv", currEv);
		request.setAttribute("prevEv", prevEv);
		request.setAttribute("nextEv", nextEv);
		
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}
}
