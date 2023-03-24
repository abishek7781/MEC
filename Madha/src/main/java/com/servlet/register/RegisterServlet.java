package com.servlet.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String url = "jdbc:mysql://127.0.0.1:3306/student";
	String username = "root";
	String password ="Time1234";
	private final static String query = "insert into student_details(name,reg_no,dept,year,email,mobile_no,gender,fees,additional_fees,additional_fees_type,scholorship_type) values(?,?,?,?,?,?,?,?,?,?,?)";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        //set content type
        res.setContentType("text/html");
        //link the bootstrap
        pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
        //get the values
        String name = req.getParameter("name");
        String reg_no = req.getParameter("reg_no");
        String dept = req.getParameter("dept");
        String email = req.getParameter("email");
        String mobile_no = req.getParameter("mobile_no");
        String additional_fees = req.getParameter("add_fees");
        String additional_fees_type = req.getParameter("chkAdditionalfees");
        System.out.println(mobile_no);
        String year = req.getParameter("year");
        String gender = req.getParameter("gender");
        String fees = req.getParameter("fees"); 
        String scholorship_type =req.getParameter("chkScholarship");
        
        //load the JDBC driver
       try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        //generate the connection
       System.out.println("Working..");
        try(Connection con = DriverManager.getConnection(url,username,password);
                PreparedStatement ps = con.prepareStatement(query);){
            //set the values
            ps.setString(1, name);
            ps.setString(2, reg_no);
            ps.setString(3, dept);
            ps.setString(4, year);
            ps.setString(5, email);
            ps.setString(6, mobile_no);
            ps.setString(7, gender);
            ps.setString(8, fees);
            ps.setString(9, additional_fees);
            ps.setString(10, additional_fees_type);
            ps.setString(11, scholorship_type);

            

            

            //execute the query
            int count = ps.executeUpdate();
           RequestDispatcher dispatcher = req.getRequestDispatcher("updateonfeesdetails");
            System.out.println("Working111..");

           dispatcher.forward( req, res );
            
            pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
            if(count==1) {
                pw.println("<h2 class='bg-danger text-light text-center'>Student Details Registered Successfully</h2>");
            }else {
                pw.println("<h2 class='bg-danger text-light text-center'>Student Details Not Registered</h2>");
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

