package com.teum.controller.admin.accommodations;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.AccommodationList;
import com.teum.service.RegAccommodationListService;
@WebServlet("/admin/accommodations/regList")
public class RegAccListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegAccommodationListService service = new RegAccommodationListService();
		List<AccommodationList> list = service.getList();
		
		request.setAttribute("list", list);
		//request.getRequestDispatcher("regList.jsp").forward(request, response);
	}
}
