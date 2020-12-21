package com.teum.controller.user.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teum.dao.entity.ReviewView;
import com.teum.entity.Reservation;
import com.teum.service.ReservationService;
@WebServlet("/user/review/reg")
public class RegController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	

		int userId = (int)session.getAttribute("id");
		int id = Integer.parseInt(request.getParameter("id"));
		
		/*
		 * int userId =1; int id =24;
		 */
		ReservationService service = new ReservationService();
		ReviewView reser= service.get(userId,id);
		
		String userName = reser.getUserName();
		String accName = reser.getAccName();
		
		request.setAttribute("id", id);
		request.setAttribute("accName",accName);
		request.setAttribute("userName",userName);
		request.getRequestDispatcher("reg.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		
		int userId = (int)session.getAttribute("id");
		//int userId =1;
		int id = Integer.parseInt(request.getParameter("itemId"));
		String comment = request.getParameter("comment");
		int score =Integer.parseInt(request.getParameter("score"));
		
		score+=1;
		
		ReservationService service = new ReservationService();
		Reservation rese= new Reservation();
		rese.setId(id);
		rese.setUserId(userId);
		rese.setReviewContent(comment);
		rese.setReviewScore(score);
		
		
		service.update(rese);
	
		
		response.sendRedirect("/user/reservation/reservationInfo");
	}
	
}
