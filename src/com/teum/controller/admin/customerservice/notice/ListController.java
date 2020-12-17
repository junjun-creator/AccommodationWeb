package com.teum.controller.admin.customerservice.notice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.dao.entity.NoticeView;
import com.teum.service.NoticeService;

@WebServlet("/admin/customerService/notice/list")
public class ListController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService service = new NoticeService();
		List<NoticeView> list =new ArrayList<>();
		//int count = service.getCount();
		/*
		 * String queryString = request.getQueryString(); if(queryString ==null) { list
		 * = service.getList(); }else if(queryString.contains("query")) { count =
		 * service.getCount(request.getParameter("query"));
		 * if(queryString.contains("page")) { int page =
		 * Integer.parseInt(request.getParameter("page")); list =
		 * service.getList(page,request.getParameter("query")); } else { list =
		 * service.getList(1,request.getParameter("query")); } } else { int page =
		 * Integer.parseInt(request.getParameter("page")); list = service.getList(page);
		 * request.setAttribute("page", page); }
		 */

		String query_ = request.getParameter("query");
		String page_ = request.getParameter("page");
		
		
		String query = "";
		int page = 1;
		
		if(query_ != null && !query_.equals("")) {
			query = query_;
		}
		if(page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		
		list = service.getViewList(page, query);
		int count = service.getCount(query);
		
		request.setAttribute("list", list);
		request.setAttribute("pageCount", count);
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
	}
}
