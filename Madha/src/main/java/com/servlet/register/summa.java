package com.servlet.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class summa extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=resp.getWriter();
		pw.println("<table class=\"l\">");
		pw.println("<tbody><tr>");
           pw.println("<th>Name</th>");
           pw.println("<th>Department</th>");
           pw.println("<th>Year</th>");
           pw.println("<th>Email</th>");
           pw.println("<th>Mobile No</th>");
           pw.println("<th>Gender</th>");
           pw.println("<th>Fees</th>");
       pw.println("</tr>");
       
       
       
       pw.println("<tr>");
           pw.println("<td>Ram</td>");
           pw.println("<td>IT</td>");
           pw.println("<td>2</td>");
           pw.println("<td>ram@gmail.com</td>");
           pw.println("<td>9876543210</td>");
           pw.println("<td>Male</td>");
           pw.println("<td>25000</td>");
           pw.println("</tr>");
           pw.println("</tbody></table><br><br><br><br>");
           pw.println("<table class=\"m\">");
           pw.println("<tbody><tr>");
           pw.println("<th style=\"width:40%\">Paid Tution Fees</th>\")");
       pw.println("<td>Amount</td>");
       pw.println("<th style=\"width:35%\">Paid Transport Fees</th>\")");
       pw.println("<td>Amount</td></tr><tr>");
       pw.println("<th>Pending Tution Fees</th>");
       pw.println("<td>Amount</td>");
       pw.println("<th>Pending Transport Fees</th>");
       pw.println("<td>Amount</td>");
       pw.println("</tr>");
       pw.println("<tr>");
       
       pw.println("</tr>");
       pw.println("</tbody></table><br><br><br><br><br><br>");
   pw.println("<table class=\"n\">");  	
   pw.println("<tbody><tr>");
           pw.println("<th>Paid Hostel Fees</th>");
           pw.println("<td>Amount</td>");
           pw.println("<th>Paid MISC Fees</th>");
           pw.println("<td>Amount</td></tr><tr>");
           pw.println("<th style=\"width:40%\">Pending Hostel Fees</th>");
           pw.println("<td>Amount</td>");
           pw.println("<th>Pending MISC Fees</th>");
           pw.println("<td>Amount</td>");
           pw.println("</tr>");
           pw.println("</tbody></table><br><br><br><br><br><br><table class=\"a\"><tbody><tr>");
           pw.println("<th>Paid Date</th>");
           pw.println("<th style=\"width:13%\">Amount</th>");
           pw.println("<th style=\"width:47%\">Fees Type</th>");
           pw.println("</tr>");
           pw.println("</tbody></table>");
	}
}
