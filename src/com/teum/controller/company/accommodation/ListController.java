package com.teum.controller.company.accommodation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teum.dao.entity.AccommodationListView;
import com.teum.service.AccService;

@WebServlet("/company/accommodation/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("email")==null) {
			response.sendRedirect("/signin");
		}
		else if(((int)session.getAttribute("type")) != 1) {
			response.sendRedirect("/index");
		}
		else {
			int companyId = (int)session.getAttribute("id");
			
			int accType = 0;
			String accType_ = request.getParameter("accType");
			if(request.getParameter("accType") != null && !request.getParameter("accType").equals(""))
				accType = Integer.parseInt(accType_);
			
			AccService service = new AccService();
			List<AccommodationListView> list = service.getAccListByCompany(companyId, accType);
			
			request.setAttribute("list", list);
			request.setAttribute("accType", accType);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}
	}
	
}
