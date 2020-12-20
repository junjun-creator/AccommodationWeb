package com.teum.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teum.dao.entity.EventListView;
import com.teum.dao.entity.GoldenTimeView;
import com.teum.service.EventService;
import com.teum.service.GoldenTimeService;



@WebServlet("/index")
public class IndexController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		
		System.out.println(email);
		
		EventService eventService = new EventService();
		List<EventListView> eventList = new ArrayList<>();
		
		eventList = eventService.getViewList();
		int count = eventService.getCount();
		
		GoldenTimeService service = new GoldenTimeService(); 
		int open = 1;
		  List<GoldenTimeView> goldenList = service.getGoldenOpenList(open);
		
		  //------------------시간
		 
		  long h_;
		  long min;
		  long day;
		 
		  for(int i =0;i<goldenList.size();i++) {
			  Date startday= goldenList.get(i).getGtEndDate();
			  long startTime=startday.getTime(); 
			  //현재의 시간 설정 
			  Calendar cal=Calendar.getInstance(); 
			  Date endDate=cal.getTime();
			  long endTime=endDate.getTime(); 
			  long mills=startTime-endTime; 
			  //분으로 변환
			  long sec=mills/1000; 
			  
			  min = sec/60;
			  h_ = min/60;
			  day=h_/24;
			  min= min%60;
			  h_=h_%24;
			  String m = String.valueOf(min%60);
			  String h= String.valueOf(h_%24);
			  String d = String.valueOf(day);
			  String date_ = d+"일"+h+"시간"+m+"분";
		
			  goldenList.get(i).setTimeRemain(date_);
			
		  }
		 
		 
		request.setAttribute("email", email);
		request.setAttribute("eventList", eventList);
		request.setAttribute("count", count);
		request.setAttribute("goldenList", goldenList);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
}
