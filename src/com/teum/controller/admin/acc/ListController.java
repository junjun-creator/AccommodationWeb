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
import com.teum.service.QnAService;

@WebServlet("/admin/accommodations/list")
public class ListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ac_ = request.getParameter("ac");
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("p");
		
		String ac = "hotel";
		if(ac_ != null && !ac_.equals(""))
			ac = ac_;
		
		String field = "company_name";
		if(field_ != null && !field_.equals(""))
			field = field_;
		
		String query = "";
		if(query_ != null && !query_.equals(""))
			query = "%"+query_+"%";
		
		int page = 1;
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);

		AccService service = new AccService();
		List<AccListForAdminView> list = service.getViewList(ac,field,query, page,(page+9));
		int count = service.getAccCount(ac,field,query);
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String[] delIds = request.getParameterValues("del-id");
	
	AccService service = new AccService();
	
	
		int[] ids = new int[delIds.length];
		
		for (int i = 0; i < delIds.length; i++) 
			ids[i] = Integer.parseInt(delIds[i]);

		
		int result = service.deleteAll(ids);

	
	response.sendRedirect("list");
	}
}
