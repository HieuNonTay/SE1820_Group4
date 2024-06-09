<%-- 
    Document   : product_list
    Created on : 2 thg 6, 2024, 14:56:04
    Author     : DELL
--%>
<%@page import="java.sql.ResultSet, entity.*, dao.*, java.util.*"%>
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
                <h2 class="fables-page-title fables-second-border-color">Order Manage</h2>
            </div>
        </div>

        <!-- Start Breadcrumbs -->
        <div class="fables-light-gary-background">
            <div class="container"> 
                <nav aria-label="breadcrumb">
                    <ol class="fables-breadcrumb breadcrumb px-0 py-3">
                        <li class="breadcrumb-item"><a href="#" class="fables-second-text-color">Home</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Order Manage</li>
                    </ol>
                </nav> 
            </div>
        </div>
        <!-- /End Breadcrumbs -->

        <!-- Start page content --> 
        <div class="container" style="margin-top: 10px">
            <div class="row mb-3">
                <div class="col-md-6">
                    <form action="order" method="get" class="position-relative">
                        <div class="input-group">
                            <input name="searchOrderId" class="form-control border-secondary py-3 rounded-start" type="text" placeholder="Enter the order ID you want to find">
                            <button type="submit" value="submit" class="btn btn-primary py-3 px-4 rounded-end">Tìm Kiếm</button>
                        </div>
                    </form>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <table class="table table-bordered table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">Order ID</th>
                                <th scope="col">Account ID</th>
                                <th scope="col">First Name</th>
                                <th scope="col">Last Name</th>
                                <th scope="col">Order Date</th>
                                <th scope="col">Total</th>
                                <th scope="col">Address</th>
                                <th scope="col">Status</th>
                                <th scope="col">Edit</th>
                                <th scope="col">Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% 
                                Vector<Order> listOrder = (Vector<Order>) request.getAttribute("listOrder");
                                for (Order order : listOrder) { 
                            %>
                        <form action="order?service=updateStatus" method="post">
                            <input type="hidden" name="orderId" value="<%= order.getOrderId()%>">
                            <tr>
                                <td><%= order.getOrderId()%></td>
                                <td><%= order.getAccountId()%></td>
                                <td><%= order.getFirstName()%></td>
                                <td><%= order.getLastName()%></td>
                                <td><%= order.getOrderdate()%></td>
                                <td><%= order.getTotal()%></td>
                                <td><%= order.getCity()%></td>

                                <td>
                                    <label for="status"></label>
                                    <select class="form-control" id="status" name="status">
                                        <option value="Pending" <%= order.getStatus().equals("Pending") ? "selected" : "" %>>Pending</option>
                                        <option value="Delivering" <%= order.getStatus().equals("Delivering") ? "selected" : "" %>>Delivering</option>
                                        <option value="Delivered" <%= order.getStatus().equals("Delivered") ? "selected" : "" %>>Delivered</option>
                                        <option value="Cancelled" <%= order.getStatus().equals("Cancelled") ? "selected" : "" %>>Cancelled</option>
                                    </select></td>
                                <td>
                                    <a href="order?service=updateOrder&id=<%= order.getOrderId()%>" class="btn btn-sm btn-primary">Edit</a>
                                </td>
                                <td>
                                    <input type="submit" name="service" value="updateStatus" class="btn btn-sm btn-primary">
                                </td>
                                


                            </tr>
                        </form>
                        <% } %>
                        </tbody>
                    </table>
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

    </body>
</html>
