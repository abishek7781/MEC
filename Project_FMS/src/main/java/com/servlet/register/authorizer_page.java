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

@WebServlet("/authorizer_page")
public class authorizer_page  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String query = "select * from fees_details where status=?";
	String name_query = "SELECT name from fees_details where reg_no=?&&name is not null;";
	String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String username = "root";
	String password ="Time1234";
	String date,fees_year,fees,amount;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		String msg = (String) req.getAttribute("msg");
		pw.println("<link rel=\"stylesheet\" href=\"css/authorizer_page.css\"");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement ps = con.prepareStatement(query);
			PreparedStatement ps1=con.prepareStatement(name_query);) {
			ps.setString(1, "");
			ResultSet rs = ps.executeQuery();
			pw.println("<div style='margin:auto;width:900px;margin-top:100px;'>");
			pw.println("<img style=\"width:264px; height:87px;padding-left:8px;padding-top:1px;\" src=\"https://www.madhaengineeringcollege.com/wp-content/uploads/2022/06/hlogo.png\">");
        	pw.println("<a type=\"submit\" href=\"login.jsp\" class=\"btn\" >HOME </a>");


			pw.println("<u><h1 style='font-family:Timesnewroman; font-weight:bold'  class='td1' >Authorizer Page</h1></u>");
            if(msg!=null) {
    			pw.println("<a3 style=\"margin-left:%; font-weight:bold; color:green;\" class=\"resultpage\" >"+msg+"</a3>");}
            pw.println("<tr>");
			pw.println("<table style='margin-top:2cm;'class=\"table\">");
            pw.println("<tr>");
            pw.println("<th>Name</th>");
            pw.println("<th>Reg No</th>");
            pw.println("<th>Payment Date</th>");
            pw.println("<th>Amount</th>");
          pw.println("<th  class=\"td11 \">Fees_Type</th>");
            pw.println("<th class=\"td1\" \">Approve/Reject</th>");
            pw.println("</tr>");	
            while(rs.next()) {
            		String reg_no = rs.getString(1);
            		ps1.setString(1, reg_no);
            		ResultSet rs1 = ps1.executeQuery();
	                pw.println("<tr>");
	                pw.println("<form action='authorize' method='post'>");
	               if(rs1.next()) {
	            	   pw.println("<td class=\"td1\">"+reg_no+"</td>");
	               }
	                pw.println("<td class=\"td1\">"+rs.getString(1)+"</td>");
	                pw.println("<td class=\"td1\">"+rs.getString(2).substring(0,10)+"</td>");
	                date = rs.getString(2);
	                fees_year = rs.getString(10);
	                fees = rs.getString(4);
	                if(fees.equals("1")) {
	                	fees="Tution fees";
	                }
	                if(fees.equals("2")) {
	                	fees="Transport fees";
	                }if(fees.equals("3")) {
	                	fees="Hostel fees";
	                }
	                amount = rs.getString(3);
		            pw.println("<input type=\"hidden\" value=" + date + " name='date'>");
		            pw.println("<input type=\"hidden\" value=" + fees_year + " name='fees_year'>");
		            pw.println("<input type=\"hidden\" value=" + rs.getString(4) + " name='fees'>");
		            pw.println("<input type=\"hidden\" value=" + amount + " name='amount'>");

		            pw.println("<td class=\"td1\">"+rs.getString(3)+"</td>");
	                pw.println("<td class=\"td1\">"+fees+"</td>");

	               
	                pw.println("<td> <button type=\"authorize\" class=\"btn\"  name='approve'  value="+rs.getString(1)+" id=\"btn2\" type='APPROVE'>APPROVE</button> ");
	                pw.println("<button type=\"authorize\" class=\"btn\" name='reject' value="+rs.getString(1)+" id=\"btn3\" type='REJECT'>REJECT</button></td>");

	                
	            pw.println("</tr>");

	            }
            pw.println("</table><br>");

            	pw.println("</form>");
                pw.println("<br>");
                pw.println("<br>");


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
