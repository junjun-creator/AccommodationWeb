package com.teum.controller.company.goldenTime;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teum.dao.entity.GoldenTimeView;
import com.teum.service.AccService;

@WebServlet("/company/goldenTime/list")
public class ListController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession session = request.getSession();	
		
	
	AccService service = new AccService();
	List<GoldenTimeView> list = service.getGoldenList(); 
	
	request.setAttribute("list", list);
	request.getRequestDispatcher("list.jsp").forward(request, response);
	}
}
