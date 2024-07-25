
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.ResultSet, entity.*, dao.*, java.util.*"%>
<%@ page import="java.text.DecimalFormat" %>
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
        <!-- News section -->
        <!-- News section -->
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h2 class="font-35 font-weight-bold fables-main-text-color my-3 my-lg-5 my-md-4 text-center">Featured News</h2>
                </div>
                <%
                    List<News> listNews = (List<News>) request.getAttribute("listNews");
                    for (News news : listNews) {
                %>
                <div class="col-12 col-md-4 mb-4 mb-lg-5 wow fadeIn" data-wow-delay=".3s">
                    <div class="position-relative"> 
                        <div class="image-container translate-effect-right">
                            <a href="newsUserDetail?title=<%=news.getTitle().toLowerCase().replaceAll(" ", "-").replaceAll("[^a-z0-9-]", "")%>">
                                <img height="300" width="300" src="<%=news.getImage()%>"  alt="News" class="img-fluid w-100">
                            </a>
                        </div> 
                        <a href="newsUserDetail?title=<%=news.getTitle().toLowerCase().replaceAll(" ", "-").replaceAll("[^a-z0-9-]", "")%>" class="fables-main-text-color fables-second-hover-color"><%=news.getTitle()%></a>
                        <p class="fables-forth-text-color font-14 mb-2">
                            <!-- Your news content here -->
                        </p>
                    </div> 
                </div>
                <%}%>  
            </div>
        </div>



        <div class="container py-3 py-lg-5">
            <div class="fables-team my-3">             
                <h3 class="fables-second-text-color mb-5 font-weight-bold"> Top 5 Product Sales </h3>

                <div class="row">
                    <%
                        Vector<Product> listProductSold = (Vector<Product>) request.getAttribute("listProductSold");
                            for (Product product : listProductSold) {
                                BrandDAO brandDao = new BrandDAO();
                                Brand brand = brandDao.getById(product.getBrandId());
                                ProductDAO productDao = new ProductDAO();
                                String image = productDao.getImage(product.getProductId());
                                DecimalFormat formatter = new DecimalFormat("#,###");
                                String formattedPrice = formatter.format(product.getPrice());
                    %>
                    <div class="col-6 col-md-3 mb-4 mb-lg-5">
                        <div class="card fables-team-block fables-second-hover-text-color fables-team-border fables-second-border-color">
                            <div class="image-container shine-effect">
                                <a href="#"><img class="w-100" src="<%=image%>" height="200" width="200" alt="Card image cap"></a> 
                            </div>

                            <div class="card-body">
                                <h5><a href="detail?action=productdetail&product_id=<%=product.getProductId()%>" class="font-20 semi-font fables-forth-text-color fables-second-hover-color team-name"><%=product.getName()%></a></h5>
                                <p class="store-card-text fables-fifth-text-color font-15 mx-xl-3"><%=brand.getBrandName()%></p>
                            </div>
                            <p class="font-15 font-weight-bold fables-second-text-color my-2 mx-xl-3"><%=formattedPrice%> VND</p>
                            <p class="fables-product-info">
                                <a href="CartURL?service=addToCart&id=<%=product.getProductId()%>" class="btn fables-second-border-color fables-second-text-color fables-btn-rouned fables-hover-btn-color font-14 p-2 px-2 px-xl-4">
                                    <span class="fables-iconcart"></span> 
                                    <span class="fables-btn-value">ADD TO CART</span></a>
                            </p>
                        </div>
                    </div>
                    <%}%>
                </div>   
            </div>  
        </div>



        <div class="container my-4 my-lg-5"> 
            <div class="row">
                <div class="col-12 col-md-8 offset-md-2">
                    <div class="text-center">
                        <h2 class="fables-main-text-color font-35 font-weight-bold mt-0 mb-4 ">Top New Product</h2>
                        <p class="fables-forth-text-color mb-5">
                            All new products will update every time
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <%
                        Vector<Product> listProductNew = (Vector<Product>) request.getAttribute("listProductNew");
                        for (Product product : listProductNew) {
                          BrandDAO brandDao = new BrandDAO();
                          Brand brand = brandDao.getById(product.getBrandId());
                          ProductDAO productDao = new ProductDAO();
                          String image = productDao.getImage(product.getProductId());
                %>

                <div class="col-sm-6 col-lg-2 mb-4 mb-lg-0">
                    <div class="filter-img-block position-relative image-container translate-effect-right"> 
                        <img src="<%=image%>" alt="image" class="img-fluid w-100"> 
                        <div class="img-filter-overlay fables-main-color-transparent flex-center">
                            <a href="detail?action=productdetail&product_id=<%=product.getProductId()%>" class="fables-third-text-color fables-second-hover-color work-icon mx-3"><span class="fables-iconlink "></span></a>
                            <a data-fancybox="gallery" href="assets/custom/images/blog-slider2.jpg" class="fables-third-text-color fables-second-hover-color work-icon mx-3"><span class="fables-iconsearch-icon"></span></a>
                        </div>
                    </div>
                    <h5 class="card-title mx-xl-3">
                        <a href="detail?action=productdetail&product_id=<%=product.getProductId()%>" class="fables-main-text-color fables-store-product-title fables-second-hover-color"><%=product.getName()%></a>
                    </h5>
                </div>
                <%}%>

                <a href="#" class="btn fables-second-border-color fables-second-text-color rounded-0 mt-4 mx-auto px-5 py-2 fables-second-hover-background-color">See all projects</a>
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