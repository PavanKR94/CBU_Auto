package com.project.src.databaseUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConnectionTest
 */
@WebServlet("/ConnectionTest")
public class ConnectionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ConnectionTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set up connection
		String jdbcUrl = "jdbc:mysql://localhost:3306/customer_details?userSSL=false&serverTimezone=UTC";
		String user = "customerDB";
		String password = "customerDB";
		String driver = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(jdbcUrl, user, password);

			System.out.println("Connection successful!!!");

			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
