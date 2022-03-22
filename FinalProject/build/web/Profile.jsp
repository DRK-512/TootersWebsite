
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
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" name="uname" href="profile">${message}</a>
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
             <div class="container">
                <%           
                UserFind user = (UserFind) request.getAttribute("user"); 
                %>

                <!-- Display profile pic -->
                <img src="<%out.println(user.getpPic()); %>" alt="NO IMAGE FOUND"  
                style="width:300px;height:300px; display: block; margin-left: auto; margin-right: auto;">
                </br>
                <!-- Display text -->
                <h2>First Name: <%out.print(user.getfName());%></h2> </br>
                <h2>Last Name: <%out.print(user.getlName());%></h2></br>
                <h2>Email: <%out.print(user.getEmail());%></h2></br>
                <h2>Username: <%out.print(user.getUname());%></h2></br>
                <h2>Password: <% int s = user.getPwd().length(); 
                        for(int i=0; i<s; i++){
                            out.print("*"); 
                    }%></h2></br>
                <h2>Biography: <%out.print(user.getBio());%></h2></br>
            </div>
            
            <div class="text-center">
             <a href="editprofile" class="btn btn-primary"  
                style="padding-top: 20px;
                       padding-right: 30px;
                       padding-bottom: 20px;
                       padding-left: 30px;">   
                 <strong><h1>Edit Your Profile</h1></strong>
             </a>
        </div> 
            
            
        </section>
        
    </body>
</html>
