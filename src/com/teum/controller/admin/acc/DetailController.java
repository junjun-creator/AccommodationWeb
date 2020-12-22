package com.teum.controller.admin.acc;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teum.dao.entity.ReviewView;
import com.teum.dao.entity.RoomImageListView;
import com.teum.entity.Acc;
import com.teum.entity.AccImage;
import com.teum.entity.Room;
import com.teum.service.AccImageService;
import com.teum.service.AccService;
import com.teum.service.ReservationService;
import com.teum.service.RoomImageService;
import com.teum.service.RoomService;

@WebServlet("/admin/accommodations/detail")
public class DetailController extends HttpServlet{

	private AccService accService;
	private AccImageService accImageService;
	private RoomService roomService;
	private RoomImageService roomImageService;
	
	public DetailController() {
		accService = new AccService();
		roomService = new RoomService();
		accImageService = new AccImageService();
		roomImageService = new RoomImageService();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		String accId_ = request.getParameter("id");
		int accId = 0;

		if (accId_ != null && !accId_.equals(""))
			accId = Integer.parseInt(accId_);
		/* -- acc id에 일치하는 모든 acc 정보 갖고 오기 -- */
		Acc acc = accService.get(accId);
		
		/* -- acc id에 일치하는 accImage 정보들(fileName) 가져오기 -- */
		AccImage accImage = accImageService.get(accId);
//		System.out.println(accImage.getFileroute());
		
		
		/* -- acc id에 일치하는 모든 룸 정보 갖고오고 거기에 딸려오는 룸 사진도 갖고오기 -- */
		List<RoomImageListView> roomList = roomService.getViewList(accId); //회원이 검색한 날짜에 상관없이 모든 방을 넣은 리스트

		request.setAttribute("acc", acc);
		request.setAttribute("accImage", accImage);
		request.setAttribute("roomList", roomList);
		request.getRequestDispatcher("detail.jsp").forward(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		response.sendRedirect("/detail");
	}
}
