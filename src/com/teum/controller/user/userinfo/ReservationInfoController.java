package com.teum.controller.user.userinfo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.teum.dao.entity.ReservationListView;
import com.teum.service.ReservationService;

@WebServlet("/user/userInfo/reservationInfo")
public class ReservationInfoController extends HttpServlet {

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
			int userId=(int)session.getAttribute("id");
			ReservationService service = new ReservationService();
			int page = 1;
			List<ReservationListView> rlv = service.getListByUser(page,userId);

			int reservationCount = service.getCount(userId);
			
			request.setAttribute("list", rlv);
			request.setAttribute("page",page);
			request.setAttribute("reservationCount", reservationCount);
			request.getRequestDispatcher("reservationInfo.jsp").forward(request,response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ReservationService service = new ReservationService();
		//제안 리스트 가져오기
		int userId = (int) session.getAttribute("id");
		
		int page = 1;
		String page_ = request.getParameter("page");
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		
		List<ReservationListView> rlv = service.getListByUser(page,userId);

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		JSONArray jArray = new JSONArray();
		for(ReservationListView r : rlv) {
			JSONObject obj = new JSONObject();
			obj.put("userId", r.getUserId());
			obj.put("accId", r.getAccId());
			obj.put("roomId", r.getRoomId());
			String checkinDate = transFormat.format(r.getCheckinDate());
			obj.put("checkinDate", checkinDate);
			String checkoutDate = transFormat.format(r.getCheckoutDate());
			obj.put("checkoutDate", checkoutDate);
			obj.put("price", r.getPrice());
			obj.put("accName", r.getAccName());
			obj.put("fileName", r.getFileName());
			obj.put("id", r.getId());
			obj.put("accId", r.getAccId());
			jArray.add(obj);
		}
		
		JSONObject obj = new JSONObject();
		int reservationCount = service.getCount(userId);
		obj.put("reservationCount", reservationCount);
		jArray.add(obj);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jArray);
	}
	
	
	
}
