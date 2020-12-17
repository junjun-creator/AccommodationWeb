package com.teum.controller.admin.customerservice.qna;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.dao.entity.QnAView;
import com.teum.service.QnAService;
@WebServlet("/admin/customerService/QnA/list")
public class ListController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QnAService service = new QnAService();
		List<QnAView> list = new ArrayList<QnAView>();
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
		list = service.getVIewList(page,size,category, query);
		int count = service.getCount(category,query);
		
		
		request.setAttribute("list", list);
		request.setAttribute("pageCount", count);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
}
