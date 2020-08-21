package com.wellsfargo.fsd.ck.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter("/AdminLogin")
public class AdminAuthentication implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		if ((request.getParameter("userid").equalsIgnoreCase("admin")) && (request.getParameter("password").equalsIgnoreCase("admin")))
		{
			System.out.println("Authentication Passed");
			
			chain.doFilter(request, response);
		}
		else
		{
			System.out.println("Authentication Failed");
			request.setAttribute("errMsg", "Invalid Admin Userid password entered");
			request.getRequestDispatcher("errPage.jsp").forward(request, response);
		}
		
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
