package com.bridgelabz.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginRegister
 */
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginRegister() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		CustomerDAO customerDAO = new CustomerDAOImpl();
		String userName = request.getParameter("username");
		String password = request.getParameter("password1");
		String submitType = request.getParameter("submit");

		Customer customer = customerDAO.getCustomer(userName, password);

		if (submitType.equals("Login") && customer != null && customer.getName() != null) {
			HttpSession session = request.getSession(true);

			session.setAttribute("message", userName);
			session.setMaxInactiveInterval(30); // 30 seconds
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
			//response.sendRedirect("welcome.jsp");

		} else if (submitType.equals("register")) {
			customer.setName(request.getParameter("name"));

			customer.setPassword(password);
			customer.setUsername(userName);

			customerDAO.insertCustomer(customer);

			request.setAttribute("successMessage", "Registration Done, PleaseLogin to continue");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "Data Not Found, Click On Register");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}