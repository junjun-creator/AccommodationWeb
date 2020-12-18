package com.teum.controller.admin.acc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.Acc;
import com.teum.service.AccService;


@WebServlet("/admin/accommodations/applyDetail")
public class ApplyDetailController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		AccService service = new AccService();
		Acc al = service.applyGet(id);
		
		request.setAttribute("al", al);
		request.getRequestDispatcher("applyDetail.jsp").forward(request, response);
	}
}
