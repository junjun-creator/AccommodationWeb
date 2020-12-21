package com.teum.controller.admin.userinfo.company;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.Acc;
import com.teum.entity.Company;
import com.teum.entity.Users;
import com.teum.service.AccService;
import com.teum.service.CompanyService;
import com.teum.service.UsersService;

@WebServlet("/admin/userInfo/company/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		
		CompanyService service = new CompanyService();
		Company c = service.get(Integer.parseInt(id));
		request.setAttribute("member", c);
		
//		MemberService service = new MemberService();
//		Member m = service.getDetail(email);
//		System.out.println(m.getName());
		
//		request.setAttribute("member", m);
		
		int page1 = 1;
		String page1_ = request.getParameter("page1");
		if(request.getParameter("page1") != null && !request.getParameter("page1").equals(""))
			page1 = Integer.parseInt(page1_);
		
		int page2 = 1;
		String page2_ = request.getParameter("page2");
		if(request.getParameter("page2") != null && !request.getParameter("page2").equals(""))
			page2 = Integer.parseInt(page2_);
		
		AccService accService = new AccService();
		List<Acc> regAcc = accService.getRegList(Integer.parseInt(id),0,page1);
		List<Acc> unRegAcc = accService.getRegList(Integer.parseInt(id),1,page2);
		int count1 = accService.getRegCount(Integer.parseInt(id),0);
		int count2 = accService.getRegCount(Integer.parseInt(id),1);
		double pageLastCount1 = Math.ceil(count1/5.0);
		double pageLastCount2 = Math.ceil(count2/5.0);
		
		request.setAttribute("regAcc", regAcc);
		request.setAttribute("unRegAcc", unRegAcc);
		request.setAttribute("page1", page1);
		request.setAttribute("page2", page2);
		request.setAttribute("pageLastCount1",(int)pageLastCount1);
		request.setAttribute("pageLastCount2",(int)pageLastCount2);
		request.setAttribute("id",Integer.parseInt(id));
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/userInfo/company/corporateMemberDetail.jsp");
		rd.forward(request, response);
	}
	
}
