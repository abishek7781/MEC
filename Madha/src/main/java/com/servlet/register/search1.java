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
@WebServlet("/search1")

public class search1 extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String url = "jdbc:mysql://127.0.0.1:3306/student";
	String username = "root";
	String password ="Time1234";
	private final static String update_query = "insert into fees_details(paid_date,amount,fees_type,reg_no,fees_year,status) values(?,?,?,?,?,?)";
	
	int amount,count,total_fees,paid_fees,pending_fees,paid_add_fees,pending_add_fees;
	boolean var;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String reg_no = req.getParameter("reg_no4");
	System.out.println(reg_no);
	int amount=Integer.parseInt((String) (req.getParameter("amount")));
	System.out.println(amount);
	String paid_date=req.getParameter("date");
	String fees_type=req.getParameter("fees");
	String fees_year=req.getParameter("fees_year");
	System.out.println(paid_date);

		
		// TODO Auto-generated method stub
	PrintWriter pw=resp.getWriter();
	resp.setContentType("text/html");
    pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
    try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    	
    try(Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement ps = con.prepareStatement(update_query);
    		
    		){
    	System.out.println(paid_date);

        //set the values
        ps.setString(1, paid_date);
        ps.setString(3, fees_type);
        ps.setString(4, reg_no);
        ps.setInt(2, amount);
        ps.setString(5, fees_year);
        ps.setString(6, "");

        ps.setString(4, reg_no);
       

      
    
     
        //execute the query
        int count = ps.executeUpdate();
       
    	
        pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
        if(count==1) {
            pw.println("<h2 class='bg-danger text-light text-center'>Paid Successfully</h2>");
        }else {
            pw.println("<h2 class='bg-danger text-light text-center'>Payment Not Processed</h2>");
        }
    }catch(SQLException se) {
        pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
        se.printStackTrace();
    }catch(Exception e) {
        e.printStackTrace();
    }
    pw.println("<a href='index.jsp'><button class='btn btn-outline-success'>Home</button></a>");
    pw.println("</div>");
    //close the stram
    pw.close();
}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    doGet(req,res);
}
}

