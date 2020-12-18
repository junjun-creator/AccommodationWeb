package com.teum.controller.admin.promotion.goldenTime;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.dao.entity.GoldenTimeView;
import com.teum.service.GoldenTimeService;


@WebServlet("/admin/promotion/goldenTime/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		GoldenTimeService service = new GoldenTimeService(); 
		  List<GoldenTimeView> list = service.getGoldenList();
		 
		  String category_ = request.getParameter("category");
			String query_ = request.getParameter("query");
			String page_ = request.getParameter("page");
			
			String category = "";
			String query = "";
			
			int page = 1;
			
			if(category_ != null && !category_.equals("")) {
				category = category_;
			}
			
			if(query_ != null && !query_.equals("")) {
				query = query_;
			}
			if(page_ != null && !page_.equals("")) {
				page = Integer.parseInt(page_);
			}
			int size = 3;
			list = service.getVIewList(page,size,category,query);
			int count = service.getCount(category,query);
		
		request.setAttribute("categoryType", category);
		request.setAttribute("list", list);
		request.setAttribute("pageCount", count);
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
	}
	
	
}
