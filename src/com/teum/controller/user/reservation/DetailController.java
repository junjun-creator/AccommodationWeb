package com.teum.controller.user.reservation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teum.dao.entity.ReservationDetailView;
import com.teum.service.ReservationService;

@WebServlet("/user/reservation/detail")
public class DetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("email")==null) {
			response.sendRedirect("/signin");
		}
		else if(((int)session.getAttribute("type")) != 0 || (request.getParameter("reservationId") == null || request.getParameter("reservationId").equals(""))) {
			response.sendRedirect("/index");
		}
		else {
			ReservationService service = new ReservationService();
			int id = Integer.parseInt(request.getParameter("reservationId"));
			
			ReservationDetailView rd = service.getDetail(id);
			
			request.setAttribute("rd", rd);
			request.getRequestDispatcher("detail.jsp").forward(request, response);
			
		}
	}
}
