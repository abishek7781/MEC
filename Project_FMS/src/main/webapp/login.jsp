<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
    
        <link rel="stylesheet" href="css/student_login.css">
        <title>Login Page</title>
        <style>
            .error{
               margin:auto;
               margin-top:-22px;
               
            }
            img{
				width: 264px;
				height: 87px;
			}
			#frm{
				width: 13cm;
				margin: auto;
				margin-top: 100px;
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
        </style>
    </head>
    <body class="container-fluid" onload="alertUser()">
        <img src="https://www.madhaengineeringcollege.com/wp-content/uploads/2022/06/hlogo.png" alter='Madha engine'>
            <form action="login" method="post" class="form card" id="frm" >
                <h2 class="card-header text-white">Login Page</h2>
                <table class="table table-hover">
                    <tr>
                        <td class="td">Username</td>
                        <td class="td"><input type="text" name="username" placeholder="Enter Username"></td>
                    </tr>
                    <tr>
                        <td class="td">Password</td>
                        <td class="td"><input type="Password" name="password" placeholder="Enter Password"></td>
                    </tr>
                    <tr>
                        <td>Role</td>
                        <td><select style="width: 4.9cm;" name="roll" id="Roll"  class="dropbox"required>
                        <option value="">Select Role</option>
                        <option value="accountant">ACCOUNTANT</option>
                        <option value="admin">AUTHORIZER</option>
                        <option value="higher">HIGHER OFFICIAL</option>
                        <option value="student">STUDENT</option>
                        </select></td>
                    </tr>
                                                        </table>
                    
                    <a style="color:red;" class="error"  > ${error} </a>
                    
                    <tr>
                        <td>
                            <button type="submit" class="btn" id="btn1">Login</button>
                        </td>
                       
                    </tr>
                    <tr>
                        <td>
                            <abi>New User ?<a href="student_registeration.html">Sign Up</a></abi>
                            
	
            </form>
            
    </body>
</html>