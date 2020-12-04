package com.teum.controller.admin.customerservice.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.teum.service.QnAService;



@WebServlet("/admin/customerService/QnA/del")
public class QnADelController extends HttpServlet{
	
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		QnAService service = new QnAService();
		int result = service.delete(id);
		
		response.sendRedirect("list");
		
		}
	

}
