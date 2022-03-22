<%@page import="java.util.ArrayList"%>
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
            <div class="container"><a class="navbar-brand js-scroll-trigger" href="userhome"> TOOTERS</a>
                <button class="navbar-toggler navbar-toggler-right font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">Menu <i class="fas fa-bars"></i></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" name="uname" href="profile">${message}</a>
                        </li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="logout">LOGOUT</a>
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
                    <h2 class="page-section-heading text-secondary mb-0 d-inline-block">Meet Our Tooters!</h2>
                </div>
                <!-- Icon Divider-->
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                
                
                <div class="container">
                 <table style="margin-left: auto;
                    margin-right: auto;" border="I">
                    <thread>
                        <tr style="text-align:  center;">
                            <th style="padding: 20px;">Profile Pic</th>
                            <th style="padding: 20px 30px 20px 30px;">Name</th>
                            <th style="padding: 20px 100px 20px 100px;">Email Address</th>
                            <th style="padding: 20px 30px 20px 30px;">Biography</th>
                        </tr>        
                    </thread>
                    <tbody>
                        <%
                            int i=1; 
                            ArrayList<UserFind> list = (ArrayList<UserFind>) request.getAttribute("list"); 
                        %>
                        
                        <%
                            for (UserFind u : list){
                        %>
                        <tr>
                            <%i++;%>
                            <td><img src="<%out.println(u.getpPic()); %>" alt="<%out.println(u.getfName() + " " + u.getlName());%>"  
                                     style="width:150px;height:150px; align-items: center; margin-left: auto; margin-right: auto;"></td>
                            <td><h4 style="text-align: center;"><%out.println(u.getfName() + " " + u.getlName());%></h4></td>
                            <td><h6 style="text-align: center;"><%out.println(u.getEmail()); %></h6></td>
                            <td><h10 style="text-align: center;"><%out.println(u.getBio()); %></h10></td>
                            
                        </tr>
                        <%}%>
                    </tbody>
                </table>
        
            </div>
        </section>
        

    </body>
</html>
