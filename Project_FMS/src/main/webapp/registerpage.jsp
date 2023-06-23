<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
    <title>Registration Page</title>
    <link rel="stylesheet" href="css\bootstrap.css">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    
    
    <style>
        img{
            width: 264px;
            height: 87;
        }
        #frm{
            width: 13cm;
            margin: auto;
            margin-top: -5px;
        }
        .container {
            max-width: 700px;
            width: 100%;
            background-color: #fff;
            padding: 25px 30px;
            border-radius: 5px;
            box-shadow: 0 5px 10px rgba(0,0,0,0.15);
        }
        h2{
            text-align: center;
        }
         .error{
         		margin-top:-6px;
               margin-bottom:16px;
               
            }
    </style>
    </head>
    <body class="container-fluid">
        <img src="https://www.madhaengineeringcollege.com/wp-content/uploads/2022/06/hlogo.png">
        <form action="register" method="post" class="form card" id="frm">
            <h2 class="card-header text-white">Student Registration Form</h2>
                <table class="table table-hover">
                    <tr>
                        <td>Name</td>
                        <i class="bi bi-person"></i>
                        <td><input type="text" name="name" required placeholder="Enter Name"></td>
                    </tr>
                    <tr>
                        <td>Reg No</td>
                        <td><input type="text" name="reg_no" required placeholder="Enter Reg No"></td>
                    </tr>
                    
                    
                    <tr>
                        <td>Dept</td>
                        <td><select style="width: 4.9cm;" name="dept" id="dept" required class="dropbox">
                        <option disabled selected class="input-box">Department</option>
                        <option value="AERO">AERO</option>
                        <option value="BIO-MEDICAL">BIO-MEDICAL</option>
                        <option value="BIO-TECH">BIO-TECH</option>
                        <option value="CIVIL">CIVIL</option>
                        <option value="CSBS">CSBS</option>
                        <option value="CSE">CSE</option>
                        <option value="ECE">ECE</option>
                        <option value="EEE">EEE</option>
                        <option value="IT">IT</option>
                        <option value="MECH">MECH</option>
                        </select></td>
                    </tr>
                    <tr>
                        <td>Year</td>
                        <td>
                            <input type="radio" name="year" value="1" required>
                            <label>I</label>
                            <input type="radio" name="year" value="2" required>
                            <label>II</label>
                            <input type="radio" name="year" value="3" required>
                            <label>III</label>
                            <input type="radio" name="year" value="4" required>
                            <label>IV</label>
                        </td>
                    </tr>
                    <tr>
                        <td>E-Mail</td>
                        <td><input type="text" name="email" required placeholder="Enter Email"></td>
                    </tr>
                    <tr>
                        <td>Mobile No</td>
                        <td><input type="text" name="mobile_no" required placeholder="Enter Mobile"></td>
                    </tr>
                    <tr>
                        <td>Batch</td>
                        <td><input type="text" name="batch" required placeholder="Enter Batch"></td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td>
                            <input type="radio" name="gender" value="Male" required>
                            <label>Male</label>
                            <input type="radio" name="gender" value="Female" required>
                            <label>Female</label>
                        </td>
                    </tr>
                    <tr>
                        <td>Scholarship</td>

                        <td>
                            <label for="chkYes">
                            <input type="radio" id="chkYes" value=1 name="chkScholarship" required>FG</label>
                            <label for="chkNo">
                            <input type="radio" id="chkNo" value=2 name="chkScholarship" required>PMSS</label>
                            <label for="chk_Yes">
                            <input type="radio" id="chk_Yes" value=3 name="chkScholarship" required>7.5</label>
                            <label for="chk__Yes">
                            <input type="radio" id="chk__Yes" value=4 name="chkScholarship" required>None</label>
                        </td>
                    </tr>
                   
                    <tr>
                        <td>Additional fees</td>
                        <td>
                            <label for="chkYes">
                            <input type="radio" id="chkYes" value=1 name="chkAdditionalfees">Hostel Fees</label>
                            <label for="chkYes">
                            <input type="radio" id="chkYes" value=2 name="chkAdditionalfees">Transport Fees</label>
                        </td>
                    </tr>
                    </table>          
                     <k style="color:red; text-align:center;" class="error"  > ${error} </k>
                 <div class="card-footer" id="card_bottom">
                 <k class="footer-button">
                 <button type="reset" class="btn" id="btn3">RESET</button>
                 <button type="submit" class="btn" id="btn2">SUBMIT</button>
                 <div id="but" id="btn3">
                 <a href="accpage.html">HOME</a></div>
                 </k>
            </div>
        </form>
    </body>
</html>