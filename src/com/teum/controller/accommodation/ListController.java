package com.teum.controller.accommodation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teum.dao.entity.AccImageListView;
import com.teum.dao.entity.PickListView;
import com.teum.service.AccImageService;
import com.teum.service.AccService;
import com.teum.service.PickService;
import com.teum.service.RoomService;

@WebServlet("/accommodation/list")
public class ListController extends HttpServlet {

   private AccService accService;
   private AccImageService accImageService;
   
   public ListController() {
      accService = new AccService();
      accImageService = new AccImageService();
   }
   
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=utf-8");
      HttpSession session = request.getSession();
      
      String type_ = request.getParameter("type");
      String bigCity_ = request.getParameter("bigCity");
      String smallCity_ = request.getParameter("smallCity");
      String search_ = request.getParameter("search");
      
      int type = 1;
      String bigCity = "";
      String smallCity = "";
      String location = "";
      String search = "";
      
      if (type_ != null && !type_.equals(""))
         type = Integer.parseInt(type_);
      
      if (bigCity_ != null && !bigCity_.equals(""))
         bigCity = bigCity_;
      
      if (smallCity_ != null && !smallCity_.equals(""))
         smallCity = smallCity_;
      
      if (search_ != null && !search_.equals(""))
    	  search = search_;
      
      System.out.println("bigcity: " + bigCity);
      System.out.println("smallCity: " + smallCity);
      
      if (bigCity.equals("") && smallCity.equals(""))
    	  location = "";
      else
    	  location = bigCity + " " + smallCity;
      
      List<AccImageListView> accList = accService.getList(type, location, search);
      
      //평점
      List<Integer> accIds = new ArrayList<>();
      for(AccImageListView alv : accList) {
    	  accIds.add(alv.getId());
      }
      PickService pickService = new PickService();
      List<Double> pointList = pickService.getPointList(accIds);
      
      //가격
      RoomService roomService = new RoomService();
      List<Integer> priceList = new ArrayList();
      for(AccImageListView alv : accList) {
    	  int price = roomService.getPrice(alv.getId());
    	  priceList.add(price);
      }
      
      request.setAttribute("accList", accList);
      request.setAttribute("type", type);
      request.setAttribute("pointList", pointList);
      request.setAttribute("priceList", priceList);
      request.getRequestDispatcher("list.jsp").forward(request, response);
   }
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.sendRedirect("/index");
   }
   
}