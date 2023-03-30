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
@WebServlet("/update_pending")
public class update_pending extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String pending_fees_query="select pending_fees from fees_details1 where(reg_no=?&&fees_year=?)";
	String paid_fees_query="select paid_fees from fees_details1 where(reg_no=?&&fees_year=?)";
	String paid_amount_update_query="update fees_details1 set paid_fees=? where(reg_no=?&&fees_year=?)";
	String Pending_amount_update_query="update fees_details1 set pending_fees=? where(reg_no=?&&fees_year=?)";
	
	String paid_addfees_query="select additional_fees_paid from fees_details1 where(reg_no=?&&fees_year=?)";
	String pending_addfees_query="select additional_fees_pending from fees_details1 where(reg_no=?&&fees_year=?)";
	String paid_addfees_update_query="update fees_details1 set additional_fees_paid=? where(reg_no=?&&fees_year=?)";
	String Pending_addfees_update_query="update fees_details1 set additional_fees_pending=? where(reg_no=?&&fees_year=?)";
	String url = "jdbc:mysql://localhost:3306/student";
	String username = "root";
	String password ="Time1234";
	int amount,count,total_fees,paid_fees,pending_fees,paid_add_fees,pending_add_fees;
	boolean var;

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
		
		try (Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement ps1=con.prepareStatement(pending_fees_query);
	    		PreparedStatement ps2=con.prepareStatement(paid_fees_query);
	    		PreparedStatement ps3=con.prepareStatement(paid_amount_update_query);
	    		PreparedStatement ps4=con.prepareStatement(Pending_amount_update_query);
	    		PreparedStatement ps5=con.prepareStatement(paid_addfees_query);
	    		PreparedStatement ps6=con.prepareStatement(pending_addfees_query);
	    		PreparedStatement ps7=con.prepareStatement(paid_addfees_update_query);
	    		PreparedStatement ps8=con.prepareStatement(Pending_addfees_update_query	);) {
			String reg_no= (String) req.getParameter("approve");
			String date= req.getParameter("date");
			String fees_year = req.getParameter("fees_year");
			int amount = Integer.parseInt(req.getParameter("amount"));
			System.out.println("YES");
			System.out.println(reg_no);
			System.out.println(date);
			System.out.println(fees_year);
			ps1.setString(1, reg_no);
			ps1.setString(2, fees_year);

			
			ps2.setString(1, reg_no);
			ps2.setString(2, fees_year);

			    ps5.setString(1, reg_no);
		        ps5.setString(2, fees_year);

		        ps6.setString(1, reg_no);
		        ps6.setString(2, fees_year);

			ResultSet rs1 = ps1.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			ResultSet rs3 = ps5.executeQuery();
	        ResultSet rs4 = ps6.executeQuery();
	        
	        if(rs1.next()&&rs2.next()) {
	        	pending_fees=Integer.parseInt(rs1.getString(1));
	        	System.out.println(rs1.getString(1));		

	        	paid_fees=Integer.parseInt(rs2.getString(1));
	        }
	    	System.out.println(date+"lljjj");

	        if(rs3.next()&&rs4.next()) {
	        	var =rs4.getString(1).isEmpty();
	        	System.out.println(var	+"lljjj");

	        	if(var!=true) {
	        	paid_add_fees=Integer.parseInt(rs3.getString(1));
	        	pending_add_fees=Integer.parseInt(rs4.getString(1));
	        }}
	        
	    	System.out.println(date+"jjj");


	        int parameter =Integer.parseInt( req.getParameter("fees"));
	        
	        if(parameter==1) {
	        paid_fees+=amount;
	        pending_fees-=amount;}
	       else{
	    	   
	        	paid_add_fees+=amount;
	        	pending_add_fees-=amount;
			}
	        ps3.setInt(1, paid_fees);
	        ps3.setString(2, reg_no);
	        ps3.setString(3, fees_year);

	        ps4.setInt(1, pending_fees);
	        ps4.setString(2, reg_no);
	        ps4.setString(3, fees_year);

	        ps7.setInt(1, paid_add_fees);
	        ps7.setString(2, reg_no);
	        ps7.setString(3, fees_year);

	        ps8.setInt(1, pending_add_fees);
	        ps8.setString(2, reg_no);
	        ps8.setString(3, fees_year);

	        int count1= ps3.executeUpdate();
	        int count2=ps4.executeUpdate();
	        int count3= ps7.executeUpdate();
	        int count4=ps8.executeUpdate();
	    	System.out.println("jjj");

	        if(count1>=1&&count2>=1&&count3>=1&&count4>=1) {
                pw.println("<h2 class='bg-danger text-light text-center'>Student Details Registered Successfully</h2>");
                
            }else {
                pw.println("<h2 class='bg-danger text-light text-center'>Student Details Not Registered</h2>");
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
