
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.ResultSet, entity.*, dao.*, java.util.*"%>
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

        <jsp:include page="header.jsp"/>
        <div class="fables-header fables-after-overlay">
            <div class="container"> 
                <h2 class="fables-page-title fables-second-border-color">Home Page</h2>
            </div>
        </div>

        <!-- Start page content --> 

        <div class="container">
            <div class="row my-4 my-md-5">
                <div class="col-12 col-md-8 col-lg-9"> 
                    <div class="row">
                        <%
                                            Vector<Product> listProduct = (Vector<Product>) request.getAttribute("listProduct");
                                            for (Product product : listProduct) {
                                                BrandDAO brandDao = new BrandDAO();
                                                Brand brand = brandDao.getById(product.getBrandId());
                        %>
                        <div class="col-12 col-sm-6 col-lg-4 fables-product-block">
                            <div class="card rounded-0 mb-4">
                                <div class="row">
                                    <div class="fables-product-img col-12">
                                        <img class="card-img-top rounded-0" src="assets/custom/images/product1.jpg" alt="dress fashion">
                                        <div class="fables-img-overlay">                                          
                                            <ul class="nav fables-product-btns">
                                                <li><a href="" class="fables-product-btn"><span class="fables-iconeye"></span></a></li>
                                                <li><a href="" class="fables-product-btn"><span class="fables-iconcompare"></span></a></li>
                                                <li><button class="fables-product-btn"><span class="fables-iconheart"></span></button></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="card-body col-12">
                                        <h5 class="card-title mx-xl-3">
                                            <a href="detail?action=productdetail&product_id=<%=product.getProductId()%>" class="fables-main-text-color fables-store-product-title fables-second-hover-color"><%=product.getName()%></a>
                                        </h5>
                                        <p class="store-card-text fables-fifth-text-color font-15 mx-xl-3">DOUBLE</p>
                                        <p class="font-15 font-weight-bold fables-second-text-color my-2 mx-xl-3"><%=product.getPrice()%></p>
                                        <p class="fables-product-info">
                                            <a href="CartURL?service=addToCart&id=<%=product.getProductId()%>" class="btn fables-second-border-color fables-second-text-color fables-btn-rouned fables-hover-btn-color font-14 p-2 px-2 px-xl-4">
                                                <span class="fables-iconcart"></span> 
                                                <span class="fables-btn-value">ADD TO CART</span></a></p>
                                    </div>
                                </div>
                            </div>
                        </div>  
                        <%}%>
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
        </script>
    </body>
</html>