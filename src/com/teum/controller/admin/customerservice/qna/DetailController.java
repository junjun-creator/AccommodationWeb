package com.teum.controller.admin.customerservice.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.teum.entity.QnA;
import com.teum.service.QnAService;



@WebServlet("/admin/customerService/QnA/detail")
public class DetailController extends HttpServlet{
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
	
	QnAService service = new QnAService();
	QnA q = service.get(id);
	
	request.setAttribute("q", q);
	request.getRequestDispatcher("detail.jsp").forward(request,response);
}
}
