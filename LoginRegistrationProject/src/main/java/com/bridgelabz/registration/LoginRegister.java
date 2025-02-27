package com.bridgelabz.registration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		CustomerDAO customerDAO = new CustomerDAOImpl();
		String userName = request.getParameter("username");
		String password = request.getParameter("password1");
		String submitType = request.getParameter("submit");

		Customer customer = new Customer();
		customer = customerDAO.getCustomer(userName, password);

		if (submitType.equals("Login")) {
			request.setAttribute("message", userName);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);

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