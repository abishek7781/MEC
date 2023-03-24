<!DOCTYPE html>
<html>
    <head>
        <title>search page</title>
        <style>
        .form .td{
        	display:auto;
        	text-align:right;
        	float:left;
            
        }
        		td{
        		text-align:left;
        		float:center;
                border-radius:5px;
                
                        
             }
            body{
                background-image: url('https://t4.ftcdn.net/jpg/03/07/75/23/360_F_307752385_WJiaMugf2Y6kqHqOM2Js5innds9BssBF.jpg');
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: cover;
                font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
                font-size: 22px;
                font-weight:300px;
                background-repeat: no-repeat;
                }
                .table{
                width: 600px;
                margin-top:-2cm;
                margin-left: auto;
                margin-right: auto;
                text-align:center;
                border-radius: 5px;
                
              
                     
            }
              
            td{
                border:1px solid black;
                padding-left: 3%;
                border-radius: 10%;
            } 
           
            
           
            tr{
                border:1px solid black;
                padding-left: 3%;
                border-radius: 50px;
            }
            .feedetail{
                width: 50%;
                padding-top:-4cm;
            }
            .feedetail{
                text-align: center;
                margin: 12px 10px;
               
                border-radius: 3%;
                padding: 50px;
             
                transition: 0.5s;
                margin-left: auto;
                margin-right: auto;
                border:1px solid black;
            }
            ::placeholder{
                text-align: center;
            }
            .b-val{
                margin: 10px 10px;
                
            }
            img{
                width: 264px;
                height: 87;
                box-shadow: inset 6px 6px 6px #cbced1, inset -6px -6px 6px white;
            }
            .input-box{
                width: 6cm;
                height: .7cm;
                text-align: center;
                border-radius:10px;
            }
            .button{
                font-weight: bold;
                width: 6cm;
                height: .8cm;
                margin-top: .7cm;
                cursor: pointer;
                background-color:white;
                color: black;
                border:none;
                border-radius:10px;
                box-shadow: 0px 0px 2px 2px rgb(185, 183, 183);
            }
            .button :hover{
                background-color:black;
                color:white;
            }
        </style>
    </head>
    <body>
        <img src="https://www.madhaengineeringcollege.com/wp-content/uploads/2022/06/hlogo.png">
        <div class="form">
        <form action="search1" method="post">
            <table class="table">      
                <tr>
                    <td class="l">Name</td>
                    <td class="l">${Name}</td>
                </tr>
                <tr>
                    <td class="l">Reg_no </td>
                    <td class="l">${Reg_no}</td>
                </tr>
                <tr>
                    <td class="l">Dept </td>
                    <td class="l">${Dept}</td>
                </tr>
                <tr>
                    <td class="l">Year </td>
                    <td class="l">${Year}</td>
                </tr>
                <tr>
                    <td class="l">Email </td>
                    <td class="l">${Email}</td>
                </tr>
                <tr>
                    <td class="l">Mobile_no </td>
                    <td class="l">${Mobile_no}</td>
                </tr>
                <tr>
                    <td class="l">Gender </td>
                    <td class="l">${Gender}</td>
                </tr>
                <tr>
                    <td class="l">Tution_Fees </td>
                    <td class="l">${Total_fees}</td>
                </tr>
                
                <tr>
                    <td class="l">Tution_fees_Pending </td>
                    <td class="l">${Pending_fees}</td>
                </tr>
                <tr>
                    <td class="l">Tution_fees_Paid </td>
                    <td class="l">${Paid_fees}</td>
                </tr>
                <tr>
                    <td class="l">${Additional_fees_pending1}</td>
                    <td class="l">${Additional_fees_pending}</td>
                </tr>
                <tr>
                    <td class="l">${Additional_fees_paid1}</td>
                    <td class="l">${Additional_fees_paid}</td>
                </tr>
                <tr>
                    <td class="l">${Additional_fees_type1}</td>
                    <td class="l">${Additional_fees}</td>
                </tr>
                
               
	
	<input type="hidden" value=${Reg_no} name="reg_no4" ><br><br>
	
                </table>
                <div class="feedetail">
                    <input type="radio" name="fees" value=1 required>
                    <label>Tution fees</label>
                    <input type="radio" name="fees" value=2 required>
                    <label>Transport fees</label>
                    <input type="radio" name="fees" value=3 required>
                    <label>Hostel fees</label>
                    <input type="radio" name="fees" value=4 required>
                    <label>MISC fees</label>
                    <br>
                <div class="b-val">
                    <label>Payment Date: </label>
                    <input type="date" name="date" value="" required class="input-box">
                    <br>
                    <label>Enter Amount: </label>
                    <input type="text" name="amount" placeholder="Enter Amount" required class="input-box">
                    <br>
                     <label>Select Year: </label>
                    <input type="radio" name="fees_year" value=1 required>
                    <label>I</label>
                    <input type="radio" name="fees_year" value=2 required>
                    <label>II</label>
                    <input type="radio" name="fees_year" value=3 required>
                    <label>III</label>
                    <input type="radio" name="fees_year" value=4 required>
                    <label>IV</label>
                    <br>
                    <button name="viewdetails" class="button">Submit</button>
                </div>
                </div>    
                
            </table>
        </form>
        </div>
    </body>
</html>