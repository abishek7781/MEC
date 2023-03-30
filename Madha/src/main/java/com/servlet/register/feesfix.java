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
@WebServlet("/feesfix")
public class feesfix extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String query ="insert into fixed_fees values(?,?,?,?,?)";
	String url = "jdbc:mysql://127.0.0.1:3306/student";
	String username = "root";
	String password ="Time1234";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
        pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
		String batch = req.getParameter("batch");
		String department = req.getParameter("dept");
		String tution_fees = req.getParameter("tution_fees");
		String hostel_fees = req.getParameter("hostel_fees");
		String transport_fees = req.getParameter("transport_fees");
		
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try (Connection con= DriverManager.getConnection(url,username,password);
			PreparedStatement ps = con.prepareStatement(query);){
        	ps.setString(1, batch);
        	ps.setString(2, tution_fees);
        	ps.setString(3, hostel_fees);
        	ps.setString(4, transport_fees);
        	ps.setString(5, department);

        	int count = ps.executeUpdate();
        	pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
            if(count==1) {
                pw.println("<h2 class='bg-danger text-light text-center'>Student Details Registered Successfully</h2>");
            }else {
                pw.println("<h2 class='bg-danger text-light text-center'>Student Details Not Registered</h2>");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        pw.println("<a href='index.jsp'><button class='btn btn-outline-success'>Home</button></a>");
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
