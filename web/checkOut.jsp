<%-- 
    Document   : product_list
    Created on : 2 thg 6, 2024, 14:56:04
    Author     : DELL
--%>
<%@page import="entity.*, java.util.*, java.text.DecimalFormat" %>
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
                <h2 class="fables-page-title fables-second-border-color">Mua Hàng</h2>
            </div>
        </div>

        <!-- Start Breadcrumbs -->
        <div class="container-fluid py-5">
            <form action="CartURL" method="get">
                <div class="container py-5">
                    <div class="table-responsive">

                        <table class="table">
                            <tr>
                                <th scope="col">Sản Phẩm</th>
                                <th scope="col">Tên</th>
                                <th scope="col">Giá</th>
                                <th scope="col">Số Lượng</th>
                                <th scope="col">Tổng</th>
                            </tr>
                            <%  
                                Enumeration<String> em = session.getAttributeNames();
                                DecimalFormat df = new DecimalFormat("#.##");
                                double grandTotal = 0;
                                int itemCount = 0;
                                Vector<String> vecKey = new Vector<>();
                                while(em.hasMoreElements()){
                                    String key = em.nextElement().toString();
                                    if(key.equals("user") || key.equals("vecKey")){
                                        continue;
                                    }else{
                                        vecKey.add(key);
                                        ProductCart productCart = (ProductCart)session.getAttribute(key);
                                        grandTotal += productCart.getPrice()*productCart.getQuantity();
                                        itemCount++;
                            %>
                            <tr>                            
                                <th scope="row">
                                    <div class="d-flex align-items-center">
                                        <img src="img/" class="img-fluid me-5 rounded-circle" style="width: 80px; height: 80px;" alt="">
                                    </div>
                                </th>
                                <td>
                                    <p class="mb-0 mt-4"><%=productCart.getName()%></p>
                                </td>
                                <td>
                                    <p class="mb-0 mt-4"><%=productCart.getPrice()%></p>
                                </td>
                                <td>
                                    <div class="input-group quantity mt-4" style="width: 100px;">
                                        <input type="number" min="0" name="<%=productCart.getProductId()%>" class="form-control form-control-sm text-center border-0" value="<%=productCart.getQuantity()%>">
                                    </div>
                                </td>
                                <td>
                                    <p class="mb-0 mt-4"><%=df.format((productCart.getPrice()*productCart.getQuantity())).replace(",",".")%></p>
                                </td>                     
                            </tr>
                            <% } 
                            }%>
                        </table>

                    </div>
                </div>
            </form>
        </div>
        <!-- checkOut -->
        <div class="row g-4 justify-content-end">
            <div class="col-8"></div>
            <div class="col-sm-8 col-md-7 col-lg-6 col-xl-4">
                <div class="bg-light rounded">

                    <form action="CartURL?service=checkOut" method="get">
                        <input type="hidden" name="accountId" value="2">

                        <div class="p-4">
                            <h1 class="display-6 mb-4">Giỏ <span class="fw-normal">Mua Hàng</span></h1>
                            <div class="d-flex justify-content-between mb-2">
                                <h5 class="mb-0 me-4">Họ </h5>
                                <input class="mb-0" name="firstName" value="" placeholder="Họ">
                            </div>
                            <div class="d-flex justify-content-between mb-2">
                                <h5 class="mb-0 me-4">Tên </h5>
                                <input class="mb-0" name="lastName" value="" placeholder="Tên">
                            </div>
                            <div class="d-flex justify-content-between mb-2">
                                <h5 class="mb-0 me-4">Mã Giảm Giá </h5>
                                <input class="mb-0" name="discountCode" value="" placeholder="Mã">
                            </div>
                            <div class="d-flex justify-content-between mb-2">
                                <h5 class="mb-0 me-4">Số Điện Thoại </h5>
                                <input class="mb-0" name="line1" value="" placeholder="0123456789">
                            </div>
                            <div class="d-flex justify-content-between mb-2">
                                <h5 class="mb-0 me-4">Địa Chỉ</h5>
                                <input class="mb-0" name="line2" value="" placeholder="Địa Chỉ">
                            </div>
                            <div class="d-flex justify-content-between mb-2">
                                <h5 class="mb-0 me-4">Thành Phố</h5>
                                <input class="mb-0" name="city" value="" placeholder="Thành Phố">
                            </div>
                            <div class="d-flex justify-content-between mb-2">
                                <h5 class="mb-0 me-4">Tỉnh</h5>
                                <input class="mb-0" name="province" value="" placeholder="Tỉnh">
                            </div>
                        </div>
                        <div class="py-4 mb-4 border-top border-bottom d-flex justify-content-between">
                            <h5 class="mb-0 ps-4 me-4">Tổng Giá</h5>
                            <p class="mb-0 pe-4"><%=df.format(grandTotal).replace(",", ".")%></p>
                        </div>

                        <button type="submit" name="submit" value="submit" class="btn border-secondary rounded-pill px-4 py-3 text-primary text-uppercase mb-4 ms-4">Xác Nhận Mua</button>
                    </form>

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
