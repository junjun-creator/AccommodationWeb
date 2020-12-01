package com.teum.controller.admin.customerservice.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.Notice;
import com.teum.service.NoticeService;

@WebServlet("/admin/customerService/notice/list")
public class NoticeListController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService service = new NoticeService();
		List<Notice> list =service.getList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
	}
}
