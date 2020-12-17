package com.teum.controller.admin.customerservice.notice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.dao.entity.NoticeView;
import com.teum.service.NoticeService;

@WebServlet("/admin/customerService/notice/list")
public class ListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService service = new NoticeService();
		List<NoticeView> list =new ArrayList<>();
		String query_ = request.getParameter("query");
		String page_ = request.getParameter("page");
		
		
		String query = "";
		int page = 1;
		
		if(query_ != null && !query_.equals("")) {
			query = query_;
		}
		if(page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		
		list = service.getViewList(page, query);
		int count = service.getCount(query);
		
		request.setAttribute("list", list);
		request.setAttribute("pageCount", count);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] openIds = request.getParameterValues("open-id");
		String[] delIds = request.getParameterValues("del-id");
		String cmd = request.getParameter("cmd");
		String ids_ = request.getParameter("ids");
		String[] ids = ids_.trim().split(" ");
		
		NoticeService service = new NoticeService();
		List<String> oIds = Arrays.asList(openIds);
		// 공개할 id와 비공개할 id를 나눈다.
		List<String> cIds = new ArrayList(Arrays.asList(ids));
		cIds.removeAll(oIds); // 비공개할 id
		switch (cmd) {
		case "공개":
			
			service.openAll(oIds, cIds);
			
			break;
			
		case "비공개":
			
			service.closeAll(oIds, cIds);
			
			break;
		case "삭제":
			int[] ids1 = new int[delIds.length];
			
			for (int i = 0; i < delIds.length; i++)
				ids1[i] = Integer.parseInt(delIds[i]);
			
			int result = service.deleteAll(ids1);
			break;
		}
		
		response.sendRedirect("list");
	}
	
}
