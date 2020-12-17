package com.teum.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(
		urlPatterns = {"/*"},
		initParams = {@WebInitParam(name="encoding",value="UTF-8")}
)
public class CharacterEncodingFilter implements Filter{

	private String encoding = "UTF-8";//�ʱⰪ�� �������ְ� init�� ���ؼ� ���� �����ϴ�.
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		
		//�̰͵� ����ȭ�ȰͰ� �ٸ� ����. jar������ ���� ���뼺�� ���̱� ���ؼ��� �̰��� ����ȭ�ؼ� �����Ͽ� ��� �����ϵ��� �ؾ��Ѵ�.
		request.setCharacterEncoding(encoding);
		
		//System.out.println("before 필터");
		chain.doFilter(request, response);
		//System.out.println("after 필터");
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		//xml�� filter �±׿��� �ʱ⼳�� ���� �ִٸ�(init param) �װ� filterConfig�� ������
		encoding = filterConfig.getInitParameter("encoding");
	}

}
