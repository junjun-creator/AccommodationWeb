package com.teum.controller.admin.promotion.event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.dao.entity.EventListView;
import com.teum.service.EventService;

@WebServlet("/admin/promotion/event/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		String page_ = request.getParameter("p");
		String search_ = request.getParameter("search");
		int page = 1;
		String search = "";
		
		if (page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		
		if (search_ != null && !search_.equals(""))
			search = search_;
		
		EventService service = new EventService();
		List<EventListView> list = new ArrayList<EventListView>();
		
		list = service.getViewList(page, 10, search);
		int count = service.getCount(search);
		
		Date now = new Date();
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.setAttribute("now", now);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] openIds = request.getParameterValues("open-id");
		String[] delIds = request.getParameterValues("del-id");
		String cmd = request.getParameter("cmd");
		String ids_ = request.getParameter("ids");
		String[] ids = ids_.trim().split(" ");
		
		EventService service = new EventService();
		
		switch (cmd) {
		case "일괄공개":
			List<String> oIds = Arrays.asList(openIds);
			
			// 공개할 id와 비공개할 id를 나눈다.
			List<String> cIds = new ArrayList(Arrays.asList(ids));
			cIds.removeAll(oIds); // 비공개할 id
			
			service.openAll(oIds, cIds);
			
			break;
			
		case "일괄삭제":
			int[] ids1 = new int[delIds.length];
			
			for (int i = 0; i < delIds.length; i++)
				ids1[i] = Integer.parseInt(delIds[i]);
			
			int result = service.deleteAll(ids1);
			break;
		}
		
		response.sendRedirect("list");
	}
	
}
