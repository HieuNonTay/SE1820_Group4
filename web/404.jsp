<%-- 
    Document   : 404
    Created on : Jun 19, 2024, 4:08:41 PM
    Author     : quyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Fables">
        <meta name="author" content="Enterprise Development">
        <link rel="shortcut icon" href="assets/custom/images/shortcut.png">

        <title> 404</title>

        <!-- animate.css-->  
        <link href="assets/vendor/animate.css-master/animate.min.css" rel="stylesheet">
        <!-- Load Screen -->
        <link href="assets/vendor/loadscreen/css/spinkit.css" rel="stylesheet">
        <!-- GOOGLE FONT -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
        <!-- Font Awesome 5 -->
        <link href="assets/vendor/fontawesome/css/fontawesome-all.min.css" rel="stylesheet">
        <!-- Fables Icons -->
        <link href="assets/custom/css/fables-icons.css" rel="stylesheet">
        <!<!--user detail form -->
        <link href="assets/custom/css/user_profile.css" rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"> 
        <link href="assets/vendor/bootstrap/css/bootstrap-4-navbar.css" rel="stylesheet">
        <!-- FANCY BOX -->
        <link href="assets/vendor/fancybox-master/jquery.fancybox.min.css" rel="stylesheet">
        <!-- OWL CAROUSEL  -->
        <link href="assets/vendor/owlcarousel/owl.carousel.min.css" rel="stylesheet">
        <link href="assets/vendor/owlcarousel/owl.theme.default.min.css" rel="stylesheet">
        <!-- Timeline -->
        <link rel="stylesheet" href="assets/vendor/timeline/timeline.css"> 
        <!-- FABLES CUSTOM CSS FILE -->
        <link href="assets/custom/css/custom.css" rel="stylesheet">
        <!-- FABLES CUSTOM CSS RESPONSIVE FILE -->
        <link href="assets/custom/css/custom-responsive.css" rel="stylesheet"> 

    </head>


    <body>
        <!-- Start Header -->
        <jsp:include page="header.jsp"/>
        <!-- Start Breadcrumbs -->
        <div class="fables-header fables-after-overlay">
            <div class="container"> 
                <h2 class="fables-page-title fables-second-border-color">404</h2>
            </div>
        </div>  
        <!-- Start Breadcrumbs -->
        <div class="fables-light-background-color">
            <div class="container"> 
                <nav aria-label="breadcrumb">
                    <ol class="fables-breadcrumb breadcrumb px-0 py-3">
                        <li class="breadcrumb-item"><a href="home" class="fables-second-text-color">Home</a></li>
                        <li class="breadcrumb-item active" aria-current="page">404</li>
                    </ol>
                </nav> 
            </div>
        </div>
        <!-- /End Breadcrumbs -->
        <!-- Start page content -->
        <div class="container">
            <div class="row">
                <div class="col-12 col-lg-6 offset-lg-3">
                    <div class="text-center my-4 my-lg-5 py-4 py-lg-5">
                        <h1 class="fables-second-text-color font-250 font-weight-bold"> 404 </h1>
                        <h3 class="font-30 font-weight-bold fables-second-text-color">Nothing was found!</h3>
                        <p class="font-20 fables-fifth-text-color my-2">We cannot seem to find the page that you are looking for.</p>
                        <a href="home" class="btn fables-second-border-color fables-btn-rounded fables-background-link font-20 white-color px-5 py-2 mt-4">Back To Home</a>
                    </div>
                </div>
            </div>

        </div>

        <!-- /End page content -->


        <jsp:include page="footer.jsp"/>

        <script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
        <script src="assets/vendor/timeline/jquery.timelify.js"></script>
        <script src="assets/vendor/loadscreen/js/ju-loading-screen.js"></script>
        <script src="assets/vendor/jquery-circle-progress/circle-progress.min.js"></script>
        <script src="assets/vendor/popper/popper.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap-4-navbar.js"></script>
        <script src="assets/vendor/owlcarousel/owl.carousel.min.js"></script> 
        <script src="assets/vendor/fancybox-master/jquery.fancybox.min.js"></script>
        <script src="assets/vendor/video-background/jquery.mb.YTPlayer.js"></script>
        <script src="assets/vendor/WOW-master/dist/wow.min.js"></script>
        <script src="assets/custom/js/custom.js"></script>
        <script>
            function setFormAction(actionUrl) {
                document.getElementById('myForm').action = actionUrl;
            }
        </script>

    </body>
</html>
