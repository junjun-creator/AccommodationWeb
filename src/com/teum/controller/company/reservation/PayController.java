package com.teum.controller.company.reservation;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teum.dao.entity.PayInfoView;
import com.teum.service.AccService;
import com.teum.service.OfferService;
import com.teum.service.ReverseOfferService;
import com.teum.service.RoomImageService;
import com.teum.service.RoomService;

@WebServlet("/user/reservation/pay")
public class PayController extends HttpServlet {
	
	private AccService accService;
	private OfferService offerService;
	private RoomService roomService;
	private RoomImageService roomImageService;
	private ReverseOfferService reverseOfferService;
	
	public PayController() {
		accService = new AccService();
		offerService = new OfferService();
		roomService = new RoomService();
		roomImageService = new RoomImageService();
		reverseOfferService = new ReverseOfferService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		
		if (session.getAttribute("email") == null) // 로그인이 안된 경우
			response.sendRedirect("/signin");
		else if (((int) session.getAttribute("type")) != 0) // 개인회원이 아닌경우
			response.sendRedirect("/index");
		else {
			String accId_ = request.getParameter("accId");
			String roomId_ = request.getParameter("roomId");
			String checkinDate = request.getParameter("checkinDate");
			String checkoutDate = request.getParameter("checkoutDate");
			
			int accId = 0;
			int roomId = 0;
			
			if (accId_ != null && !accId_.equals(""))
				accId = Integer.parseInt(accId_);
			
			if (roomId_ != null && !roomId_.equals(""))
				roomId = Integer.parseInt(roomId_);
		
			PayInfoView payInfo = roomService.getList(accId, roomId);
			
			request.setAttribute("payInfo", payInfo);
			request.setAttribute("checkinDate", checkinDate);
			request.setAttribute("checkoutDate", checkoutDate);
			
			
			request.getRequestDispatcher("pay.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 해당 룸에 예약 날짜를 업데이트 해야함
		String checkinDate_ = request.getParameter("checkinDate");
		String checkoutDate_ = request.getParameter("checkoutDate");
		String accId_ = request.getParameter("accId");
		String roomId_ = request.getParameter("roomId");
		
		int accId = 0;
		int roomId = 0;
		
		if (accId_ != null && !accId_.equals(""))
			accId = Integer.parseInt(accId_);
		
		if (roomId_ != null && !roomId_.equals(""))
			roomId = Integer.parseInt(roomId_);
		
		PayInfoView payInfo = roomService.getList(accId, roomId);
		String bookedDates = payInfo.getBookedDate();
		
		if (bookedDates == null)
			bookedDates = "";
		else
			bookedDates += ",";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date checkinDate = null;
		Date checkoutDate = null;
		
		if (checkinDate_ != null && !checkinDate_.equals("") && 
				checkoutDate_ != null && !checkoutDate_.equals("")) {
			
			try {
				checkinDate = sdf.parse(checkinDate_);
				checkoutDate = sdf.parse(checkoutDate_);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			StringBuilder checkDatesCSV = new StringBuilder();
			
			while (checkinDate.compareTo(checkoutDate) <= 0) {
				checkDatesCSV.append(sdf.format(checkinDate));
				checkDatesCSV.append(",");
				Calendar c = Calendar.getInstance();
				c.setTime(checkinDate);
				c.add(Calendar.DAY_OF_MONTH, 1);
				checkinDate = c.getTime();
			}
			checkDatesCSV.delete(checkDatesCSV.length() - 12, checkDatesCSV.length()); // 퇴실일 ~ 콤마까지 삭제
			
			bookedDates += checkDatesCSV;
			System.out.println("bookedDates : " + bookedDates);
			
			roomService.update(accId, roomId, bookedDates);
		}
		
		// 확인창 띄우기
		response.sendRedirect("/index");
	}
}
