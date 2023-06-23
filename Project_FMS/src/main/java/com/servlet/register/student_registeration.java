package com.servlet.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/student_register")
public class student_registeration extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String username_sql = "root";
	String password_sql ="Time1234";
	String query = "insert into student_login values(?,?,?,?,?)";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	PrintWriter pw = resp.getWriter();
    	resp.setContentType("text/html");
    	pw.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\"");
    	String reg_no = req.getParameter("reg_no");
    	String name = req.getParameter("name");
    	String email = req.getParameter("email");
    	String password = req.getParameter("password");
    	String confirm_password = req.getParameter("confirm-password");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection(url,username_sql,password_sql);
			PreparedStatement ps = con.prepareStatement(query);) {
			ps.setString(1, reg_no);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setString(5, confirm_password);
			int count = ps.executeUpdate();
			 pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
	            if(count==1) {
	                pw.println("<h2 class='bg-danger text-light text-center'>Student Details Registered Successfully</h2>");
	            }else {
	                pw.println("<h2 class='bg-danger text-light text-center'>Student Details Not Registered!!!!</h2>");
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(req, resp);
    }
}
