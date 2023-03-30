package com.servlet.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
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

@WebServlet("/authorizer")
public class authorizer  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String query = "select * from fees_details where status=?";
		
	String url = "jdbc:mysql://localhost:3306/student";
	String username = "root";
	String password ="Time1234";
	String date,fees_year,fees,amount;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		pw.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\"");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement ps = con.prepareStatement(query);) {
			ps.setString(1, "");
			ResultSet rs = ps.executeQuery();
			pw.println("<div style='margin:auto;width:900px;margin-top:100px;'>");
			pw.println("<img src=\"https://www.madhaengineeringcollege.com/wp-content/uploads/2022/06/hlogo.png\">");
			pw.println("<table class=\"table\">");
            pw.println("<tr>");
            pw.println("<th>Reg_No</th>");
            pw.println("<th>Payment_Date</th>");
            pw.println("<th>Amount</th>");
          pw.println("<th>Fees_Type</th>");
            pw.println("<th>Authorize</th>");
            pw.println("</tr>");	
            while(rs.next()) {
	                pw.println("<tr>");
	                pw.println("<form action='authorize' method='post'>");
	                pw.println("<td>"+rs.getString(1)+"</td>");
	                pw.println("<td>"+rs.getString(2)+"</td>");
	                date = rs.getString(2);
	                fees_year = rs.getString(10);
	                fees = rs.getString(4);
	                amount = rs.getString(3);
		            pw.println("<input type=\"hidden\" value=" + date + " name='date'>");
		            pw.println("<input type=\"hidden\" value=" + fees_year + " name='fees_year'>");
		            pw.println("<input type=\"hidden\" value=" + fees + " name='fees'>");
		            pw.println("<input type=\"hidden\" value=" + amount + " name='amount'>");

		            pw.println("<td>"+rs.getString(3)+"</td>");
	                pw.println("<td>"+rs.getString(4)+"</td>");

	               
	                pw.println("<td><button type=\"authorize\" class=\"btn\" name='approve' value="+rs.getString(1)+" id=\"btn2\" type='APPROVE'>APPROVE</button> </td>");
	                pw.println("<td><button type=\"authorize\" class=\"btn\" name='reject'  value="+rs.getString(1)+" id=\"btn3\" type='REJECT'>REJECT</button> </td>");
	                pw.println("</form>");
	                
	            pw.println("</tr>");
	            }
	            pw.println("</table><br>");
	            /*RequestDispatcher dispatcher = req.getRequestDispatcher("authorize");
	            req.setAttribute("date",date);
	            dispatcher.forward(req, resp);*/
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
