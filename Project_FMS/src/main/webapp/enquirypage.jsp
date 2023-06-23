<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
    <title>Madha</title>
    <link rel="stylesheet" href="css\enquirypage.css">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <style>
        img{
            width: 264px;
            height: 87;
        }
        #frm{
            width: 13cm;
            margin: auto;
            margin-top: 4cm;
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
    <body class="container-fluid">
        <img src="https://www.madhaengineeringcollege.com/wp-content/uploads/2022/06/hlogo.png">
        <k class="footer-button">
</k>
        <form action="showdetails" method="post" class="form card" id="frm">
            <h2 class="card-header text-white">View Student Details</h2>
                <table class="table table-hover">
                    
                    <tr>
                        <td>Reg No</td>
                        <td><input type="text" name="reg_no2" required placeholder="Enter Reg No" pattern="[0-9]{12}" oninput= "javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" minlength="12" maxlength="12"></td>
                    </tr>
                        <td>Year</td>
                        <td>
                            <input type="radio" name="fees_year" value="1" required>
                            <label>I</label>
                            <input type="radio" name="fees_year" value="2" required>
                            <label>II</label>
                            <input type="radio" name="fees_year" value="3" required>
                            <label>III</label>
                            <input type="radio" name="fees_year" value="4" required>
                            <label>IV</label>
                        </td>
                    </tr>
                    
                    </table>
                    </div>
                    	<a style='text-align:center; color:red;'>${error}</a>
                    	<k class="footer-button">
                        <button type="submit" class="btn" id="btn2">SUBMIT</button>
                        <a type="button" class="btn" id="btn3" href="accpage.html">HOME</a>
                        </k>
            
        </form>
    </body>
</html>