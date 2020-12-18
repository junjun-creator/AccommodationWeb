package com.teum.controller.user.userinfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teum.entity.Offer;
import com.teum.service.OfferService;
import com.teum.service.ReverseOfferService;
import com.teum.service.RoomService;

@WebServlet("/user/userInfo/offerList")
public class OfferListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("email")==null) {
			response.sendRedirect("/signin");
		}
		else if(((int)session.getAttribute("type")) != 0) {
			response.sendRedirect("/index");
		}
		else {
			//제안 리스트 가져오기
			int userId = (int) session.getAttribute("id");
			int type = (int) session.getAttribute("type");
			OfferService service = new OfferService();
			List<Offer> offerList = service.getList(userId,type);
			
			//오퍼 온 방리스트 가져오기
			ReverseOfferService reverseService = new ReverseOfferService();
			List<Integer> roomIds = reverseService.getRoomIds(offerList.get(0).getId());
			
			RoomService roomService = new RoomService();
			
			List<OfferdRoomView> orv = roomService.getOfferedRoomList()
			
			
			request.setAttribute("offerList", offerList);
			request.getRequestDispatcher("offerList.jsp").forward(request, response);
		}
	}
	
}
