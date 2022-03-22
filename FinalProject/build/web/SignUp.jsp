



<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
        <!-- This is the css file that we wrote ourselves -->
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet">
        
        <!-- Fonts CSS-->
        <link rel="stylesheet" href="css/heading.css">
        <link rel="stylesheet" href="css/body.css">
        
      
        
    </head>
    <body id="page-top"style="height:1000px;">
        <nav class="navbar navbar-expand-lg bg-secondary fixed-top" id="mainNav">
            <div class="container"><a class="navbar-brand js-scroll-trigger" href="home">TOOTERS</a>
                <button class="navbar-toggler navbar-toggler-right font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">Menu <i class="fas fa-bars"></i></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="login">LOGIN</a>
                        </li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="signup">SIGN UP</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <!--<body style="background-color:#61a9f2;">-->
        <style>
            body {background-image: url(assets/img/Background.jpg);}
        </style>
        
        <div class="loginContainer"> 
              <!-- METHOD POST IS VITAL SO WE DONT SHOW PARAMETERS IN URL!!!!!!!!! -->
            <form class="form" id="createAccount" method="post">
                
                <img src="assets/img/BlueNWhiteTootokSmall.png" alt="Tooto"/>

                <h1 class="form__title">Create Account</h1>
                <div class="form__message form__message--error">${message}</div>
                <div class="form__input-group">
                    <input type="text" class="form__input" autofocus placeholder="First Name" name="fname"required>
                    <div class="form__input-error-message"></div>
                </div>
                <div class="form__input-group">
                    <input type="text" class="form__input" autofocus placeholder="Last Name" name="lname"required>
                    <div class="form__input-error-message"></div>
                </div>
                <div class="form__message form__message--error"></div>
                <div class="form__input-group">
                    <input type="text" class="form__input" autofocus placeholder="Username" name="uname"required>
                    <div class="form__input-error-message"></div>
                </div>
                <div class="form__input-group">
                    <input type="email" class="form__input" autofocus placeholder="Email Address" name="email"required>
                    <div class="form__input-error-message"></div>
                </div>
                <div class="form__input-group">
                    <input type="password" class="form__input" autofocus placeholder="Password" name="pwd"required>
                    <div class="form__input-error-message"></div>
                </div>
                <div class="form__input-group">
                    <input type="password" class="form__input" autofocus placeholder="Confirm password" name="cpwd"required>
                    <div class="form__input-error-message"></div>
                </div>
                <button class="form__button" type="submit">Continue</button>
                <p></p>
                <p class="form__text">
                    <a class="form__link" href="login" id="linkLogin">Already have an account? Sign in</a>
                </p>
            </form>
        </div>


    </body>
</html>
