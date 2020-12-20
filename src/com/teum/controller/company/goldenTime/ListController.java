package com.teum.controller.company.goldenTime;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teum.dao.entity.GoldenTimeView;
import com.teum.entity.Acc;
import com.teum.service.GoldenTimeService;

@WebServlet("/company/goldenTime/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();	
			
		
		int id = (int)session.getAttribute("id");
		//int id =1;
		
		GoldenTimeService service = new GoldenTimeService();
		List<GoldenTimeView> list = service.getGoldenList(id); 
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoldenTimeService service = new GoldenTimeService();
		
		String cmd = request.getParameter("cmd");
		int chk = Integer.parseInt(request.getParameter("check"));
		String saleprice_=request.getParameter("price");
		
		
		//가격
		int saleprice=0;
		if(saleprice_!=null&&!saleprice_.equals("")) {
			saleprice =Integer.parseInt(saleprice_);
		}
		
		
		Acc acc = new Acc();
		
		switch (cmd) {
		case "진행":
			service.openStatus(chk);
			
			
			break;
		
		case "대기":
			service.closeStatus(chk);
			
			break;
		case "수정":
			DateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
			Date startDate = null;
			Date endDate = null;
			
			try {
				startDate = dateFormat.parse(request.getParameter("start"));
				endDate = dateFormat.parse(request.getParameter("end"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
			 acc.setId(chk);
			 acc.setGtStartDate(startDate);
			 acc.setGtEndDate(endDate);
			 acc.setSaleprice(saleprice);
			
			 service.update(acc);
			break;
		}
		
		response.sendRedirect("list");
	}
}
