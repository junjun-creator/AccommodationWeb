package com.teum.controller.admin.userinfo.users;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.dao.entity.Member;
import com.teum.dao.entity.PrivateQnaView;
import com.teum.dao.entity.PrivateReservationListView;
import com.teum.entity.Company;
import com.teum.entity.Users;
import com.teum.service.CompanyService;
import com.teum.service.QnAService;
import com.teum.service.ReservationService;
import com.teum.service.UsersService;

@WebServlet("/admin/userInfo/users/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		if(id == null || id.equals(""))
			response.sendRedirect("/admin/index");
		int userId = Integer.parseInt(id);
		
		int page1 = 1;
		String page1_ = request.getParameter("page1");
		if(request.getParameter("page1") != null && !request.getParameter("page1").equals(""))
			page1 = Integer.parseInt(page1_);
		
		int page2 = 1;
		String page2_ = request.getParameter("page2");
		if(request.getParameter("page2") != null && !request.getParameter("page2").equals(""))
			page2 = Integer.parseInt(page2_);
		
		UsersService service = new UsersService();
		Users u = service.get(Integer.parseInt(id));
		request.setAttribute("member", u);
		
		ReservationService reservationService = new ReservationService();
		List<PrivateReservationListView> reservationList = reservationService.getPrivateList(userId,page1);
		int count1 = reservationService.getPrivateCount(userId);
		double pageLastCount1 = Math.ceil(count1/5.0);
		
		request.setAttribute("reservationList", reservationList);
		request.setAttribute("page1", page1);
		request.setAttribute("pageLastCount1",(int)pageLastCount1);
		
		QnAService qnaService = new QnAService();
		List<PrivateQnaView> qnaList = qnaService.getPrivateList(userId,page2);
		int count2 = qnaService.getPrivateCount(userId);
		double pageLastCount2 = Math.ceil(count2/5.0);
		
		System.out.println(page2);
		System.out.println(qnaList);
		
		request.setAttribute("qnaList", qnaList);
		request.setAttribute("page2", page2);
		request.setAttribute("pageLastCount2",(int)pageLastCount2);
		request.setAttribute("id",userId);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/userInfo/users/privateMemberDetail.jsp");
		rd.forward(request, response);
	}
	
}
