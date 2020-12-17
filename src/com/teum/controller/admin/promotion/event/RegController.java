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

@WebServlet("/admin/promotion/event/reg")
@MultipartConfig( 
	    fileSizeThreshold = 1024*1024, 
	    maxFileSize = 1024*1024*5, 
	    maxRequestSize = 1024*1024*5*5)
public class RegController extends HttpServlet {

	private EventService service;
	
	public RegController() {
		service = new EventService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		request.getRequestDispatcher("reg.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자로부터 전달받은 데이터를 변수에 담기
		String title = request.getParameter("title");
		String openStatus_ = request.getParameter("open");
		
		int openStatus = 0;
		if (openStatus_ != null && !openStatus_.equals("")) 
			openStatus = Integer.parseInt(openStatus_);
		
		Collection<Part> fileParts = request.getParts();
		String fileName = null;
		String filePath = null;
		StringBuilder builder = new StringBuilder();
		
		// 파일 다중 업로드
		for (Part p : fileParts) {
			if (p.getName().equals("file") && p.getSize() > 0) {
				// 만약 처음으로 등록하는 글이라면?
				
				// 현재 게시글에 들어가 있는 번호중에서 마지막 번호를 동적으로 알아내기
				int newId = service.getLastId() + 1;
				System.out.printf("newId: %d", newId);
				if (newId == 0)
					newId = service.getId();
				
				// 서블릿들이 필요로하는 공동자원들
				// getRealPath는 상대경로를 넘겨주면 물리경로를 알려준다
				String pathTemp = request.getServletContext().getRealPath("/images/event/2020/" + newId); 
				
				// file저장경로: /images/event/2020/26/
				// 배포된 디렉토리에 저장되기 때문에 이클립스에서는 확인이 불가능
				File path = new File(pathTemp); // 얘는 절대경로만 받는다.
				if (!path.exists())
					path.mkdirs();
				
				fileName = p.getSubmittedFileName();
				filePath = pathTemp + File.separator + fileName;
				builder.append(fileName);
				builder.append(",");
				
				InputStream fis = p.getInputStream();
				FileOutputStream fos = new FileOutputStream(filePath);
				
				byte[] buf = new byte[1024];
				int size = 0;
				
				while((size = fis.read(buf)) != -1)
					fos.write(buf, 0, size);
				
				fos.close();
				fis.close();
				
				System.out.printf("filename: %s, filepath: %s", fileName, filePath);
			}
		}
		builder.delete(builder.length() - 1, builder.length());
		
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
		
		Event event = new Event(title, openStatus, startDate, endDate, builder.toString(), filePath);
		
		// 2. 데이터베이스에 넣기
		EventService service = new EventService();
		service.insert(event);
		
		// 3. 페이지 전환
		response.sendRedirect("list");
	}
	
}
