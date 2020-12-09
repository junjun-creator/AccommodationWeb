package com.teum.controller.admin.acc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.AccommodationList;
import com.teum.service.AccService;


@WebServlet("/admin/accommodations/applyDetail")
public class ApplyDetailController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String accName = request.getParameter("accName");
		
		AccService service = new AccService();
		AccommodationList al = service.applyGet(accName);
		
		request.setAttribute("al", al);
		request.getRequestDispatcher("applyDetail.jsp").forward(request, response);
	}
}
