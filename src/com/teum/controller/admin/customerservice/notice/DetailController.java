package com.teum.controller.admin.customerservice.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.Notice;
import com.teum.service.NoticeService;



@WebServlet("/admin/customerService/notice/detail")
public class DetailController extends HttpServlet{
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
	
	NoticeService service = new NoticeService();
	Notice n = service.get(id);
	
	request.setAttribute("n", n);
	request.getRequestDispatcher("detail.jsp").forward(request,response);
}
}
