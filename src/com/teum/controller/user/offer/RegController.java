package com.teum.controller.user.offer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teum.entity.Acc;
import com.teum.entity.Offer;
import com.teum.service.AccService;
import com.teum.service.OfferService;

@WebServlet("/user/offer/reg")
public class RegController extends HttpServlet {
	
	private OfferService offerService;
	private AccService accService;
	
	public RegController() {
		offerService = new OfferService();
		accService = new AccService();
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
			request.getRequestDispatcher("reg.jsp").forward(request, response);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String mainCity = request.getParameter("main-city");
		String subCity = request.getParameter("sub-city");
		String accType = request.getParameter("acc-type");
		String headcount_ = request.getParameter("headcount");
		String price_ = request.getParameter("price");
		String location = mainCity + " " + subCity;
		int userId = (int) session.getAttribute("id");

		int headcount = 0;
		int price = 0;
		
		if (headcount_ != null && !headcount_.equals(""))
			headcount = Integer.parseInt(headcount_);
		
		System.out.printf("headcount: %d", headcount);
		
		if (price_ != null && !price_.equals(""))
			price = Integer.parseInt(price_);
		
		int accTypeNum = 0;
		
		switch (accType) {
		case "호텔":
			accTypeNum = 1;
			break;
			
		case "모텔":
			accTypeNum = 2;
			break;
		
		case "게스트하우스":
			accTypeNum = 3;
			break;
			
		case "리조트":
			accTypeNum = 4;
			break;
			
		case "펜션":
			accTypeNum = 5;
			break;
		}
		
		List<Acc> accList = new ArrayList<>();
		accList = accService.getList(location);
		
		// String -> Date 변환
		DateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date checkinDate = null;
		Date checkoutDate = null;
		
		try {
			checkinDate = dateFormat.parse(request.getParameter("checkin-date"));
			checkoutDate = dateFormat.parse(request.getParameter("checkout-date"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		for (Acc acc : accList) {
			Offer offer = new Offer(acc.getId(), userId, price, location, checkinDate, checkoutDate, headcount);
			
			if (acc.getAccTypeId() == accTypeNum)
				offerService.insert(offer);
		}
		
		response.sendRedirect("/index");
	}
}
