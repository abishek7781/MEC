package com.servlet.register;


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

@WebServlet("/fees_designation")
public class fees_designation extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String query = "select * from fixed_fees";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        //set content type
        res.setContentType("text/html");
        //link the bootstrap
        pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
        //load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e) {
            e.printStackTrace();
        }
        //generate the connection
        try(Connection con = DriverManager.getConnection("jdbc:mysql:///student?allowPublicKeyRetrieval=true&autoReconnect=true&useSSL=false","root","Time1234");
                PreparedStatement ps = con.prepareStatement(query);){
            //resultSet
            ResultSet rs = ps.executeQuery();
			pw.println("<img style=\"width:264px; height:87px;padding-left:8px;padding-top:1px;\" src=\"https://www.madhaengineeringcollege.com/wp-content/uploads/2022/06/hlogo.png\">");
            pw.println("<button style='float:right;' class='btn btn-outline-success d-block'><a href='accpage.html'>Home</a></button>");
			pw.println("<u><h1 style='font-family:Timesnewroman; font-weight:bold'  class='td1' >Designated Fees</h1></u>");
			
            pw.println("<div style='margin:auto;width:900px;margin-top:100px;'>");
            pw.println("<table class='table table-hover table-striped'>");
            pw.println("<tr>");
            pw.println("<th>Batch</th>");
            pw.println("<th>Tution Fees</th>");
            pw.println("<th>Hostel Fees</th>");
            pw.println("<th>Transport Fees</th>");
            pw.println("<th>Department</th>");

            pw.println("</tr>");
            while(rs.next()) {
                pw.println("<tr>");
                if(rs.getString(3).equals(null)) {
                	continue;
                }
                else {
                pw.println("<td>"+rs.getString(1)+"</td>");
                pw.println("<td>"+rs.getString(2)+"</td>");
                pw.println("<td>"+rs.getString(3)+"</td>");
                pw.println("<td>"+rs.getString(4)+"</td>");
                pw.println("<td>"+rs.getString(5)+"</td>");

                pw.println("</tr>");}
            }
            pw.println("</table>");
        }catch(SQLException se) {
            pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
        pw.println("</div>");
        //close the stream
        pw.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req,res);
    }
}

