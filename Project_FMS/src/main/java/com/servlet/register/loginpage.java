package com.servlet.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class loginpage extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String query = "select * from student_login where reg_no=?";
	String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String username_sql = "root";
	String password_sql ="Time1234";
	String reg_no,db_password;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		pw.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\"");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String roll= req.getParameter("roll");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (roll.equals("student")) {
			try (Connection con = DriverManager.getConnection(url, username_sql, password_sql);
					PreparedStatement ps = con.prepareStatement(query);) {
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					reg_no = rs.getString(1);
					db_password = rs.getString(4);
					System.out.println(reg_no);
					System.out.println(db_password);

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (username.equals(reg_no) && password.equals(db_password)) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("student_page");
				dispatcher.forward(req, resp);
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				req.setAttribute("error", "Invalid username or password...");
				dispatcher.forward(req, resp);
		    	 

			} 
		}
		if (roll.equals("admin")) {
			if (username.equals("Admin") && password.equals("123")) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("authorizer_page");
				dispatcher.forward(req, resp);
			} 
			else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				req.setAttribute("error", "Invalid username or password...");
				dispatcher.include(req, resp);
			} 
		}
		if (roll.equals("higher")) {
			if (username.equals("Higher") && password.equals("123")) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("enquirypage.jsp");
				dispatcher.forward(req, resp);
			} 
			else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				req.setAttribute("error", "Invalid username or password...");
				dispatcher.forward(req, resp);
		    	 

			} 
		}if (roll.equals("accountant")) {
			if (username.equals("Accountant") && password.equals("123")) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("accpage.html");
				dispatcher.forward(req, resp);
			} 
			else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				req.setAttribute("error", "Invalid username or password...");
				dispatcher.forward(req, resp);
		    	 

			}  
		}
		
		
		
		
		
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
