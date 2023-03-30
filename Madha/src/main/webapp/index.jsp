<!DOCTYPE html>
<html>
    <head>
        <title>Page 1</title>
        <link rel="icon" href="asset/img/mec logo.jpg">
        <style>
            .header{
                overflow: hidden;
                background-color: whitesmoke;
                padding-bottom: 10px 3px;
                height: 2.3cm;
            }

            .header a{
                position: relative;
                display: flex;
                float: left;
                color: black;
                text-align: center;
                padding: 12px;
                text-decoration: none;
                font-size: 18px;
                line-height: 18px;
                border-radius: 14px;
            }

            .header a:hover{
                background-color: whitesmoke;
                color: rgb(64, 0, 255);
            }

            .header a.active{
                background-color: whitesmoke;
                color: black;
            }

            .header-right{
                float: right;
                font-family:'Segoe UI','Open Sans', 'Helvetica Neue', sans-serif;
                padding-top: 1.5%;
            }

            .img{
                width: 264px;
                height: 87px;
                padding-left: 8px;
                padding-top: 1px;
            }

            .label{
                color: black;
            }

            button {
                background-color: #000;
                border: .25px solid crimson;
                border-radius: 10px;
                color: #fff;
                padding: 8px;
                height:80px;
                width: 300px;
                font-size: larger;
                
            }

            .button{
                padding-top: 100px;
                text-align: center;
            }
            button:hover{
                color: red;
                background-color: black;
            }
        </style>
    </head>
    <body>

        <!--header-->
        <div class="header">
            <img class="img" src="https://www.madhaengineeringcollege.com/wp-content/uploads/2022/06/hlogo.png">
            <div class="header-right">
              <a href="https://www.madhaengineeringcollege.com/">Home</a>
              <a href="https://www.madhaengineeringcollege.com/contact-us/ 	">Contact</a>
              <a href="https://www.madhaengineeringcollege.com/about-college/">About</a>
            </div>
        </div>
        <div class="button" id="b">
        <a href="home.html"><button href="E:\projects\Madha\webapp\reg.html">REGISTER</button><br><br></a>
        <a href="showdata.html"><button href="#recipts">ENQUIRY</button><br><br></a>
        <a href="search.html"><button href="#payment">PAYMENT</button></a>
        <a href="authorizer"><button href="#payment">Authorize</button></a>
        
        </div>
    </body>
</html>