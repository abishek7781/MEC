package com.servlet.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class search extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    String search_query = "select * from student_details where reg_no=?";
    String pending_fees_queryString = "select * from fees_details1 where(reg_no=?&&fees_year=?)";
    String nameString;
    String reg_noString;
    String deptString;
    String yearString;
    String emailString;
    String mobile_noString;
    String genderString;
    String feesString;
    String pending_feeString,additional_fees,additional_fees_type;
    
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
        try(Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student","root","Time1234");
            Connection con1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student","root","Time1234");
                PreparedStatement ps = con.prepareStatement(search_query);
        		PreparedStatement ps1 = con1.prepareStatement(pending_fees_queryString);){
            //resultSet
        	ps.setString(1, reg_no);
        	ps1.setString(1, reg_no);
        	ps1.setString(2, fees_year);
            ResultSet rs = ps.executeQuery();
            ResultSet rs1 = ps1.executeQuery();
            RequestDispatcher dispatcher = req.getRequestDispatcher("search.jsp");
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
            	

            }
            if(rs1.next()) {
            	pending_feeString=rs1.getString(1);
                req.setAttribute("Paid_fees", rs1.getString(5));
                req.setAttribute("Pending_fees", rs1.getString(6));
                req.setAttribute("Total_fees", feesString);

            }
            req.setAttribute("Name",nameString);
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
            req.setAttribute("Additional_fees_pending1",additional_fees_type+"_Pending ");
            req.setAttribute("Additional_fees_paid1",additional_fees_type+"_Paid");}	
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

