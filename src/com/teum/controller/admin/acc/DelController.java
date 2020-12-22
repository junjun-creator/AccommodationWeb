package com.teum.controller.admin.acc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.service.AccImageService;
import com.teum.service.AccService;
import com.teum.service.GoldenTimeService;
import com.teum.service.OfferService;
import com.teum.service.PickService;
import com.teum.service.ReservationService;
import com.teum.service.ReverseOfferService;
import com.teum.service.RoomImageService;
import com.teum.service.RoomService;

@WebServlet("/admin/accommodations/del")
public class DelController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		AccService service = new AccService();
		RoomImageService riService = new RoomImageService();
		RoomService roomService = new RoomService();
		ReverseOfferService roService = new ReverseOfferService();
		OfferService offerService = new OfferService();
		AccImageService aiService = new AccImageService();
		ReservationService reservationService = new ReservationService();
		PickService pService = new PickService();
		GoldenTimeService gService = new GoldenTimeService();
		
		//자식테이블 지우기 -> acc테이블지우기
		int riResult = riService.delete();
		int roomResult = roomService.delete();
		int roResult = roService.delete();
		int offerResult = offerService.delete();
		int aiResult = aiService.delete();
		int reservationResult = reservationService.delete();
		int pResult = pService.delete();
		int gResult = gService.delete();
		
		int result = service.delete(id);
		
		response.sendRedirect("list");
	}

	private PickService PickService() {
		// TODO Auto-generated method stub
		return null;
	}
}
