package com.teum.controller.admin.customerservice.notice;

import java.io.Console;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.Notice;
import com.teum.service.NoticeService;

@WebServlet("/admin/customerService/notice/reg")
public class RegController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getMethod().equals("GET")) {
			request.getRequestDispatcher("reg.jsp").forward(request, response);
		} else if (request.getMethod().equals("POST")) {

			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int adminId = Integer.parseInt(request.getParameter("ADMIN_ID"));
			String open =request.getParameter("OPEN_STATUS");
			
			if(open!=null) {
				open ="1";
			}else {
				open="0";
				
			}
			
			int openStatus = Integer.parseInt(open);
			 
			Notice notice = new Notice(title, content, adminId, openStatus);

			NoticeService service = new NoticeService();
			service.insert(notice);

			response.sendRedirect("list");
		}
	}
}
