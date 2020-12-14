package com.teum.controller.admin.acc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.Acc;
import com.teum.service.AccService;

@WebServlet("/admin/accommodations/list")
public class ListController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccService service = new AccService();
		List<Acc> list = new ArrayList<>();
		
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
}
