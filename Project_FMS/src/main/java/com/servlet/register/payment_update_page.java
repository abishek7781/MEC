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
@WebServlet("/summa")
public class payment_update_page extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String username = "root";
	String password ="Time1234";
	String pending1,pending2,pending3,pending4,addpending1,addpending2,addpending3,addpending4;
	private final static String query =  "select pending_fees,additional_fees_pending from fees_details1 where(reg_no=?&&fees_year=?)";
	private final static String query1 = "select pending_fees,additional_fees_pending from fees_details1 where(reg_no=?&&fees_year=?)";
	private final static String query2 = "select pending_fees,additional_fees_pending from fees_details1 where(reg_no=?&&fees_year=?)";
	private final static String query3 = "select pending_fees,additional_fees_pending from fees_details1 where(reg_no=?&&fees_year=?)";
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = resp.getWriter();
    	resp.setContentType("text/html");
    	String name = (String) req.getAttribute("Name"); 
    	String reg_no = (String) req.getAttribute("Reg_no");  
    	String dept = (String) req.getAttribute("Dept");  
    	String year = (String) req.getAttribute("Year");  
    	String email = (String) req.getAttribute("Email");  
    	String mobile = (String) req.getAttribute("Mobile_no");  
    	String gender = (String) req.getAttribute("Gender");  
    	String Tution_Fees	 = (String) req.getAttribute("Total_fees");  
    	String Tution_fees_Pending	 = (String) req.getAttribute("Pending_fees");  
    	String Tution_fees_Paid	 = (String) req.getAttribute("Paid_fees");  
    	String Additional_fees_pending1 = (String) req.getAttribute("Additional_fees_pending1");  
    	String Additional_fees_paid1 = (String) req.getAttribute("Additional_fees_paid1");  
    	String Additional_fees_type1 = (String) req.getAttribute("Additional_fees_type1");  
    	String Additional_fees_pending = (String) req.getAttribute("Additional_fees_pending");  
    	String Additional_fees_paid = (String) req.getAttribute("Additional_fees_paid");  
    	String Additional_fees = (String) req.getAttribute("Additional_fees");  

    	 try {
             Class.forName("com.mysql.cj.jdbc.Driver");
         }catch(Exception e) {
             e.printStackTrace();
         }
    	 try (Connection con = DriverManager.getConnection(url,username,password);
    		  PreparedStatement ps = con.prepareStatement(query);
    			 PreparedStatement ps1 = con.prepareStatement(query1);
    			 PreparedStatement ps2 = con.prepareStatement(query2);
    			 PreparedStatement ps3 = con.prepareStatement(query3);
    			 )	  {
    		 ps.setString(1, reg_no);
    		 ps.setString(2,"1" );
    		 ps1.setString(1, reg_no);
    		 ps1.setString(2,"2" );
    		 ps2.setString(1, reg_no);
    		 ps2.setString(2,"3" );
    		 ps3.setString(1,reg_no);
    		 ps3.setString(2,"4" );
    		 ResultSet rs = ps.executeQuery();
    		 ResultSet rs1 = ps1.executeQuery();
    		 ResultSet rs2 = ps2.executeQuery();
    		 ResultSet rs3 = ps3.executeQuery();
    		/* if(rs1.next()==false) {
    			 RequestDispatcher dispatcher = req.getRequestDispatcher("payment_entry_form.jsp");
 				req.setAttribute("error", "Invalid register number...");
 				dispatcher.forward(req, resp);

    		 }*/
    		 if (rs.next()&&rs1.next()&&rs2.next()&&rs3.next()) {
    			 pending1=rs.getString(1);
    			 System.out.println(pending1);
    			 pending2=rs1.getString(1);
    			 pending3=rs2.getString(1);
    			 pending4=rs3.getString(1);
    			 addpending1=rs.getString(2);
    			 addpending2=rs1.getString(2);
    			 addpending3=rs2.getString(2);
    			 addpending4=rs3.getString(2);
    			 
    			 System.out.println(pending1);
    			 System.out.println(pending2);
    			 System.out.println(pending3);
    			 System.out.println(pending4);
    			 System.out.println(addpending1);
    			 System.out.println(addpending2);
    			 System.out.println(addpending3);
    			 System.out.println(addpending4);


				
			}
    		 
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
pw.println("<!DOCTYPE html>");
pw.println("<html>");
    pw.println("<head>");
        pw.println("<title>Madha</title>");
        pw.println("<script src=\"js/validate.js\"></script>");
        pw.println("<link rel=\"stylesheet\" href=\"css/payment_entry1.css\">");
        pw.println("</head>");
        pw.println("<body>");
            pw.println("<img src=\"https://www.madhaengineeringcollege.com/wp-content/uploads/2022/06/hlogo.png\">");
            pw.println("<form class=\"form card\" id=\"frm\">" );
                pw.println("<h2 class=\"card-header text-white\">Update Student Fees</h2>");
                pw.println("<table class=\"table table-hover\">");
                    pw.println("<tr>");
                        pw.println("<td><th>Name</th></td>");
                        pw.println("<td>"+name+"</td>");
                        pw.println("<td><th>Tution Fees</th></td>");
                        pw.println("<td>"+Tution_Fees+"</td>");
                    pw.println("</tr>");
                    pw.println("<tr>");
                        pw.println("<td><th>Reg No</th></td>");
                        pw.println("<td>"+reg_no+"</td>");
                        pw.println("<td><th>Tution fees Pending</th></td>");
                        pw.println("<td style=\"color:red\">"+Tution_fees_Pending+"</td>");
                    pw.println("</tr>");
                    pw.println("<tr>");
                        pw.println("<td><th>Dept</th></td>");
                        pw.println("<td>"+dept+"</td>");
                        pw.println("<td><th>Tution Fees Paid</th></td>");
                        pw.println("<td>"+Tution_fees_Paid+"</td>");
                    pw.println("</tr>");
                    pw.println("<tr>");
                        pw.println("<td><th>Email</th></td>");
                        pw.println("<td>"+email+"</td>");
                        pw.println("<td><th>"+Additional_fees_pending1+"</th></td>");
                        if (Additional_fees_pending.equals("0")) {
							pw.println("<td>Nil</td>");
						}
                        else {
                        pw.println("<td style=\"color:red\">"+Additional_fees_pending+"</td>");}
                    pw.println("</tr>");
                    pw.println("<tr>");
                        pw.println("<td><th>Mobile No</th></td>");
                        pw.println("<td>"+mobile+"</td>");
                        pw.println("<td><th>"+Additional_fees_paid1+"</th></td>");
                        pw.println("<td>"+Additional_fees_paid+"</td>");
                    pw.println("</tr>");
                    pw.println("<tr>");
                        pw.println("<td><th>Gender</th></td>");
                        pw.println("<td>"+gender+"</td>");
                        pw.println("<td><th>"+Additional_fees_type1+"</th></td>");
                        pw.println("<td>"+Additional_fees+"</td>");
                    pw.println("</tr>");
                    /*pw.println("<tr>");
                        pw.println("<td>Tution Fees</td>");
                        pw.println("<td>"+Tution_Fees+"</td>");
                    pw.println("</tr>");
                    pw.println("<tr>");
                        pw.println("<td>Tution fees Pending</td>");
                        if (Tution_fees_Pending.equals("0")) {
							pw.println("<td>Nil</td>");
						}
                        else {

						pw.println("<td>"+Tution_fees_Pending+"</td>");}
                    pw.println("</tr>");
                    pw.println("<tr>");
                        pw.println("<td>Tution Fees Paid</td>");
                        pw.println("<td>"+Tution_fees_Paid+"</td>");
                    pw.println("</tr>");
                    pw.println("<tr>");
                        pw.println("<td>"+Additional_fees_pending1+"</td>");
                        if (Additional_fees_pending.equals("0")) {
							pw.println("<td>Nil</td>");
						}
                        else {
                        pw.println("<td>"+Additional_fees_pending+"</td>");}
                    pw.println("</tr>");
                    pw.println("<tr>");
                        pw.println("<td>"+Additional_fees_paid1+"</td>");
                        pw.println("<td>"+Additional_fees_paid+"</td>");
                    pw.println("</tr>");
                    pw.println("<tr>");
                        pw.println("<td>"+Additional_fees_type1+"</td>");
                        pw.println("<td>"+Additional_fees+"</td>");
                    pw.println("</tr>");*/

                    
            pw.println("</table>");
            pw.println("</form>");

            pw.println("<form class=\"form card\"  id=\"frm1\" action=\"search1\" method=\"post\" >");

            pw.println("<input type=\"hidden\" value="+reg_no+" name=\"reg_no4\">");

            pw.println("<h2 class=\"card-header text-white \">Pay Student Fees</h2>");
            pw.println("<div class=\"box\">");
            pw.println("<input type=\"radio\" name=\"fees\" value=\"1\" required>");
                pw.println("<label>Tution Fees</label>");
            pw.println("<input type=\"radio\" name=\"fees\" value=\"2\" required>");
                pw.println("<label>Transport Fees</label>");
            pw.println("<input type=\"radio\" name=\"fees\" value=\"3\" required>");
                pw.println("<label>Hostel Fees</label>");
            pw.println("<input type=\"radio\" name=\"fees\" value=\"4\" required>");
                pw.println("<label>MISC Fees</label>");
                pw.println("<br>");
            pw.println("<label>Payment Date & Time </label>");
                pw.println("<input type=\"datetime-local\" name=\"date\" value=\"\" required>");
                pw.println("<br>");
            pw.println("<label>Enter Amount</label>");
                pw.println("<input type=\"text\" name=\"amount\" placeholder=\"Enter Amount\" required class=\"input-box\">");
               

                pw.println("<br>");
            pw.println("<label>Select Year</label>");
                pw.println("<input type=\"radio\" name=\"fees_year\" value=\"1\" required>");
            pw.println("<label>I</label>");
            if (pending1.equals("0")&&addpending1.equals("0")||addpending1==null) {
                pw.println(
                        "<input type=\"radio\" name=\"fees_year\" id=\"showbtn\" value=2 required>");
                pw.println("<label>II</label>");
            }
                if (pending2.equals("0")&&addpending2.equals("0")||addpending2==null) {
                    pw.println(
                            "<input type=\"radio\" name=\"fees_year\" id=\"showbtn\" value=3 required>");
                    pw.println("<label>III</label>");
                }
                
                    if (pending3.equals("0")&&addpending3.equals("0")||addpending3==null) {
                        pw.println(
                                "<input type=\"radio\" name=\"fees_year\"  id=\"showbtn\" value=4 required>");
                        pw.println("<label>IV</label>");
                    }
            pw.println("<br>");
            
            pw.println("<input type=\"submit\" name=\"viewdetails\" class=\"btn\" value=\"Pay\">");
			pw.println("<a type=\"button\" class=\"btn\" value=\"Home\" href=\"login.jsp\">Home</a>");

        pw.println("</div>");

        pw.println("</form>");

    pw.println("</body>");
pw.println("</html>");
}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(req, resp);
}


}




	