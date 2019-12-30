package com.bridgelabz.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.security.util.Length;

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter("/LoginRegister")
public class FilterForUserName implements Filter {

	public FilterForUserName() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("username");
		if (userName.length() > 1)
			chain.doFilter(request, response);
		else {
			out.print("Invalid Input");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}
}