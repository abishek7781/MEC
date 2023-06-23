package com.servlet.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class payment_entry extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    String search_query = "select * from student_details where reg_no=?";
    String pending_fees_queryString = "select * from fees_details1 where(reg_no=?&&fees_year=?)";
    String pending_fees_query1 = "select pending_fees from fees_details1 where(reg_no=?&&fees_year=?)";
    String pending_fees_query2 = "select pending_fees from fees_details1 where(reg_no=?&&fees_year=?)";
    String pending_fees_query3 = "select pending_fees from fees_details1 where(reg_no=?&&fees_year=?)";
    String pending_fees_query4 = "select pending_fees from fees_details1 where(reg_no=?&&fees_year=?)";

    String nameString;
    String reg_noString;
    String deptString;
    String yearString;
    String emailString;
    String mobile_noString;
    String genderString;
    String feesString;
    String pending_feeString,additional_fees,additional_fees_type,pending1,pending2,pending3,pending4;
	String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
    	
        PrintWriter pw = res.getWriter();
        //set content type
        res.setContentType("text/html");
        //link the bootstrap
        pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
        String reg_no =req.getParameter("reg_no4");
        String fees_year =req.getParameter("fees_year");
        System.out.println(reg_no);
        System.out.println(fees_year);

        //load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e) {
            e.printStackTrace();
        }
        //generate the connection
        try(Connection con = DriverManager.getConnection(url,"root","Time1234");
            Connection con1 = DriverManager.getConnection(url,"root","Time1234");
                PreparedStatement ps = con.prepareStatement(search_query);
        		PreparedStatement ps1 = con1.prepareStatement(pending_fees_queryString);
        		PreparedStatement ps21 = con.prepareStatement(pending_fees_query1);
        		PreparedStatement ps22 = con.prepareStatement(pending_fees_query2);
        		PreparedStatement ps23 = con.prepareStatement(pending_fees_query3);
        		PreparedStatement ps24 = con.prepareStatement(pending_fees_query4);){
            //resultSet
        	ps.setString(1, reg_no);
        	ps1.setString(1, reg_no);
        	ps1.setString(2, fees_year);
        	ps21.setString(1,reg_no );
        	ps21.setString(2,"1" );
        	ps22.setString(1,reg_no );
        	ps22.setString(2,"2" );
        	ps23.setString(1,reg_no );
        	ps23.setString(2,"3" );
        	ps24.setString(1,reg_no );
        	ps24.setString(2,"4" );

            ResultSet rs = ps.executeQuery();
            ResultSet rs1 = ps1.executeQuery();
            ResultSet rs21 = ps21.executeQuery();
            ResultSet rs22 = ps22.executeQuery();
            ResultSet rs23 = ps23.executeQuery();
            ResultSet rs24 = ps24.executeQuery();


            RequestDispatcher dispatcher = req.getRequestDispatcher("summa");
            if(rs.next()) {
            	nameString= rs.getString(1);
            	reg_noString=rs.getString(2);
            	deptString=rs.getString(3);
            	yearString=rs.getString(4);
            	emailString=rs.getString(5);
            	mobile_noString=rs.getString(6);
            	genderString=rs.getString(7);
            	feesString=rs.getString(8);  
            	additional_fees=rs.getString(9);
            	additional_fees_type=rs.getString(10);
            	System.out.println(nameString);
            	

            }
            if(rs1.next()) {
            	pending_feeString=rs1.getString(1);
                req.setAttribute("Paid_fees", rs1.getString(5));
                req.setAttribute("Pending_fees", rs1.getString(6));
                req.setAttribute("Total_fees", feesString);
                System.out.println(pending_feeString);
            }
            if(rs21.next()&&rs22.next()&&rs23.next()&&rs24.next()) {
            	pending1=rs21.getString(1);
            	pending2=rs22.getString(1);
            	pending3=rs23.getString(1);
            	pending4=rs24.getString(1);
            	System.out.println(pending1);
            	System.out.println(pending2+"two");
            	System.out.println(pending3+"twoo");
            	System.out.println(pending4+"twooo");

            	
            }
            req.setAttribute("Name",nameString);
            req.setAttribute("pending1",pending1);
            req.setAttribute("pending2",pending2);
            req.setAttribute("pending3",pending3);
            req.setAttribute("pending4",pending4);

            req.setAttribute("Reg_no", reg_noString);
            req.setAttribute("Dept", deptString);
            req.setAttribute("Year", yearString);
            req.setAttribute("Email", emailString);
            req.setAttribute("Mobile_no", mobile_noString);
            req.setAttribute("Gender", genderString);
            req.setAttribute("Fees", feesString);
            if(additional_fees_type!=null) {
            req.setAttribute("Additional_fees",additional_fees);
            req.setAttribute("Additional_fees_type",additional_fees_type);
            req.setAttribute("Additional_fees_pending",rs1.getString(9));
            req.setAttribute("Additional_fees_paid",rs1.getString(8));
            req.setAttribute("Additional_fees_type1",additional_fees_type+" ");
            req.setAttribute("Additional_fees_pending1",additional_fees_type+" Pending ");
            req.setAttribute("Additional_fees_paid1",additional_fees_type+" Paid");}	
            else {
            	if(additional_fees_type!=null) {
                    req.setAttribute("Additional_fees",additional_fees);
                    req.setAttribute("Additional_fees_type",additional_fees_type);
                    req.setAttribute("Additional_fees_pending",rs1.getString(9));
                    req.setAttribute("Additional_fees_paid",rs1.getString(8));
			}

            }


            
            
            
            // set your String value in the attribute
            dispatcher.forward( req, res );
            
              }catch(SQLException se) {
            pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
       
        pw.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req,res);
    }
}

