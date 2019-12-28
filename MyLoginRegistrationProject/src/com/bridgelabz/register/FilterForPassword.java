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

/**
 * Servlet Filter implementation class FilterForPassword
 */
@WebFilter("/LoginRegister")
public class FilterForPassword implements Filter {

	public FilterForPassword() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		PrintWriter out = response.getWriter();

		String password = request.getParameter("password1");
		if (password.length() >= 1 && password.length() < 8)
			chain.doFilter(request, response);
		else {
			out.print("Invalid Input");
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}
}