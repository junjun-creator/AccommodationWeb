package com.teum.controller.user.qna;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teum.entity.QnA;
import com.teum.service.QnAService;

@WebServlet("/user/QnA")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();	
		
				//int id = (int)session.getAttribute("id");
				int id =1;
				
				QnAService service = new QnAService();
				List<QnA> list = service.getList(id);
				
				  request.setAttribute("list",list);
				  request.getRequestDispatcher("QnA.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();	
		
		//int id = (int)session.getAttribute("id");
		int id =1;
		int category = Integer.parseInt( request.getParameter("category"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		QnAService service = new QnAService();
		
		QnA qna = new QnA();
		qna.setUserId(id);
		qna.setCategoryId(category);
		qna.setTitle(title);
		qna.setContent(content);
		
		service.insert(qna);
		
		response.sendRedirect("QnA");
	}
}
