package com.orilore.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CrossFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletResponse rp = (HttpServletResponse)response;
		rp.addHeader("Access-Control-Allow-Origin", "*");
        rp.addHeader("Access-Control-Allow-Methods", "GET, POST");
        rp.addHeader("Access-Control-Allow-Headers", "Content-Type");
        rp.addHeader("Access-Control-Max-Age", "1800");
        chain.doFilter(request, rp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
