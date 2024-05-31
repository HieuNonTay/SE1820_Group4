<%-- 
    Document   : headerShoesShop
    Created on : 31 thg 5, 2024, 13:35:16
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Fables">
        <meta name="author" content="Enterprise Development">
        <link rel="shortcut icon" href="assets/custom/images/shortcut.png">

        <title> Home </title>

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
        <!-- Bootstrap CSS --> 
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap/css/bootstrap-4-navbar.css" rel="stylesheet">
        <!-- portfolio filter gallery -->
        <link href="assets/vendor/portfolio-filter-gallery/portfolio-filter-gallery.css" rel="stylesheet">
        <!-- Video Background -->
        <link href="assets/vendor/video-background/video-background.css" rel="stylesheet"> 
        <!-- FANCY BOX -->
        <link href="assets/vendor/fancybox-master/jquery.fancybox.min.css" rel="stylesheet"> 
        <!-- RANGE SLIDER -->
        <link href="assets/vendor/range-slider/range-slider.css" rel="stylesheet">
        <!-- OWL CAROUSEL  --> 
        <link href="assets/vendor/owlcarousel/owl.carousel.min.css" rel="stylesheet">
        <link href="assets/vendor/owlcarousel/owl.theme.default.min.css" rel="stylesheet">
        <!-- FABLES CUSTOM CSS FILE -->
        <link href="assets/custom/css/custom.css" rel="stylesheet">
        <!-- FABLES CUSTOM CSS RESPONSIVE FILE -->
        <link href="assets/custom/css/custom-responsive.css" rel="stylesheet">
    </head>


    <body>

        <!-- Start Top Header -->
        <div class="search-section">
            <a class="close-search" href="#"></a>
            <div class="d-flex justify-content-center align-items-center h-100">
                <form method="post" action="#" class="w-50">
                    <div class="row">
                        <div class="col-10">
                            <input type="search" value="" class="form-control palce bg-transparent border-0 search-input" placeholder="Search Here ..." /> 
                        </div>
                        <div class="col-2 mt-3">
                            <button type="submit" class="btn bg-transparent text-white"> <i class="fas fa-search"></i> </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <!-- Start Fables Navigation -->
        <div class="fables-navigation fables-main-background-color py-3 py-lg-0">
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-10 col-lg-9 pr-md-0">                       
                        <nav class="navbar navbar-expand-md btco-hover-menu py-lg-2">

                            <a class="navbar-brand pl-0" href="home"><img src="assets/custom/images/Logo-header1.jpg" alt="Fables Template" class="fables-logo"></a>
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#fablesNavDropdown" aria-controls="fablesNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="fables-iconmenu-icon text-white font-16"></span>
                            </button>
                            <div class="collapse navbar-collapse" id="fablesNavDropdown"> 

                                <ul class="navbar-nav mx-auto fables-nav">   
                                    <li class="nav-item">
                                        <a class="nav-link" href="home" id="sub-nav1"  aria-haspopup="true" aria-expanded="false">
                                            Home
                                        </a>
                                    </li>


                                    <li class="nav-item">
                                        <a class="nav-link" href="about.html" id="sub-nav3"  aria-haspopup="true" aria-expanded="false">
                                            About
                                        </a>

                                    <li class="nav-item">
                                        <a class="nav-link" href="store_grid_list.html" id="sub-nav4" aria-haspopup="true" aria-expanded="false">
                                            Store
                                        </a>                                      
                                    </li>

                                    <li class="nav-item">
                                        <a class="nav-link" href="contactus1.html" id="sub-nav7" aria-haspopup="true" aria-expanded="false">
                                            Contact Us
                                        </a>
                                    </li>  
                                </ul> 
                            </div>
                        </nav>
                    </div>
                    <div class="col-12 col-md-2 col-lg-3 pr-md-0 icons-header-mobile">

                        <div class="fables-header-icons">
                            <div class="dropdown"> 
                                <a href="#_" class="fables-third-text-color dropdown-toggle right px-3 px-md-2 px-lg-4 fables-second-hover-color top-header-link max-line-height position-relative" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="fables-iconcart-icon font-20"></span>
                                    <span class="fables-cart-number fables-second-background-color text-center">3</span>
                                </a>

                                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <div class="p-3 cart-block">
                                        <p class="fables-second-text-color semi-font mb-4 font-17">(2) Items in my cart</p>
                                        <div class="row mx-0 mb-3">
                                            <div class="col-4 p-0">
                                                <a href="#"><img src="assets/custom/images/sml1.jpg" alt="" class="w-100"></a>
                                            </div>
                                            <div class="col-8">
                                                <h2><a href="#" class="fables-main-text-color font-13 d-block fables-main-hover-color">LUIS LEATHER DRIVING</a></h2>
                                                <p class="fables-second-text-color font-weight-bold">$ 100.00</p>
                                                <p class="fables-forth-text-color">QTY : 1</p>
                                            </div>
                                        </div>
                                        <div class="row mx-0 mb-3">
                                            <div class="col-4 p-0">
                                                <a href="#"><img src="assets/custom/images/sml1.jpg" alt="" class="w-100"></a>
                                            </div>
                                            <div class="col-8">
                                                <h2><a href="#" class="fables-main-text-color font-13 d-block fables-main-hover-color">LUIS LEATHER DRIVING</a></h2>
                                                <p class="fables-second-text-color font-weight-bold">$ 100.00</p>
                                                <p class="fables-forth-text-color">QTY : 1</p>
                                            </div>
                                        </div>
                                        <span class="font-16 semi-font fables-main-text-color">TOTAL</span>
                                        <span class="font-14 semi-font fables-second-text-color float-right">$200.00</span>
                                        <hr>
                                        <div class="text-center">
                                            <a href="#" class="fables-second-background-color fables-btn-rounded  text-center white-color py-2 px-3 font-14 bg-hover-transparent border fables-second-border-color fables-second-hover-color">View my cart</a> 
                                            <a href="#" class="fables-second-text-color border fables-second-border-color fables-btn-rounded text-center white-color p-2 px-4 font-14 fables-second-hover-background-color">Checkout</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <a href="#" class="open-search fables-third-text-color right  top-header-link px-3 px-md-2 px-lg-4 fables-second-hover-color border-0 max-line-height">
                                <span class="fables-iconsearch-icon"></span>
                            </a>
                            <a href="signIn.jsp" class="fables-third-text-color fables-second-hover-color font-13 top-header-link px-3 px-md-2 px-lg-4 max-line-height"><span class="fables-iconuser"></span></a>

                        </div>
                    </div>
                </div>
            </div>
        </div>     
        <div class="fables-header fables-after-overlay">
            <div class="container"> 
                <h2 class="fables-page-title fables-second-border-color">Home</h2>
            </div>
        </div> 
        <!-- /End Header -->
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
        </script>
    </body>
</html>

