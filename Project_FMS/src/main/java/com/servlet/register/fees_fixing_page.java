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
public class fees_fixing_page extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String query ="insert into fixed_fees values(?,?,?,?,?)";
	String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String username = "root";
	String password ="Time1234";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
        pw.println("<title>Fees Fixing Page</title>");
        pw.println("<link rel='stylesheet' href='css/fees_fixing_output_page.css'></link>");
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
        	pw.println("<div class=\"output-box\">");
            if(count==1) {
            	pw.println("<br>");
                pw.println("<a class=\"op text-white\">Fees Fixed Successfully</a>");
            }else {
            	pw.println("<br>");
                pw.println("<a class=\"op text-white\">Fees Doesn't Fixed</a>");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        pw.println("<br>");
        pw.println("<a type=\"button\" href='login.jsp' class=\"btn\">Home</a>");
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
