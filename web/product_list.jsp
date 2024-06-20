<%-- 
    Document   : product_list
    Created on : 2 thg 6, 2024, 14:56:04
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="pageSize" value="9" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Fables">
        <meta name="author" content="Enterprise Development">
        <link rel="shortcut icon" href="assets/custom/images/shortcut.png">

        <title> Store Grid List </title>

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
                <h2 class="fables-page-title fables-second-border-color">Product List</h2>
            </div>
        </div>

        <!-- Start Breadcrumbs -->
        <div class="fables-light-gary-background">
            <div class="container"> 
                <nav aria-label="breadcrumb">
                    <ol class="fables-breadcrumb breadcrumb px-0 py-3">
                        <li class="breadcrumb-item"><a href="#" class="fables-second-text-color">Home</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Store Grid List</li>
                    </ol>
                </nav> 
            </div>
        </div>
        <!-- /End Breadcrumbs -->

        <!-- Start page content --> 
        <div class="container">
            <div class="row my-4 my-md-5">
                <div class="col-12 col-md-4 col-lg-3">
                    <div class="fables-store-search mb-4">
                        <form action="product" method="get"> 
                            <div class="input-icon">
                                <span class="fables-iconsearch-icon fables-input-icon"></span>
                                <input name="search" type="text" class="form-control rounded-0 form-control rounded-0 font-14 fables-store-input pl-5 py-2"  placeholder="Search Product">
                                <button type="submit" name="submit" value="submit" id="search-icon-1" class="input-group-text p-3"><i class="fa fa-search"></i></button>

                            </div>

                        </form>
                    </div>
                    <div class="range-slider">
                        <h2 class="font-16 semi-font fables-forth-text-color fables-light-gary-background p-3 mb-4">Filter by price</h2>
                        <form action="product" method="get">
                            <div class="range-slider fables-forth-text-color" id="facet-price-range-slider" data-options='{"output":{"prefix":""},"maxSymbol":"+"}'>
                                <input name="passPrice" value="0" min="0" max="200" step="1" type="range" id="priceRange" oninput="updatePriceValue(this.value)">
                                <input name ="service" value="filterPrice" hidden=>
                                <span id="priceValue">0</span>
                            </div>
                            <div class="form-group mb-4 mt-3">
                                <select class="form-control rounded-0" name="sortOrder">
                                    <option value="default" selected>Default sorting</option>
                                    <option value="ascending">Ascending price</option>
                                    <option value="decreasing">Decreasing price</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-block fables-second-background-color rounded-0 white-color white-color-hover p-2 font-15 mb-4">Filter</button>
                        </form>
                    </div>

                    <h2 class="font-16 semi-font fables-forth-text-color fables-light-gary-background  p-3 mb-4">Product Categories</h2>
                    <ul class="nav fables-forth-text-color fables-forth-before fables-store-left-list">
                        <c:forEach items="${categorys}" var="category">
                            <li><a href="product?name=${category.categoryName}&service=categoryFilter"">${category.categoryName}</a></li>
                            </c:forEach>
                    </ul>

                </div>
                <div class="col-12 col-md-8 col-lg-9"> 
                    <div class="row mb-4">
                        <!--                        <div class="col-12 col-lg-4">
                                                    <form> 
                                                        <div class="form-group mb-0"> 
                                                            <select class="form-control rounded-0">
                                                                <option value="" selected>default sorting</option>
                                                                <option>2</option>
                                                                <option>3</option>
                                                                <option>4</option>
                                                                <option>5</option>
                                                            </select>
                                                        </div> 
                                                    </form>
                                                </div>-->
                        <div class="col-4 col-md-6 col-lg-2 offset-lg-6 text-center pl-0 d-none d-lg-block">
                            <span class="fables-iconlist fa-fw fables-view-btn fables-list-btn fables-third-border-color fables-third-text-color"></span>
                            <span class="fables-icongrid active fa-fw fables-view-btn fables-grid-btn fables-third-border-color fables-third-text-color"></span>
                        </div>
                    </div>
                    <div class="row">
                        <c:forEach items="${listProduct}"
                                   var="product" >

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
                                                <a href="detail?action=productdetail&product_id=${product.productId}" class="fables-main-text-color fables-store-product-title fables-second-hover-color">${product.name}</a>
                                            </h5>
                                            <p class="store-card-text fables-fifth-text-color font-15 mx-xl-3">DOUBLE</p>
                                            <p class="font-15 font-weight-bold fables-second-text-color my-2 mx-xl-3">${product.price} $</p>
                                            <p class="fables-product-info">
                                                <a href="CartURL?service=addToCart&id=${product.productId}" class="btn fables-second-border-color fables-second-text-color fables-btn-rouned fables-hover-btn-color font-14 p-2 px-2 px-xl-4">
                                                    <span class="fables-iconcart"></span> 
                                                    <span class="fables-btn-value">ADD TO CART</span></a></p>
                                        </div>
                                    </div>
                                </div>
                            </div>  
                        </c:forEach>
                    </div> 
                    <nav aria-label="Page navigation">
                        <ul class="pagination justify-content-center">                                 
                            <li class="page-item"><a class="page-link rounded-circle fables-forth-text-color fables-page-link fables-second-hover-background-color" href="#">1</a></li>
                            <li class="page-item"><a class="page-link rounded-circle fables-forth-text-color fables-page-link fables-second-hover-background-color" href="#">2</a></li>
                            <li class="page-item"><a class="page-link rounded-circle fables-forth-text-color fables-page-link fables-page-link fables-second-hover-background-color" href="#">3</a></li>  
                            <li><span class="fables-pagi-dots fables-forth-text-color"> .... </span></li>
                            <li class="page-item"><a class="page-link rounded-circle fables-forth-text-color fables-page-link fables-second-hover-background-color" href="#">20</a></li>                                
                        </ul>
                    </nav> 
                </div>
            </div>

        </div> 
        <!-- /End page content -->

        <jsp:include page="footer.jsp"/>


        <script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
        <script src="assets/vendor/jquery-circle-progress/circle-progress.min.js"></script>
        <script src="assets/vendor/popper/popper.min.js"></script>
        <script src="assets/vendor/WOW-master/dist/wow.min.js"></script>
        <script src="assets/vendor/loadscreen/js/ju-loading-screen.js"></script>
        <script src="assets/vendor/range-slider/range-slider.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap-4-navbar.js"></script>
        <script src="assets/vendor/timeline/jquery.timelify.js"></script>
        <script src="assets/vendor/owlcarousel/owl.carousel.min.js"></script> 
        <script src="assets/custom/js/custom.js"></script>  

        <script>
            function updatePriceValue(value) {
                document.getElementById('priceValue').textContent = value;
            }

            // Initial display of the price value
            document.addEventListener('DOMContentLoaded', (event) => {
                const rangeInput = document.getElementById('priceRange');
                const priceValue = document.getElementById('priceValue');
                priceValue.textContent = rangeInput.value;
            });
        </script>
    </body>
</html>
