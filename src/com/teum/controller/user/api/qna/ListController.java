package com.teum.controller.user.api.qna;

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

@WebServlet("/api/user/QnA")
public class ListController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json; charset=UTF-8");
		//HttpSession session = request.getSession();	
			
		//int id = (int)session.getAttribute("id");
		int id =1;
		
		QnAService service = new QnAService();
		List<QnA> list = service.getList(id);
		
		String json = "[";
		
		for(int i=0;i<list.size();i++) {
			QnA q = list.get(i);
			
			json += String.format("{\"id\" : \"%s\",\"userId\": \"%s\", \"title\" : \"%s\",\"content\" : \"%s\",\"answerContent\" : \"%s\",\"answerRegdate\" : \"%s\"}",q.getId(),q.getUserId(),q.getTitle(), q.getContent(),q.getAnswerContent(), q.getAnswerRegdate());
			
		    
			if(list.size()>i+1)
				json+= ",";
			
		}
		json += "]";
		/*
		 * request.setAttribute("list",list);
		 * request.getRequestDispatcher("list.jsp").forward(request, response);
		 */
		response.getWriter().println(json);
	}
	
}
