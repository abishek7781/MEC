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
@WebServlet("/showdetails1")
public class printreceipt extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String username = "root";
	String password ="Time1234";
	String query="select * from student_details where reg_no=?";
	String query2="select * from fees_details1 where(reg_no=?&&fees_year=?)";
	String query3="select pending_fees,paid_fees,additional_fees_pending,additional_fees_paid from fees_details1 where(reg_no=?&&fees_year=?)";
	String query4="select * from fees_details where(reg_no=?&&fees_year=?&&status='')";

	int fees_typeint;
	String fees_typeString;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reg_no=(String) req.getAttribute("reg_no2");
		String fees_year=(String) req.getAttribute("fees_year");
		System.out.println(reg_no);
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		pw.println("<link rel=\"stylesheet\" href=\"css/new.css\"");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection(url,username,password);
PreparedStatement ps=con.prepareStatement(query);
PreparedStatement ps1=con.prepareStatement(query2);
PreparedStatement ps2=con.prepareStatement(query3);
				PreparedStatement ps3=con.prepareStatement(query4);
				) {
			ps.setString(1, reg_no);
			ps1.setString(2, fees_year);

			ps1.setString(1, reg_no);
			ps3.setString(2, fees_year);

			ps3.setString(1, reg_no);
			ps2.setString(1, reg_no);
			ps2.setString(2, fees_year);
			ResultSet rs =  ps.executeQuery();
			ResultSet rs1=ps1.executeQuery();
			ResultSet rs2=ps2.executeQuery();
			ResultSet rs3=ps3.executeQuery();

			
			pw.println("<div style='margin:auto;width:900px;margin-top:100px;'>");
			pw.println("<img src=\"https://www.madhaengineeringcollege.com/wp-content/uploads/2022/06/hlogo.png\">");
			pw.println("<a type=\"button\" class=\"btn\" value=\"Home\" id=\"printpagebutton\" href=\"login.jsp\">Home</a>");

			pw.println("<input type=\"button\" class=\"button\" id=\"printpagebutton\" value=\"Fees Receipt\" onclick=\"window.print()\">");
            pw.println("<div>");

			pw.println("<table class=\"table\">");
            pw.println("<tr>");
            pw.println("<th>Name</th>");
            pw.println("<th>Department</th>");
            pw.println("<th>Year</th>");
            pw.println("<th>Mobile No</th>");
            pw.println("<th>Fees</th>");
            pw.println("</tr>");
	            while(rs.next()) {
	                pw.println("<tr>");
	                pw.println("<td>"+rs.getString(1)+"</td>");
	                pw.println("<td>"+rs.getString(3)+"</td>");
	                pw.println("<td>"+rs.getString(4)+"</td>");
	                pw.println("<td>"+rs.getString(6)+"</td>");
	                pw.println("<td>"+rs.getString(8)+"</td>");
	                pw.println("</tr>");
	            pw.println("</table><br>");
	            pw.println("<table class=\"table\">");
                pw.println("<tr>");
                    pw.println("<th>Pending Tution Fees</th>");
                    pw.println("<th>Paid Tution Fees</th>");
                    if(rs.getString(10)!=null) {
                    pw.println("<th>Pending_"+rs.getString(10)+"</th>");
                    pw.println("<th>Paid_"+ rs.getString(10) +"</th>");}
                pw.println("</tr>");
	            if(rs2.next()) {
	                 pw.println("<tr>");
	                     pw.println("<td>"+rs2.getString(1)+"</td>");
	                     pw.println("<td>"+rs2.getString(2)+"</td>");
	                     if(rs.getString(10)!=null) {
	                     pw.println("<td>"+rs2.getString(3)+"</td>");
	                     pw.println("<td>"+rs2.getString(4)+"</td>");}
	                 pw.println("</tr>");
	            

    		}
	            pw.println("</table><br>");
	            	pw.println("<table class=\"table\">");
	                pw.println("<tr>");
	                pw.println("<th>Paid_Date</th>");
	                pw.println("<th>Amount</th>");
	                pw.println("<th>Fees_Type</th>");
	                pw.println("</tr>");
	            while (rs1.next()) {
	            		 if (rs1.getString(4)==null) {
							continue;
						}  fees_typeint=Integer.parseInt(rs1.getString(4));
	            		 if(fees_typeint==1) {
	            			 fees_typeString="Tution_Fees";
	            		 }
	            		 else if (fees_typeint==2) {
	            			 fees_typeString="Transport_Fees";
						}
	            		 else if (fees_typeint==3) {
	            			 fees_typeString="Hostel_Fees";

						}
	            		 else if (fees_typeint==4) {
	            			 fees_typeString="MISC_Fees";

							
						}
	            		 
	                	 pw.println("<tr>");
	                     pw.println("<td>"+rs1.getString(2).substring(0,10)+"</td>");
	                     pw.println("<td>"+rs1.getString(3)+"</td>");
	                     pw.println("<td>"+fees_typeString+"</td>");
	                     pw.println("</tr>");
	                    
	                   }
	                     pw.println("</table>");
	                     


	                     
	                     
	                     /*
	                      * 
	                      * */
	                     pw.println("</table><br>");
	 	            	pw.println("<table class=\"table\">");
	 	                pw.println("<tr>");
	 	                pw.println("<th>Paid_Date</th>");
	 	                pw.println("<th>Amount</th>");
	 	                pw.println("<th>Fees_Type</th>");
	 	                pw.println("</tr>");
	 	            while (rs3.next()) {
	 	            		 if (rs3.getString(4)==null) {
	 							continue;
	 						}  fees_typeint=Integer.parseInt(rs3.getString(4));
	 	            		 if(fees_typeint==1) {
	 	            			 fees_typeString="Tution_Fees";
	 	            		 }
	 	            		 else if (fees_typeint==2) {
	 	            			 fees_typeString="Transport_Fees";
	 						}
	 	            		 else if (fees_typeint==3) {
	 	            			 fees_typeString="Hostel_Fees";

	 						}
	 	            		 else if (fees_typeint==4) {
	 	            			 fees_typeString="MISC_Fees";

	 							
	 						}
	 	            		 
	 	                	 pw.println("<tr>");
	 	                     pw.println("<td>"+rs3.getString(2).substring(0,10)+"</td>");
	 	                     pw.println("<td>"+rs3.getString(3)+"</td>");
	 	                     pw.println("<td>"+fees_typeString+"</td>");
	 	                     pw.println("</tr>");
	 	                    
	 	                   }
	 	                     pw.println("</table>");
	 	                     

	            		
                    
                   
				
                 
                 

     		} 
	          


	            

            }

           
           
            catch (SQLException e) {
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
