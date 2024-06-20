<%-- 
    Document   : userDetail
    Created on : Jun 6, 2024, 8:13:05 PM
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

        <title> User Detail </title>

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
        <jsp:include page="header.jsp"/>
        <div class="fables-header fables-after-overlay">
            <div class="container"> 
                <h2 class="fables-page-title fables-second-border-color">Profile</h2>
            </div>
        </div>  
        <!-- Start Breadcrumbs -->
        <div class="fables-light-background-color">
            <div class="container"> 
                <nav aria-label="breadcrumb">
                    <ol class="fables-breadcrumb breadcrumb px-0 py-3">
                        <li class="breadcrumb-item"><a href="home" class="fables-second-text-color">Home</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Profile</li>
                    </ol>
                </nav> 
            </div>
        </div>
        <!-- /End Breadcrumbs -->

        <div class="container-xl px-4 mt-4">
            <!-- Account page navigation-->
            <nav class="nav nav-borders">
                <a class="nav-link active ms-0" href="userDetail.jsp" target="__blank">Profile</a>
                <a class="nav-link" href="#" target="__blank">History</a>
                <a class="nav-link" href="changePassword.jsp" target="__blank">Change password</a>
            </nav>
            <hr class="mt-0 mb-4">
            <div class="row">
                <div class="col-xl-4">
                    <!-- Profile picture card-->
                    <div class="card mb-4 mb-xl-0">
                        <div class="card-header">Profile Picture</div>
                        <div class="card-body text-center">
                            <!-- Profile picture image-->
                            <img class="img-account-profile rounded-circle mb-2" src="assets/custom/images/avatar.jpg" alt="">
                            <!-- Profile picture help block-->
                            <div class="small font-italic text-muted mb-4"> ${sessionScope.acc.getFname()}  ${sessionScope.acc.getLname()}</div>
                            <!-- Profile picture help block-->
                            <div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
                            <!-- Profile picture upload button-->
                            <button class="btn btn-primary" type="button">Upload new image</button>
                        </div>
                    </div>
                </div>
                <div class="col-xl-8">
                    <!-- Account details card-->
                    <div class="card mb-4">
                        <div class="card-header">Account Details</div>
                        <div class="card-body">
                            <form id="myForm" method="Get">

                                <p class="text-danger">${mess}</p> 

                                <!-- Form Row-->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (first name)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1">First name</label>
                                        <input name="fname" class="form-control" type="text" placeholder="Enter your first name" required value="${sessionScope.acc.getFname()}">
                                    </div>
                                    <!-- Form Group (last name)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1">Last name</label>
                                        <input name="lname" class="form-control" type="text" placeholder="Enter your last name"  required value="${sessionScope.acc.getLname()}"">
                                    </div>
                                </div>
                                <!-- Form Row  -->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (birthday)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1">Birthday</label>
                                        <input name="dob" class="form-control" type="date" placeholder="Date of birth" required value="${sessionScope.acc.getDob()}"">
                                    </div>

                                    <!-- Form Group (location)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1">Address</label>
                                        <input name="address" class="form-control" type="text" placeholder="Enter your address"  required value="${sessionScope.acc.getAddress()}">
                                    </div>
                                </div>
                                <!-- Form Row-->
                                <div class="row gx-3 mb-3">  
                                    <!-- Form Phone-->
                                    <div class="col-md-6">
                                        <label class="small mb-1">Phone number</label>
                                        <input name="phone" class="form-control" type="text" value="${sessionScope.acc.getPhone()}" maxlength="10" pattern="0\d{9}" required>
                                    </div>
                                    <!-- Form Group (email address)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1">Email(user name)</label>
                                        <input name="email" class="form-control" type="email" value="${sessionScope.acc.getEmail()}" readonly>
                                    </div>
                                </div>
                                <!-- Save changes button-->
                                <button type="submit" class="btn btn-primary" onclick="setFormAction('updateInfo');">Save changes</button>
                                <!-- Log Out button-->
                                <button type="submit" class="btn btn-danger"  onclick="setFormAction('logout');">Log Out</button>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

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
