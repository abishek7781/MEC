package com.servlet.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateonfeesdetails")
public class updateonfeesdetails extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String username = "root";
	String password ="Time1234";
	int i;
	int count;
	private final static String query = "insert into fees_details(reg_no,pending_fees,paid_fees,additional_fees_paid,additional_fees_pending,fees_year,name) values(?,?,?,?,?,?,?)";
	private final static String query1 = "insert into fees_details1(reg_no,pending_fees,paid_fees,additional_fees_paid,additional_fees_pending,fees_year,name) values(?,?,?,?,?,?,?)";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reg_no=req.getParameter("reg_no");
		String fees= String.valueOf(req.getAttribute("fees1")) ;
		String additional_fees=(String) req.getAttribute("add_fees1");
		String fees_year=req.getParameter("fees_year");
		String name = (String) req.getAttribute("name");
		
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
	    pw.println("<link rel='stylesheet' href='css/new.css'></link>");
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try (
	    	    Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement ps=con.prepareStatement(query);
	    		PreparedStatement ps1=con.prepareStatement(query1);){
	    	ps.setString(1, reg_no);
	    	ps.setString(2, fees);
	    	ps.setString(3, "00");
	    	ps.setString(4, "00");
	    	ps.setString(5, additional_fees);
	    	ps.setString(7, name);
	    	for (int i = 1; i < 5; i++) {
	    		ps.setString(6,Integer.toString(i));
	    		count=  ps.executeUpdate();
				
			}
	    	ps1.setString(1, reg_no);
	    	ps1.setString(2, fees);
	    	ps1.setString(3, "00");
	    	ps1.setString(4, "00");
	    	ps1.setString(5, additional_fees);
	    	ps1.setString(7, name);

	    	for (int i = 1; i < 5; i++) {
	    		ps1.setString(6,Integer.toString(i));
	    		count=  ps1.executeUpdate();
				
			}
	    	
	    	 pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
	            if(count==1) {
	                pw.println("<h2 class='bg-danger text-light text-center'>Student Details Registered Successfully</h2>");
	            }else {
	                pw.println("<h2 class='bg-danger text-light text-center'>Student Details Not Registered!!!!</h2>");
	            }
	    	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher dispatcher = req.getRequestDispatcher("registerpage.jsp");
			req.setAttribute("error", "register number already exists...");
			dispatcher.forward(req, resp);

		}
	    pw.println("<a href='login.jsp'><button class='btn btn-outline-success'>Home</button></a>");
        pw.println("</div>");
        //close the stram
        pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
