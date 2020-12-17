package com.teum.controller.event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.dao.entity.EventListView;
import com.teum.service.EventService;

@WebServlet("/event/list")
public class ListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String page_ = request.getParameter("p");
		int page = 1;
		
		if (page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		
		EventService service = new EventService();
		List<EventListView> list = new ArrayList<EventListView>();
				
		list = service.getViewList(page, 5);
		
//		for (EventListView view : list) {
//			System.out.println(view.getStartDate());
//			System.out.println(view.getTitle());
//		}
			
		int count = service.getCount(); // 모든 컬럼의 수를 가져옴
		
		Date now = new Date();
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.setAttribute("now", now);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
}
