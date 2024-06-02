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
                <h2 class="fables-page-title fables-second-border-color">Cart</h2>
            </div>
        </div>

        <!-- Start Breadcrumbs -->
        <table border="1px">
            <caption>List of Product</caption>
            <tr>
                <th>productId</th>
                <th>name</th>
                <th>quantity</th>
                <th>price</th>
                <th>subTotal</th>
                <th>remove</th>
            </tr>
            <% Enumeration<String> em = session.getAttributeNames();
               DecimalFormat df = new DecimalFormat("#.##");
               double grandTotal = 0;
               Vector<String> vecKey = new Vector<>();
               while(em.hasMoreElements()){
                  String key = em.nextElement().toString();
                  if(key.equals("user") || key.equals("users")|| key.equals("vecKey")){
                  continue;
                }else{
                  vecKey.add(key);
                  ProductCart productCart = (ProductCart)session.getAttribute(key);
                  grandTotal += productCart.getPrice()*productCart.getQuantity();
            %>
            <tr>
                <td><%=productCart.getProductId()%></td>
                <td><%=productCart.getName()%></td>
                <td><%=productCart.getQuantity()%></td>
                <td><%=productCart.getPrice()%></td>
                <td><%=df.format((productCart.getPrice()*productCart.getQuantity())).replace(",",".")%></td>
                <td><a href="CartURL?service=remove&id=<%=productCart.getProductId()%>">Remove</a></td>
            </tr>
            <%}
                session.setAttribute("vecKey", vecKey);
                }%>
        </table>
        <p><a href="CartURL?service=removeAll">Remove All</a></p>
        <p>Grand Total: <%=df.format(grandTotal).replace(",",".")%></p>
        <p><a href=""></a></p>
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
