package com.bridgelabz.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bridgelabz.register.dao.CustomerDAO;
import com.bridgelabz.register.dao.CustomerDAOImpl;
import com.bridgelabz.register.model.Customer;

public class LoginRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginRegisterServlet() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();

		CustomerDAO customerDAO = new CustomerDAOImpl();

		String userName = request.getParameter("username");
		String password = request.getParameter("password1");
		String submitType = request.getParameter("submit");

		Customer customer = customerDAO.getCustomer(userName, password);

		if (submitType.equals("Login") && customer != null && customer.getName() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("message", userName);
			session.setMaxInactiveInterval(30);

			if (session != null) {
				session = request.getSession(false);
				userName = (String) session.getAttribute("username");
				printWriter.print("Welcome " + userName);
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			}
		} else if (submitType.equals("register")) {
			userName = request.getParameter("username");
			int count = 0;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ritesh", "root",
						"mysql");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("select * from customer where username='" + userName + "'");
				while (resultSet.next()) {
					count++;
				}
				if (count > 0) {
					request.setAttribute("error", "Error: User Is Already exists");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
					requestDispatcher.forward(request, response);
				} else {
					customer.setName(request.getParameter("username"));
					customer.setPassword(password);
					customer.setUsername(userName);

					customerDAO.insertCustomer(customer);

					request.setAttribute("successMessage", "Registration Done, Please Login to continue");
					request.getRequestDispatcher("login.jsp").forward(request, response);
					printWriter.println("Data is successfully inserted!");
				}
			} catch (Exception e) {
				System.out.print(e);
			}
		} else {
			request.setAttribute("message", "Data Not Found, Click On Register");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}