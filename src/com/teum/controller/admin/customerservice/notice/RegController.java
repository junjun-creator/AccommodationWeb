package com.teum.controller.admin.customerservice.notice;

import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.teum.entity.Notice;
import com.teum.service.NoticeService;

@WebServlet("/admin/customerService/notice/reg")
@MultipartConfig(
		fileSizeThreshold=1024*1024, 
	    maxFileSize=1024*1024*5, 
	    maxRequestSize=1024*1024*5*5)

public class RegController extends HttpServlet {
	private NoticeService service = new NoticeService();
	
	public RegController() {
		service = new NoticeService();
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getMethod().equals("GET")) {
			request.getRequestDispatcher("reg.jsp").forward(request, response);
		} else if (request.getMethod().equals("POST")) {

			String title = request.getParameter("title");
			String content = request.getParameter("content");
			content = content.replace("\r\n", "<br >");
			int adminId = Integer.parseInt(request.getParameter("ADMIN_ID"));
			Part file = request.getPart("IMAGE_NAME");
			String open =request.getParameter("OPEN_STATUS");
			if(open!=null) {
				open ="1";
			}else {
				open="0";
			}
			
			int openStatus = Integer.parseInt(open);
			 
			Notice notice = new Notice(title, content, adminId, openStatus);
			
			if(file !=null && file.getSize()>0l) {
				String fileName = file.getSubmittedFileName();
				notice.setImageName(fileName);
				
				int newId = service.getLastId() +1;
				
				String pathTemp = request.getServletContext().getRealPath("/images/notice/2020/"+newId);
				
				File path = new File(pathTemp);
				if(!path.exists())
					path.mkdirs();
				
				String filePath = pathTemp+File.separator+fileName;
				
				InputStream fis = file.getInputStream();
				FileOutputStream fos = new FileOutputStream(filePath);
				
				byte[] buf = new byte[1024];
				int size= 0;
				while((size = fis.read(buf)) != -1)
					fos.write(buf, 0,size);
					
				fos.close();
				fis.close();
			}

			//NoticeService service = new NoticeService();
			service.insert(notice);

			response.sendRedirect("list");
		}
	}
}
