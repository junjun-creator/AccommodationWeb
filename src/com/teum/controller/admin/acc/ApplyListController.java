package com.teum.controller.admin.acc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
	//404 url이 없는경우(url오류)
	//405 받을 수 없는 메소드가 있을경우(메소드오류)
	//403 권한이 없을때(보안오류)
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date today = new Date();
		String[] appIds = request.getParameterValues("app-id");
		String[] delIds = request.getParameterValues("del-id");
		String cmd = request.getParameter("cmd");
		
		AccService service = new AccService();
		
		
		switch(cmd) {
		
		
		case "승인" :
			int[] ids_ = new int[appIds.length];
			for(int i =0; i<appIds.length; i++)
				ids_[i] = Integer.parseInt(appIds[i]);
			
			int result_ = service.approvalAll(ids_);
			break;
			
		case "삭제" :
			int[] ids = new int[delIds.length];
			for(int i =0; i<delIds.length; i++)
				ids[i] = Integer.parseInt(delIds[i]);
			
			int result = service.deleteAll(ids);
			break;
		}
		response.sendRedirect("applyList");

	}

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
		List<AccListForAdminView> list = service.getApplyViewList(ac,field,query,page,(page+9));
		int count = service.getApplyAccCount(ac,field,query);
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.getRequestDispatcher("applyList.jsp").forward(request, response);
	}
	
	
}
