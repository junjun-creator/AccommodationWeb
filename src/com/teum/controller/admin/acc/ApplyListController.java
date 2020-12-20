package com.teum.controller.admin.acc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.dao.entity.AccListForAdminView;
import com.teum.service.AccService;

@WebServlet("/admin/accommodations/applyList")
public class ApplyListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=utf-8");
		
		String ac_ = request.getParameter("ac");
		String field_ = request.getParameter("f");
		String query_ =request.getParameter("q");
		String page_ = request.getParameter("p");
		
		String ac="hotel";
		if(ac_ != null)
			ac = ac_;
		
		String field="companyName";
		if(field_ != null)
			field = field_;

		String query = "";
		if(query_ != null&& !query_.equals(""))
			query = "%" +query_+"%";
		
		int page = 1;
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		
		AccService service = new AccService();
		List<AccListForAdminView> list = service.getApplyViewList(ac,field,query,1,10);
		int count = service.getApplyAccCount(ac,field,query);
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.getRequestDispatcher("applyList.jsp").forward(request, response);
	}
}
