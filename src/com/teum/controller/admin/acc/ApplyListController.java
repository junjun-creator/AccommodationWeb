package com.teum.controller.admin.acc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.AccommodationList;
import com.teum.service.AccService;

@WebServlet("/admin/accommodations/applyList")
public class ApplyListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccService service = new AccService();
		List<AccommodationList> list = service.applyGetList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("applyList.jsp").forward(request, response);
	}
}
