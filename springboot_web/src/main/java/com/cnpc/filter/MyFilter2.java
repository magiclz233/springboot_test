package com.cnpc.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter2 implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) srequest;
		System.out.println("PropertiesTestMyFilter2,url :"+request.getRequestURI());
		filterChain.doFilter(srequest, sresponse);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}