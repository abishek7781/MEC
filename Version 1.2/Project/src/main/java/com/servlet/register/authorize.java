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

import com.mysql.cj.protocol.Resultset;

@WebServlet("/authorize")
public class authorize extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String update_query = "insert into fees_details1(paid_date,amount,fees_type,reg_no,fees_year) values(?,?,?,?,?)";
	String approvequery = "update fees_details set status='1' where(reg_no=?&&paid_date=?&&amount=?&&fees_type=?)";
	String rejectquery  = "update fees_details set status='0' where(reg_no=?&&paid_date=?&&amount=?&&fees_type=?	)";
	
	String url = "jdbc:mysql://localhost:3306/student";
	String username = "root";
	String password ="Time1234";
	

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
		
		
		
		if(req.getParameter("approve") != null) {
			try (Connection con = DriverManager.getConnection(url,username,password);
				 PreparedStatement ps = con.prepareStatement(approvequery);
					PreparedStatement ps1 = con.prepareStatement(update_query);
					) {
				String reg_no= (String) req.getParameter("approve");
				String date= req.getParameter("date");
				String fees_year = req.getParameter("fees_year");
				int amount = Integer.parseInt(req.getParameter("amount"));
				String fees_type =  req.getParameter("fees");

				System.out.println("YES");
				System.out.println(reg_no);
				System.out.println(date);
				System.out.println(fees_year);

				ps.setString(1, reg_no);
				ps.setString(2, date);
				ps.setInt(3, amount);
				ps.setString(4, fees_type);
				ps1.setString(1, date);
				ps1.setInt(2, amount);
				ps1.setString(3, fees_type);
				ps1.setString(4, reg_no);
				ps1.setString(5, fees_year);

					int count= ps.executeUpdate();
					int count1= ps1.executeUpdate();

					RequestDispatcher dispatcher = req.getRequestDispatcher("update_pending");
					dispatcher.forward(req, resp);
					if(count>=1&&count1>=1) {
		                pw.println("<h2 class='bg-danger text-light text-center'>Student Details Registered Successfully</h2>");
		                
		            }else {
		                pw.println("<h2 class='bg-danger text-light text-center'>Student Details Not Registered</h2>");
		            }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		if(req.getParameter("reject") != null) {
			try (Connection con = DriverManager.getConnection(url,username,password);
				 PreparedStatement ps = con.prepareStatement(rejectquery)) {
				String reg_no= (String) req.getParameter("reject");
				String date= (String) req.getAttribute("date");
				int amount = Integer.parseInt(req.getParameter("amount"));
				String fees_type = req.getParameter("fees");
 				System.out.println("YES.");
				

				ps.setString(1, reg_no);
				ps.setString(2, date);
				ps.setInt(3, amount);
				ps.setString(4, fees_type);


					int count= ps.executeUpdate();
					if(count>=1) {
		                pw.println("<h2 class='bg-danger text-light text-center'>Student Details Registered Successfully</h2>");
		            }else {
		                pw.println("<h2 class='bg-danger text-light text-center'>Student Details Not Registered</h2>");
		            }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}


	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	


}
