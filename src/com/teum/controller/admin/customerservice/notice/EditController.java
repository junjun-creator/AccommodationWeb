package com.teum.controller.admin.customerservice.notice;

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



@WebServlet("/admin/customerService/notice/edit")
@MultipartConfig(
		fileSizeThreshold=1024*1024, 
	    maxFileSize=1024*1024*5, 
	    maxRequestSize=1024*1024*5*5)
public class EditController extends HttpServlet{
	private NoticeService service = new NoticeService();
	
	public EditController() {
		service = new NoticeService();
	}
	
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		NoticeService service = new NoticeService();
		Notice n = service.get(id); 
		
		request.setAttribute("n", n);
		request.getRequestDispatcher("edit.jsp").forward(request,response);
		
		}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		content = content.replace("\r\n", "<br >");
		int adminId = Integer.parseInt(request.getParameter("ADMIN_ID"));
		String open =request.getParameter("OPEN_STATUS");
		Part file = request.getPart("IMAGE_NAME");
		
		if(open!=null) {
			open ="1";
		}else {
			open="0";
		}
		
		int openStatus = Integer.parseInt(open);
		
		Notice notice = new Notice(title,content,adminId,openStatus);
		notice.setId(Integer.parseInt(id));
		
		if(file !=null && file.getSize()>0l) {
			String fileName = file.getSubmittedFileName();
			notice.setImageName(fileName);
			
			String pathTemp = request.getServletContext().getRealPath("/images/notice/2020/"+id);
			
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
		
		
		service.update(notice);
		
		response.sendRedirect("detail?id="+id);
	}

}
