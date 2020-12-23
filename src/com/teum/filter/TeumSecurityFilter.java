//package com.teum.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//
//@WebFilter("/*")
//public class TeumSecurityFilter implements Filter{
//	private final static String[] authURLs = {
//			"/user/","/company/","/admin/"
//	};
//	
//	private final static String[] authUser = {
//			"/company/","/admin/"
//	};
//	private final static String[] authCompany = {
//			"/user/","/admin/"
//	};
//	private final static String[] authAdmin = {
//			"/user/","/company/"
//	};
//
//	@Override
//	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletRequest request = ((HttpServletRequest) req);
//		HttpServletResponse response = ((HttpServletResponse)resp);
//		
//		String uri = request.getRequestURI();
//		// TODO Auto-generated method stub
//		HttpSession session = request.getSession();
//		
//		
//		boolean requireAuth = false;
//		for(String url : authURLs) {
//			if(uri.contains(url)) {
//				requireAuth = true;
//				break;
//			}
//		}
//		//인증이 필요한데 인증이 되어있지 않다
//		if(session.getAttribute("email")==null && requireAuth) {
//			
//			response.sendRedirect("/signin?return-url="+uri);
//			return;
//		}
//		
//		// 모든 페이지에 대해 로그인 여부 검사를 마침.
//		// 이제 각 로그인 타입별로 필터링 해줘야함
//		int type = (int)session.getAttribute("type");
//		
//		if(type == 0) {
//			boolean authByUser = false;
//			for(String url : authUser) {
//				if(uri.contains(s))
//			}
//		}
//		
//		
//		chain.doFilter(request,response);
//		
//		//테스트 완료.
//		//필터 설정을 위해서는 url 매핑을 깔끔하게 잘 해야한다.... 안그럼 예외적인 상황이 너무 많이 생긴다.
//	}
//
//}
