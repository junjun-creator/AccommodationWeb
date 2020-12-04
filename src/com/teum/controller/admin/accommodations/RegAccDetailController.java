package com.teum.controller.admin.accommodations;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.AccommodationList;
import com.teum.service.AccommodationListService;


@WebServlet("admin/accommodations/regAccommodationDetail")
public class RegAccDetailController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String accName = request.getParameter("accName");
		
		AccommodationListService service = new AccommodationListService();
		AccommodationList al = service.get(accName);
		
		request.setAttribute("al", al);
		request.getRequestDispatcher("regAccommodationDetail.jsp").forward(request, response);
	}
}
