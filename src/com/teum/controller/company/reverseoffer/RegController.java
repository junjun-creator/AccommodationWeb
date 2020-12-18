package com.teum.controller.company.reverseoffer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teum.entity.Acc;
import com.teum.entity.Offer;
import com.teum.entity.Room;
import com.teum.service.AccService;
import com.teum.service.OfferService;
import com.teum.service.ReverseOfferService;
import com.teum.service.RoomService;

@WebServlet("/company/reverseOffer/reg")
public class RegController extends HttpServlet {

	private AccService accService;
	private OfferService offerService;
	private RoomService roomService;
	private ReverseOfferService reverseOfferService;
	
	public RegController() {
		accService = new AccService();
		offerService = new OfferService();
		reverseOfferService = new ReverseOfferService();
		roomService = new RoomService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		
		if(session.getAttribute("email") == null) 		  // 로그인이 안된 경우
			response.sendRedirect("/signin");
		else if(((int)session.getAttribute("type")) != 1) // 기업이 아닌 경우
			response.sendRedirect("/index");
		else {
			int companyId = (int) session.getAttribute("id");
		
			/* ------------- 제안 리스트 불러오기 --------------- */
			List<Acc> accList = accService.getList(companyId);
			StringBuilder accIdsCSV = new StringBuilder();
			
			for (Acc acc : accList) {
				accIdsCSV.append(toString().valueOf(acc.getId()));
				accIdsCSV.append(",");
			}
			accIdsCSV.delete(accIdsCSV.length() - 1, accIdsCSV.length()); // 마지막 콤마 삭제
			
			List<Offer> offerList = offerService.getList(accIdsCSV.toString());
			System.out.printf("회원에게 역제안할 수 있는 방의 id들: %s\n\n", offerList.toString());
			
			/* ------------- 방 리스트 불러오기 --------------- */
			List<Room> roomList = roomService.getList(accIdsCSV.toString());
			System.out.printf("accId에 일치하는 모든 방의 id들: %s", roomList.toString());
			
			/* ------------- 데이터 넘기기 --------------- */
			request.getRequestDispatcher("reg.jsp").forward(request, response);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//reverseOfferService.getOfferList();
	}
}
