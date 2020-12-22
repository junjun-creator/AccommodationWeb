package com.teum.controller.user.reservation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teum.entity.Reservation;
import com.teum.entity.Room;
import com.teum.service.ReservationService;
import com.teum.service.RoomService;

@WebServlet("/user/reservation/cancel")
public class CancelController extends HttpServlet {

	private ReservationService reservationService;
	private RoomService roomService;
	
	public CancelController() {
		reservationService = new ReservationService();
		roomService = new RoomService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("email")==null) {
			response.sendRedirect("/signin");
		}
		else if(((int)session.getAttribute("type")) != 0) {
			response.sendRedirect("/index");
		}
		else {
			int id = Integer.parseInt(request.getParameter("id"));
			
			// 1. reservation테이블의 cancel_status = 1로 변경
			reservationService.update(id); 
			
			// 2. acc id, room id를 통해 booked_date 수정
			Reservation reservation = reservationService.get(id);
			int roomId = reservation.getRoomId();
			
			// 체크인~체크아웃 - 1까지 CSV로 만들기
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			StringBuilder checkDatesCSV = new StringBuilder();
			Date checkinDate = reservation.getCheckinDate();
			Date checkoutDate = reservation.getCheckoutDate();
			
			while (checkinDate.compareTo(checkoutDate) <= 0) {
				checkDatesCSV.append(sdf.format(checkinDate));
				checkDatesCSV.append(",");
				Calendar c = Calendar.getInstance();
				c.setTime(checkinDate);
				c.add(Calendar.DAY_OF_MONTH, 1);
				checkinDate = c.getTime();
			}
			checkDatesCSV.delete(checkDatesCSV.length() - 12, checkDatesCSV.length()); // 퇴실일 ~ 콤마까지 삭제
			
			String[] cancelDates = checkDatesCSV.toString().split(",");
//			System.out.println("예약취소날짜: " + Arrays.toString(cancelDates));
			
			Room room = roomService.getRoom(roomId);
			String[] bookedDates = room.getBookedDate().split(",");
//			System.out.println("기존에 예약되어있는 모든 날짜: " + Arrays.toString(bookedDates));
			
			String[] newBookedDates = new String[bookedDates.length - cancelDates.length];
			
			for (int i = 0; i < bookedDates.length; i++) {
				if (Arrays.asList(cancelDates).contains(bookedDates[i]))
					continue;
				else
					newBookedDates[i] = bookedDates[i];
			}
			
			String newBookedDatesString = String.join(",", newBookedDates);
//			System.out.println("업데이트되고 남은 예약날짜: " + newBookedDatesString);
			
			roomService.update(roomId, newBookedDatesString);
			
			response.sendRedirect("/user/reservation/reservationInfo");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
