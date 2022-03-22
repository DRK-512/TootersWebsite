
<%@page import="edu.kettering.UserFind"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Tooters - Freelanced Teachers</title>
        <!-- Font Awesome icons (free version)-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet">
        <!-- This is the css file that we wrote ourselves -->
      
        <!-- Fonts CSS-->
        <link rel="stylesheet" href="css/heading.css">
        <link rel="stylesheet" href="css/body.css">

    </head>
    <body id="page-top">
       <nav class="navbar navbar-expand-lg bg-secondary fixed-top" id="mainNav">
            <div class="container"><a class="navbar-brand js-scroll-trigger" href="userhome">TOOTERS</a>
                <button class="navbar-toggler navbar-toggler-right font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">Menu <i class="fas fa-bars"></i></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" name="uname" href="profile">${userName}</a>
                        </li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="home">LOGOUT</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <section class="page-section portfolio" id="portfolio">
            <div class="container">
                <!-- Portfolio Section Heading-->
                <div class="text-center">
                    </br>
                    </br>
                    <h2 class="page-section-heading text-secondary mb-0 d-inline-block">My Profile</h2>
                </div>
                <!-- Icon Divider-->
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
            </div>
            
            <form class="form" id="editAccount" method="post" style="display:flex;
                flex-direction:column;
                align-items:center;
                justify-items:center">
             <div class="container">
                <%           
                UserFind user = (UserFind) request.getAttribute("user"); 
                %>

                <!-- Display profile pic -->
                <img src="<%out.println(user.getpPic()); %>" alt="NO IMAGE FOUND"  
                style="width:300px;height:300px; display: block; margin-left: auto; margin-right: auto;">
                </br>
                
               
                    <!-- Display text -->
                    <h3>
                    <label for="fname">First name:</label>
                    <input style="box-sizing: border-box;" type="text" id="fname" name="fname" value="<%out.print(user.getfName());%>"required><br><br>
                    </h3>

                    <h3>
                    <label for="lname">Last name:</label>
                    <input style="box-sizing: border-box;" type="text" id="lname" name="lname" value="<%out.print(user.getlName());%>"required><br><br>
                    </h3>

                    <h3>
                    <label for="email">Email Address:</label>
                    <input style="box-sizing: border-box;" type="text" id="email" name="email" value="<%out.print(user.getEmail());%>"required><br><br>
                    </h3>

                    <h3>
                    <label for="uname">Username:</label>
                    <input style="box-sizing: border-box;" type="text" id="uname" name="uname" value="<%out.print(user.getUname());%>"required><br><br>
                    </h3>

                    <h3>
                    <label for="pwd">Password:</label>
                    <input style="box-sizing: border-box;" type="password" id="pwd" name="pwd" value="<%out.print(user.getPwd());%>"required><br><br>
                    <label for="cpwd">Confirm Password:</label>
                    <input style="box-sizing: border-box;" type="password" id="cpwd" name="cpwd" value="<%out.print(user.getPwd());%>"required><br><br>  
                    </h3>

                    <h3 style="text-align: center; ">
                        <label for="bio">Biography:</label></br>
                    <textarea id="bio" name="bio" rows="4" cols="50" style="font-size: 25px;"required><%out.print(user.getBio());%></textarea>
                    
                    <br><br> 
                    </h3>
                
            </div>
                    

                    
           <button class="btn btn-primary" type="submit" 
                    style="padding-top: 20px;
                       padding-right: 30px;
                       padding-bottom: 20px;
                       padding-left: 30px;
                       font-size: 40px; 
                       font-family: 'sans-serif'"
                       ><strong>Update Profile</strong></button>
         
            </form>
            
                         
                   
        </section>
        
    </body>
</html>
