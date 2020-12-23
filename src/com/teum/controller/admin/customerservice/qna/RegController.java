package com.teum.controller.admin.customerservice.qna;

import java.io.Console;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.QnA;
import com.teum.service.QnAService;

@WebServlet("/admin/customerService/qna/reg")
public class RegController extends HttpServlet {

	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		QnAService service = new QnAService();
		QnA q = service.get(id); 
		
		request.setAttribute("q", q);
		request.getRequestDispatcher("reg.jsp").forward(request,response);
		
		}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String answerContent = request.getParameter("ANSWER_CONTENT");
		answerContent = answerContent.replace("\r\n", "<br >");
		int adminId = Integer.parseInt(request.getParameter("ADMIN_ID"));
		int answerStatus = Integer.parseInt(request.getParameter("ANSWER_STATUS"));
		
		
		QnA qna = new QnA(title,answerContent,adminId,answerStatus);
		qna.setId(Integer.parseInt(id));
		
		QnAService service = new QnAService();
		service.update(qna);
		
		response.sendRedirect("list");
	}

}