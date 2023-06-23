	package com.servlet.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

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
	String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String username = "root";
	String password ="Time1234";
	private final static String query = "insert into student_details(name,reg_no,dept,year,email,mobile_no,gender,additional_fees_type,fees,additional_fees,scholorship_type) values(?,?,?,?,?,?,?,?,?,?,?)";
	private final static String query1 = "select * from fixed_fees where(batch=?&&dept=?)";
	String hostel_fees,transport_fees,additional_fees_type_string;
	int tution_fees;
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
        System.out.println(name);
        String reg_no = req.getParameter("reg_no");
        String dept = req.getParameter("dept");
        String email = req.getParameter("email");
        String mobile_no = req.getParameter("mobile_no");
        String additional_fees;
        String anString = req.getParameter("chkAdditionalfees");
        System.out.println(anString);
        int additional_fees_type = Integer.parseInt( req.getParameter("chkAdditionalfees"));
        if(additional_fees_type==1) {
        	additional_fees_type_string = "Hostel fees";
        }
        else {
        	additional_fees_type_string = "Transport_fees";
        }
        System.out.println(mobile_no);
        String year = req.getParameter("year");
        String gender = req.getParameter("gender");
        String scholorship_type;
        int scholorship_type1 = Integer.parseInt(req.getParameter("chkScholarship"));
        if(scholorship_type1==1) {
        	scholorship_type="FG";
        }
        else if(scholorship_type1==2) {
        	scholorship_type="PMMS";
        }
        else if(scholorship_type1==3) {
        	scholorship_type="7.5";
        }
        else {
        	scholorship_type="None";
        }
       
        //String scholorship_type =  req.getParameter("chkScholarship");
        String batch = req.getParameter("batch");
       
        
       
        //load the JDBC driver
       try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        //generate the connection
       System.out.println("Working..");
        try(Connection con = DriverManager.getConnection(url,username,password);
                PreparedStatement ps = con.prepareStatement(query);
        		PreparedStatement ps1 = con.prepareStatement(query1);){
            //set the values
            ps.setString(1, name);
            ps.setString(2, reg_no);
            ps.setString(3, dept);
            ps.setString(4, year);
            ps.setString(5, email);
            ps.setString(6, mobile_no);
            ps.setString(7, gender);
            ps.setString(8, additional_fees_type_string);
            ps.setString(11, scholorship_type);
            ps1.setString(1, batch);
            ps1.setString(2, dept);
            ResultSet rs =  ps1.executeQuery();
            if(rs.next()) {
            tution_fees = Integer.parseInt( rs.getString(2));
            hostel_fees = rs.getString(3);
            transport_fees = rs.getString(4);
            }
            if(scholorship_type1==1) {
            	tution_fees-=25000;
            }
            else if (scholorship_type1==2) {
				tution_fees-=50000;
				
			}
            else if (scholorship_type1==3) {
				tution_fees=00;
			}
            	ps.setInt(9, tution_fees);	
            
            if(additional_fees_type==1) {
            	additional_fees=hostel_fees;
            	ps.setString(10, additional_fees);
            }
            else {
            	additional_fees=transport_fees;
            	ps.setString(10, additional_fees);
            }
            int count  = ps.executeUpdate();
            req.setAttribute("fees1", tution_fees);
            req.setAttribute("add_fees1", additional_fees);
           RequestDispatcher dispatcher = req.getRequestDispatcher("updateonfeesdetails");
           


           dispatcher.forward( req, res );
            
            pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
            if(count==1) {
                pw.println("<h2 class='bg-danger text-light text-center'>Student Details Registered Successfully</h2>");
            }else {
                pw.println("<h2 class='bg-danger text-light text-center'>Student Details Not Registered</h2>");
            }
        }catch(SQLException e) {
            e.printStackTrace();

        	/*RequestDispatcher dispatcher = req.getRequestDispatcher("registerpage.jsp");
			req.setAttribute("error", "Register Number Already Exists");
			dispatcher.forward(req, res);
            e.printStackTrace();*/
        }
        catch(Exception e) {

            e.printStackTrace();
        }
        pw.println("<a href='login.jsp'><button class='btn btn-outline-success'>Home</button></a>");
        pw.println("</div>");
        //close the stram
        pw.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req,res);
    }
}

