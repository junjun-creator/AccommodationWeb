package com.teum.controller.company.goldenTime;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.teum.entity.Room;
import com.teum.service.AccService;
import com.teum.service.GoldenTimeService;
import com.teum.service.RoomService;

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
		HttpSession session = request.getSession();	
			
		
		int id = (int)session.getAttribute("id");
		
		AccService accservie = new AccService();
		GoldenTimeService service = new GoldenTimeService();
		
		String cmd = request.getParameter("cmd");
		int chk = Integer.parseInt(request.getParameter("check"));
		String saleprice_=request.getParameter("price");
		String switching=request.getParameter("switching");
		String addprice_=request.getParameter("saleprice");
		
		
		
		//가격
				int saleprice=0;
				if(saleprice_!=null&&!saleprice_.equals("")) {
					saleprice =Integer.parseInt(saleprice_);
				}
				int addprice=0;
				if(addprice_!=null&&!addprice_.equals("")) {
					addprice =Integer.parseInt(addprice_);
				}
		
		
		Acc acc = new Acc();
		
		switch (cmd) {
		case "진행":
			if(!switching.equals("0")) {
				/*가격 할인 코드*/
				RoomService rservice = new RoomService();
				List<Room> list = rservice.getPriceList(chk); 
				
				int roomPrice =0;
				
				for(int i=0;i<list.size();i++) {
					roomPrice=list.get(i).getPrice()-addprice;
					
					if(roomPrice<0) {
						roomPrice=0;
					}
					
					list.get(i).setPrice(roomPrice);
					 rservice.updatePrice(list.get(i));
				}
				/*남은 날짜 구하는 코드*/
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
				
				service.openStatus(chk);
			}
		
			break;
		
		case "대기":
			
			List<Acc> acc_ = accservie.getList(id);
			if(acc_.get(0).getGoldentimeStatus()==1) {
			
				RoomService rservice = new RoomService();
				List<Room> list = rservice.getPriceList(chk); 
				
				int roomPrice =0;
				
				for(int i=0;i<list.size();i++) {
					roomPrice=list.get(i).getPrice()+addprice;
					
					list.get(i).setPrice(roomPrice);
					 rservice.updatePrice(list.get(i));
				}
				service.closeStatus(chk);
			}
			break;
		
		}
		
		response.sendRedirect("list");
	}
}
