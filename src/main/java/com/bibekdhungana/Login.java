package com.bibekdhungana;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(email + "----" + password);

		try {
			// loading a driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// making connection
			String url = "jdbc:mysql://localhost:3306/morning-java-batch";
			String dbUsername = "root";
			String dbPassword = "RisinG123@";
			Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);

			// making prepared statement
			String query = "SELECT * FROM LoginDetails where email = ? and password = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);

			// excute the query
			ResultSet rs = ps.executeQuery();

			// if no data is found
			if (rs.next() == false) {
				request.setAttribute("login", "falses");
				request.setAttribute("message", "Email or username is invalid. Please try again");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				// displaying result from result set

				request.setAttribute("email", email);
				request.setAttribute("password", password);
				System.out.println("Email: " + rs.getString(1));
				System.out.println("Password:" + rs.getString(2));

				request.getRequestDispatcher("congratulations.jsp").forward(request, response);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
