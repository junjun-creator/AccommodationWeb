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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.teum.dao.entity.OfferInfoView;
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
			response.sendRedirect("/signin?return-url=/user/userInfo/offerList");
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
//			ReverseOfferService reverseService = new ReverseOfferService();
//			List<Integer> roomIds = reverseService.getRoomIds(offerList.get(0).getId());
			
			int page = 1;
			String page_ = request.getParameter("page");
			int offerId=0;
			if(!offerList.isEmpty())
				offerId = offerList.get(0).getId();
			String offerId_ = request.getParameter("offerId");
			
			if(page_ != null && !page_.equals(""))
				page = Integer.parseInt(page_);
			
			if(offerId_ != null && !offerId_.equals(""))
				offerId = Integer.parseInt(offerId_);
			
			RoomService roomService = new RoomService();
			List<OfferInfoView> oiv = roomService.getOfferInfoList(page, offerId);
			int offerCount = roomService.getOfferCount(offerId);
			
			
			
			request.setAttribute("oiv", oiv);
			request.setAttribute("offerList", offerList);
			request.setAttribute("page", page);
			request.setAttribute("oi", offerId);
			request.setAttribute("offerCount", offerCount);
			
			request.getRequestDispatcher("offerList.jsp").forward(request, response);
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//제안 리스트 가져오기
		int userId = (int) session.getAttribute("id");
		int type = (int) session.getAttribute("type");
		OfferService service = new OfferService();
		List<Offer> offerList = service.getList(userId,type);
		
		//오퍼 온 방리스트 가져오기
//		ReverseOfferService reverseService = new ReverseOfferService();
//		List<Integer> roomIds = reverseService.getRoomIds(offerList.get(0).getId());
		
		int page = 1;
		String page_ = request.getParameter("page");
		int offerId=0;
		if(!offerList.isEmpty())
			offerId = offerList.get(0).getId();
		String offerId_ = request.getParameter("offerId");
		
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		
		if(offerId_ != null && !offerId_.equals(""))
			offerId = Integer.parseInt(offerId_);
		
		RoomService roomService = new RoomService();
		List<OfferInfoView> oiv = roomService.getOfferInfoList(page, offerId);
		
		JSONArray jArray = new JSONArray();
		int count = 0;
		for(OfferInfoView o : oiv) {
			JSONObject obj = new JSONObject();
			obj.put("roomId", o.getRoomId());
			obj.put("accId", o.getAccId());
			obj.put("roomName", o.getRoomName());
			obj.put("maxHeadcount", o.getMaxHeadcount());
			obj.put("bedCount", o.getBedCount());
			obj.put("fileName", o.getFileName());
			obj.put("fileRoute", o.getFileRoute());
			obj.put("price", o.getPrice());
			obj.put("accName", o.getAccName());
			
			jArray.add(obj);
		}
		JSONObject obj = new JSONObject();
		int offerCount = roomService.getOfferCount(offerId);
		obj.put("offerCount", offerCount);
		jArray.add(obj);

		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jArray);
	}
	
	
}
