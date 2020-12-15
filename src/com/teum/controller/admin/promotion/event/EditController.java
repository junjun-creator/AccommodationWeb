package com.teum.controller.admin.promotion.event;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.teum.entity.Event;
import com.teum.service.EventService;

@WebServlet("/admin/promotion/event/edit")
@MultipartConfig( 
	    fileSizeThreshold = 1024*1024, 
	    maxFileSize = 1024*1024*5, 
	    maxRequestSize = 1024*1024*5*5)

public class EditController extends HttpServlet {

	private EventService service;
	
	public EditController() {
		service = new EventService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		EventService service = new EventService();
		Event event = service.get(id);
		
		request.setAttribute("event", event);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String openStatus_ = request.getParameter("open");
		
		Collection<Part> fileParts = request.getParts();
		String fileName = null;
		String filePath = null;
		
		int openStatus = 0;
		if (openStatus_ != null && !openStatus_.equals(""))
			openStatus = Integer.parseInt(openStatus_);
		
		// 파일 다중 업로드
		for (Part p : fileParts) {
			if (p.getName().equals("file") && p.getSize() > 0) {
				fileName = p.getSubmittedFileName(); // 첨부한 파일명
				
				// 서블릿들이 필요로하는 공동자원들
				// getRealPath는 상대경로를 넘겨주면 물리경로를 알려준다
				String pathTemp = request.getServletContext().getRealPath("/images/event/2020/" + id); 
				
				// file저장경로: /images/event/2020/26/
				// 배포된 디렉토리에 저장되기 때문에 이클립스에서는 확인이 불가능
				File path = new File(pathTemp); // 얘는 절대경로만 받는다.
				if (!path.exists())
					path.mkdirs();
				
				filePath = pathTemp + File.separator + fileName;
				
				InputStream fis = p.getInputStream();
				FileOutputStream fos = new FileOutputStream(filePath);
				
				byte[] buf = new byte[1024];
				int size = 0;
				
				while((size = fis.read(buf)) != -1)
					fos.write(buf, 0, size);
				
				fos.close();
				fis.close();
			}
		}
		
		// String -> Date 변환
		DateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date startDate = null;
		Date endDate = null;
		
		try {
			startDate = dateFormat.parse(request.getParameter("start-date"));
			endDate = dateFormat.parse(request.getParameter("end-date"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Event event = new Event(id, title, openStatus, startDate, endDate, fileName, filePath);
		
		EventService service = new EventService();
		service.update(event);
		
		response.sendRedirect("detail?id=" + id);
	}
	
}