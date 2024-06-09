<%-- 
    Document   : update_order
    Created on : 9 thg 6, 2024, 21:03:44
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="pageSize" value="9" />
<!DOCTYPE html>
<html>
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

        <div class="container-fluid page-header py-5">
            <h1 class="text-center text-white display-6">Admin</h1>
            <ol class="breadcrumb justify-content-center mb-0">
                <li class="breadcrumb-item"><a href="#">Admin</a></li>
            </ol>
        </div>
        <%
          Order order = (Order)request.getAttribute("order");
        %>

        <div class="container" style="margin-top: 10px">
            <div class="row">
                <div class="col-md-12">
                    <h3>Cập Nhật Thông Tin Đơn Hàng</h3>
                    <form action="order" method="post">
                        <input type="hidden" name="service" value="updateOrderAction">
                        <input type="hidden" name="orderId" value="<%= order.getOrderId() %>">
                        <div class="form-group">
                            <label for="orderId">Order ID:</label>
                            <input type="text" class="form-control" id="orderId" name="customerId" value="<%= order.getOrderId() %>" readonly>
                        </div>
                        <div class="form-group">
                            <label for="customerId">Account ID:</label>
                            <input type="text" class="form-control" id="customerId" name="customerId" value="<%= order.getCustomerId() %>" readonly>
                        </div>
                        <div class="form-group">
                            <label for="address">First Name:</label>
                            <input type="text" class="form-control" id="firstName" name="firstName" value="<%= order.getFirstName() %>">
                        </div>
                        <div class="form-group">
                            <label for="address">Last Name:</label>
                            <input type="text" class="form-control" id="lastName" name="lastName" value="<%= order.getLastName() %>">
                        </div>
                        
                        <div class="form-group">
                            <label for="orderDate">Order Date:</label>
                            <input type="text" class="form-control" id="orderDate" name="orderDate" value="<%= order.getOrderdate() %>" readonly>
                        </div>
                        <div class="form-group">
                            <label for="total">Total:</label>
                            <input type="text" class="form-control" id="total" name="total" value="<%= order.getTotal() %>">
                        </div>
                        <div class="form-group">
                            <label for="address">Address:</label>
                            <input type="text" class="form-control" id="address" name="address" value="<%= order.getCity() %>">
                        </div>
                        <div class="form-group">
                            <label for="status">Status:</label>
                            <select class="form-control" id="status" name="status">
                                <option value="Pending" <%= order.getStatus().equals("Pending") ? "selected" : "" %>>Pending</option>
                                <option value="Delivering" <%= order.getStatus().equals("Delivering") ? "selected" : "" %>>Delivering</option>
                                <option value="Delivered" <%= order.getStatus().equals("Delivered") ? "selected" : "" %>>Delivered</option>
                                <option value="Cancelled" <%= order.getStatus().equals("Cancelled") ? "selected" : "" %>>Cancelled</option>
                            </select>
                        </div>
                        <div style="margin-top: 10px">
                            <button type="submit" class="btn btn-primary">Cập Nhật</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


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
