package com.teum.controller.admin.promotion.event;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.Event;
import com.teum.service.EventService;

@WebServlet("/admin/promotion/event/reg")
public class RegController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		request.getRequestDispatcher("reg.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자로부터 전달받은 데이터를 변수에 담기
		String title = request.getParameter("title");
		String openStatus_ = request.getParameter("open");
		int openStatus = 0;
		
		if (openStatus_ != null && !openStatus_.equals("")) 
			openStatus = Integer.parseInt(openStatus_);
		
		// String -> Date 변환
		DateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = dateFormat.parse(request.getParameter("start-date"));
			endDate = dateFormat.parse(request.getParameter("end-date"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Event event = new Event(title, openStatus, startDate, endDate);
		
		// 2. 데이터베이스에 넣기
		EventService service = new EventService();
		service.insert(event);
		
		// 3. 페이지 전환
		response.sendRedirect("list");
	}
	
}
