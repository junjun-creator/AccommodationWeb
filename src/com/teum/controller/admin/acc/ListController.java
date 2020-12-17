package com.teum.controller.admin.acc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.dao.entity.AccListForAdminView;
import com.teum.entity.Acc;
import com.teum.service.AccService;

@WebServlet("/admin/accommodations/list")
public class ListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ac_ = request.getParameter("ac");
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("search");
		
		String ac = "hotel";
		if(ac_ != null)
			ac = ac_;
		
		String field = "companyName";
		if(field_ != null)
			field = field_;
		
		String query = "";
		if(query_ != null && query_.equals(""))
			query = "%"+query_+"%";
		
		AccService service = new AccService();
		List<AccListForAdminView> list = service.getViewList(1,10,ac,field,query);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
}
