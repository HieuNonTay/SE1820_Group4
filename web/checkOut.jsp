<%-- 
    Document   : product_list
    Created on : 2 thg 6, 2024, 14:56:04
    Author     : DELL
--%>
<%@page import="entity.*, java.util.*, java.text.DecimalFormat,dao.DisCountDAO,entity.Discount" %>
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
        <link rel="shortcut icon" href="/SE1820_Group4/assets/custom/images/shortcut.png">

        <title> Store Grid List </title>

        <!-- animate.css-->  
        <link href="/SE1820_Group4/assets/vendor/animate.css-master/animate.min.css" rel="stylesheet">
        <!-- Load Screen -->
        <link href="/SE1820_Group4/assets/vendor/loadscreen/css/spinkit.css" rel="stylesheet">
        <!-- GOOGLE FONT -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
        <!-- Font Awesome 5 -->
        <link href="/SE1820_Group4/assets/vendor/fontawesome/css/fontawesome-all.min.css" rel="stylesheet">
        <!-- Fables Icons -->
        <link href="/SE1820_Group4/assets/custom/css/fables-icons.css" rel="stylesheet"> 
        <!-- Bootstrap CSS --> 
        <link href="/SE1820_Group4/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="/SE1820_Group4/assets/vendor/bootstrap/css/bootstrap-4-navbar.css" rel="stylesheet">
        <!-- portfolio filter gallery -->
        <link href="/SE1820_Group4/assets/vendor/portfolio-filter-gallery/portfolio-filter-gallery.css" rel="stylesheet">
        <!-- FANCY BOX -->
        <link href="/SE1820_Group4/assets/vendor/fancybox-master/jquery.fancybox.min.css" rel="stylesheet"> 
        <!-- RANGE SLIDER -->
        <link href="/SE1820_Group4/assets/vendor/range-slider/range-slider.css" rel="stylesheet">
        <!-- OWL CAROUSEL  --> 
        <link href="/SE1820_Group4/assets/vendor/owlcarousel/owl.carousel.min.css" rel="stylesheet">
        <link href="/SE1820_Group4/assets/vendor/owlcarousel/owl.theme.default.min.css" rel="stylesheet">
        <!-- FABLES CUSTOM CSS FILE -->
        <link href="/SE1820_Group4/assets/custom/css/custom.css" rel="stylesheet">
        <!-- FABLES CUSTOM CSS RESPONSIVE FILE -->
        <link href="/SE1820_Group4/assets/custom/css/custom-responsive.css" rel="stylesheet">
        <link rel="stylesheet" href="/SE1820_Group4/css1/toastr.min.css">

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
            <div class="container py-5">
                <div class="table-responsive">
                    <table class="table">
                        <tr>
                            <th scope="col">Product</th>
                            <th scope="col">Name</th>
                            <th scope="col">Price</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Total</th>
                        </tr>
                        <%  
                            DisCountDAO disDao = new DisCountDAO();
                            Discount d = (Discount) request.getAttribute("discount");
                            String code = "";
                            if(d != null){
                                code = d.getCode();
                            }
                            List<Integer> productIds = new ArrayList<>();
                            Enumeration<String> em = session.getAttributeNames();
                            DecimalFormat df = new DecimalFormat("#,###");
                            double grandTotal = 0;
                            double discountTotal = 0;
                             double oldTotal = 0;
                            int itemCount = 0;
                            Vector<String> vecKey = new Vector<>();
                            while(em.hasMoreElements()){
                                String key = em.nextElement().toString();
                                if(key.equals("acc") || key.equals("vecKey")||key.equals("products")||key.equals("functionToast") ){
                                    continue;
                                }else{
                                    vecKey.add(key);
                                    ProductCart productCart = (ProductCart)session.getAttribute(key);
                                    productIds.add(productCart.getProductId());
                                    if(d != null && productCart.getProductId() == d.getProductId()){
                                    grandTotal += productCart.getPrice()*productCart.getQuantity()* ((100 - d.getAmount())/100);
                                    discountTotal += productCart.getPrice()*productCart.getQuantity()* (d.getAmount()/100);
                                    }else{
                                     grandTotal += productCart.getPrice()*productCart.getQuantity();
                                    }
                                    oldTotal += productCart.getPrice()*productCart.getQuantity();
                                    itemCount++;
                        %>
                        <tr>                            
                            <th scope="row">
                                <div class="d-flex align-items-center">
                                    <img src="assets/custom/images/Nike0001.webp" class="img-fluid me-5 rounded-circle" style="width: 80px; height: 80px;" alt="">
                                </div>
                            </th>
                            <td>
                                <p class="mb-0 mt-4"><%=productCart.getName()%></p>
                            </td>
                            <td>
                                <p class="mb-0 mt-4"><%=df.format(productCart.getPrice()).replace(",",".")%> VND</p>
                            </td>
                            <td>
                                <div class="input-group quantity mt-4" style="width: 100px;">
                                    <input type="number" min="0" name="<%=productCart.getProductId()%>" class="form-control form-control-sm text-center border-0" value="<%=productCart.getQuantity()%>">
                                </div>
                            </td>
                            <td>
                                <p class="mb-0 mt-4"><%=df.format((productCart.getPrice()*productCart.getQuantity())).replace(",",".")%> VND</p>
                            </td>                     
                        </tr>
                        <% } 
                            } 
                            List<Discount> lstDiscount = disDao.getListDiscountToSelect(productIds);
                        %>
                    </table>
                </div>
            </div>
        </div>
        <!-- checkOut -->

        <div class="row g-4 justify-content-end">
            <div class="col-8"></div>
            <div class="col-sm-8 col-md-7 col-lg-6 col-xl-4">
                <div class="bg-light rounded">

                    <form id="purchaseForm" action="/SE1820_Group4/CartURL?service=checkOut" method="post">
                        <input type="hidden" name="accountId" value="2">
                        <p class="text-danger" >${mess}</p> 
                        <div class="p-4">
                            <h1 class="display-6 mb-4">Cart <span class="fw-normal">Buy</span></h1>
                            <div class="d-flex justify-content-between mb-2">
                                <h5 class="mb-0 me-4">First Name </h5>
                                <input class="mb-0" type="hidden" name="isAdded" value="${isAdded}">
                                <input class="mb-0" name="firstName" value="${sessionScope. acc.getLname()}" placeholder="First Name">
                            </div>
                            <div class="d-flex justify-content-between mb-2">
                                <h5 class="mb-0 me-4">Last Name </h5>
                                <input class="mb-0" name="lastName" value="${sessionScope. acc.getFname()}" placeholder="Last Name">
                            </div>

                            <div class="d-flex justify-content-between mb-2">
                                <h5 class="mb-0 me-4">Phone</h5>
                                <input class="mb-0" name="line1" value="${sessionScope. acc.getPhone()}" placeholder="0123456789">
                            </div>
                            <div class="d-flex justify-content-between mb-2">
                                <h5 class="mb-0 me-4">Address</h5>
                                <input class="mb-0" name="line2" value="${sessionScope. acc.getAddress()}" placeholder="Address">
                            </div>
                            <div class="d-flex justify-content-between mb-2">
                                <h5 class="mb-0 me-4">City</h5>
                                <input class="mb-0" name="city" value="${sessionScope. acc.getAddress()}" placeholder="City">
                            </div>
                            <div class="d-flex justify-content-between mb-2">
                                <h5 class="mb-0 me-4">Province</h5>
                                <input class="mb-0" name="province" value="${sessionScope. acc.getAddress()}" placeholder="Province">
                            </div>
                            <!--                            <div class="d-flex justify-content-between mb-2">
                                                            <h5 class="mb-0 me-4">Mã Giảm Giá </h5>
                                                            <input class="mb-0" name="discountCode" placeholder="Mã" id="discountCode" value="<%=code%>">
                                                            <input class="mb-0" type="button" class="btn btn-primary" value="Áp dụng" onclick="usingDiscountCode()">
                                                        </div>-->
                            <div class="d-flex justify-content-between mb-2">
                                <h5 class="mb-0 me-4 " >Discount Code </h5>
                                <c:set var="codeParam" value="<%=code%>" />
                                <select name="discountCode" class="mb-0" style="width: 191px" onchange="changeDiscount(this)">
                                    <option value=""></option>
                                    <c:forEach var="pro" items="<%=lstDiscount%>">
                                        <option value="${pro.code}" ${pro.code == codeParam ? 'selected' : ''}>${pro.name} - ${pro.amount}%</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="d-flex justify-content-between mb-2">
                                <h5 class="mb-0 me-4">Payment Method</h5>
                                <select name="paymentMethod" class="mb-0" onchange="handlePaymentMethodChange(this)">
                                    <option value=""></option>
                                    <option value="direct">Direct</option>
                                    <option value="online">Online</option>
                                </select>
                            </div>
                        </div>
                        <!--                        <div class="py-4 mb-4 border-top border-bottom d-flex justify-content-between">
                                                    <h5 class="mb-0 ps-4 me-4">Total</h5>
                                                    <p class="mb-0 pe-4"><%//=df.format(oldTotal).replace(",", ".")%></p>
                                                </div>-->
                        <div class="py-4 mb-4 border-top border-bottom d-flex justify-content-between">
                            <h5 class="mb-0 ps-4 me-4">Discount</h5>
                            <p class="mb-0 pe-4"><%=df.format(discountTotal).replace(",", ".")%></p>
                        </div>
                        <div class="py-4 mb-4 border-top border-bottom d-flex justify-content-between">
                            <h5 class="mb-0 ps-4 me-4">Total</h5>
                            <p class="mb-0 pe-4"><%=df.format(grandTotal).replace(",", ".")%> VND</p>
                        </div>
                        <div id="qrCodeContainer" class="text-center d-none" >
                            <img src="https://img.vietqr.io/image/MB-2003666886789-compact2.png?amount=<%=df.format(grandTotal).replace(",", "")%>&addInfo=SHOES&accountName=BUI+VAN+HIEU" height="300px" width=250" alt="QR Code Image">
                            <button type="submit" name="submit" value="submit" margin-top="2px" class="btn border-secondary rounded-pill px-4 py-3 text-primary text-uppercase mb-4 ms-4">Submit</button>
                        </div>

                    </form>

                </div>
            </div>
        </div>

        <!-- /End page content -->


        <jsp:include page="footer.jsp"/>
        <script>
            // Function to handle changes in the payment method dropdown
            function handlePaymentMethodChange(selectElement) {
                var qrCodeContainer = document.getElementById('qrCodeContainer');
                var paymentMethod = selectElement.value;

                if (paymentMethod === 'online') {
                    qrCodeContainer.classList.remove('d-none');
                } else {
                    qrCodeContainer.classList.add('d-none');
                }
            }

            document.getElementById('submitOrderBtn').addEventListener('click', function () {
                document.getElementById('purchaseForm').submit();
            });
        </script>

        <script src="/SE1820_Group4/assets/vendor/jquery/jquery-3.3.1.min.js"></script>
        <script src="/SE1820_Group4/assets/vendor/jquery-circle-progress/circle-progress.min.js"></script>
        <script src="/SE1820_Group4/assets/vendor/popper/popper.min.js"></script>
        <script src="/SE1820_Group4/assets/vendor/WOW-master/dist/wow.min.js"></script>
        <script src="/SE1820_Group4/assets/vendor/loadscreen/js/ju-loading-screen.js"></script>
        <script src="/SE1820_Group4/assets/vendor/range-slider/range-slider.js"></script>
        <script src="/SE1820_Group4/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="/SE1820_Group4/assets/vendor/bootstrap/js/bootstrap-4-navbar.js"></script>
        <script src="/SE1820_Group4/assets/vendor/timeline/jquery.timelify.js"></script>
        <script src="/SE1820_Group4/assets/vendor/owlcarousel/owl.carousel.min.js"></script> 
        <script src="/SE1820_Group4/assets/custom/js/custom.js"></script>  
        <script src="/SE1820_Group4/js/toastr.min.js"></script>
        <c:if test="${message != null}">
            <script type="text/javascript">
            toastr.success(`${message}`, 'Success', {timeOut: 1000});

            </script>
        </c:if> <c:if test="${error != null}">
            <script type="text/javascript">
                toastr.error(`${error}`, 'Error', {timeOut: 1000});
            </script>
        </c:if>
        <script type="text/javascript">
//            function usingDiscountCode() {
//                var code = document.getElementById("discountCode").value;
//                if (code) {
//                    window.location.href = '/SE1820_Group4/discount/apply?code=' + code;
//                } else {
//                    alert("please enter code");
//                }
//            }

            function changeDiscount(e) {
                var code = e.value;
                if (code) {
                    window.location.href = '/SE1820_Group4/discount/apply?code=' + code;
                } else {
                    window.location.href = '/SE1820_Group4/CartURL?service=checkOut';
                }
            }
        </script>

    </body>
</html>
