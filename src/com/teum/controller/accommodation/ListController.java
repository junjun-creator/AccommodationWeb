package com.teum.controller.accommodation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teum.entity.Acc;
import com.teum.service.AccService;

@WebServlet("/accommodation/list")
public class ListController extends HttpServlet {

   private AccService accService;
   
   public ListController() {
      accService = new AccService();
   }
   
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=utf-8");
      HttpSession session = request.getSession();
      
      // 위치, 타입
      String type_ = request.getParameter("type");
      String bigCity_ = request.getParameter("bigCity");
      String smallCity_ = request.getParameter("smallCity");
      
      int type = 1;
      String bigCity = "";
      String smallCity = "";
      String location = "";
      
      if (type_ != null && !type_.equals(""))
         type = Integer.parseInt(type_);
      
      if (bigCity_ != null && !bigCity_.equals(""))
         bigCity = bigCity_;
      
      if (smallCity_ != null && !smallCity_.equals(""))
         smallCity = smallCity_;
      
      location = bigCity + " " + smallCity;
      
      List<Acc> accList = accService.getList(type, location);
      
      request.setAttribute("accList", accList);
      request.setAttribute("type", type);
      request.getRequestDispatcher("list.jsp").forward(request, response);
   }
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.sendRedirect("/index");
   }
   
}