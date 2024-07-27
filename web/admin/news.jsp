<%-- 
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>News Manager | Admin dashboard</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="admin/css/main.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!-- or -->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

        <!-- Font-icon css-->
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">

        <link href="css1/font-face.css" rel="stylesheet" media="all">
        <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
        <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
        <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

        <!-- Bootstrap CSS-->
        <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

        <!-- Vendor CSS-->
        <link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
        <link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
        <link href="vendor/wow/animate.css" rel="stylesheet" media="all">
        <link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
        <link href="vendor/slick/slick.css" rel="stylesheet" media="all">
        <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
        <link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

        <!-- Main CSS-->
        <link href="css1/theme.css" rel="stylesheet" media="all">
        <link rel="stylesheet" href="css1/bootstrap.min.css">
        <link rel="stylesheet" href="css1/toastr.min.css">
    </head>

    <body onload="time()" class="app sidebar-mini rtl">
        <!-- Navbar-->

        <jsp:include page="Sidebar.jsp"/>

        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item active"><a href="#"><b>News Manager</b></a></li>
                </ul>
                <div id="clock"></div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">

                        <c:if test="${requestScope.news.size() == 0}">
                            <h3 class="title-5 m-b-35">Not available result!</h3> 
                        </c:if>
                        <c:if test="${requestScope.news.size() != 0}">
                            <table class="table table-hover table-bordered" id="sampleTable">

                                <thead>
                                <div class="tile-body">
                                    <div class="table-data__tool-left">
                                        <form id="myForm" action="news" method="post">

                                            <div class="rs-select2--light rs-select2--md">
                                                <select class="js-select2" name="groupBy" onchange="submitForm()">
                                                    <c:set var="gr" value="${requestScope.groupBy}"/>
                                                    <option ${(gr == 0)?'selected':''} value="0">Group by</option>
                                                    <c:forEach var="g" items="${requestScope.groups}">
                                                        <option ${(g.id == gr)?'selected':''} value="${g.id}">${g.name}</option>
                                                    </c:forEach>
                                                </select>
                                                <div class="dropDownSelect2"></div>
                                            </div>
                                            <input type="hidden" name="search" value="${requestScope.search}">     
                                        </form>
                                    </div>    
                                    <div class="table-data__tool">
                                        <form class="form-header" action="news" method="post">
                                            <input type="hidden" name="groupBy" value="${requestScope.groupBy}"> 
                                        </form>
                                    </div>
                                    <div class="row element-button">
                                        <div class="col-sm-2">
                                            <form action="newsDetail" method="get" style="display: inline-block">
                                                <button class="au-btn au-btn-icon au-btn--green au-btn--small" >
                                                    <i class="zmdi zmdi-plus"></i>Add news</button>                                            
                                            </form>
                                        </div>
                                    </div>
                                    <tr>
                                        <th>Group name</th>
                                        <th>Author</th>
                                        <th>Title</th>
                                        <th>Post date</th>
                                        <th>Edit</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="n" items="${requestScope.news}">
                                            <tr>
                                                <td>${n.groupName}</td>
                                                <td>${n.author}</td>
                                                <td>${n.title}</td>
                                                <td>${n.createAt}</td>

                                                <td>
                                                    <div class="table-data-feature">
                                                        <form action="newsDetail" method="post">
                                                            <input type="hidden" name="updateNewsId" value="${n.id}">
                                                            <button class="item" data-toggle="tooltip" data-placement="top" title="Edit" type="submit">
                                                                <i class="zmdi zmdi-edit"></i>
                                                            </button>
                                                        </form>
                                                        <form action="newsManage" method="post" id="${n.id}">
                                                            <input name="act" value="delete" hidden/>
                                                            <input type="hidden" name="newsId" value="${n.id}">
                                                            <button type="button" class="item" data-toggle="tooltip" data-placement="top" 
                                                                    title="Delete" type="submit"  onclick="confirmDelete(${n.id})">
                                                                <i class="zmdi zmdi-delete"></i>
                                                            </button>
                                                        </form>
                                                    </div>
                                                </td>

                                            </tr>
                                        </c:forEach>                                                
                                    </tbody>
                            </table>

                        </div>
                        <div class="product-pagination text-center">
                            <form id="myForm1" action="news" method="post">
                                <input type="hidden" name="groupBy" value="${requestScope.groupBy}">     
                                <input type="hidden" name="search" value="${requestScope.search}">     

                                <div class="d-flex justify-content-end">
                                    <ul class="pagination">
                                        <li class="page-item">
                                            <a href="#" aria-label="Previous"class="page-link" onclick="submitForm1(${requestScope.page - 1})">
                                                <span aria-hidden="true">&laquo;</span>
                                            </a>
                                        </li>                                                
                                        <c:forEach begin="1" end="${requestScope.count}" var="i">
                                            <li class="page-item ${requestScope.page == i ? 'active' : ''}"><a class="page-link" onclick="submitForm1(${i})">${i}</a></li>                                         
                                                <c:if test="${i == requestScope.page || requestScope.page - 1 == i || requestScope.page + 1 == i}">
                                                </c:if>
                                            </c:forEach>
                                        <li class="page-item">
                                            <a href="#" aria-label="Previous"class="page-link" onclick="submitForm1(${requestScope.page + 1})">
                                                <span aria-hidden="true">&raquo;</span>
                                            </a>
                                        </li>                                                
                                    </ul>
                                </div>
                                <input type="hidden" name="page" value="1" id="myPage">
                            </form>                        
                        </div>

                    </c:if>       
                </div>
            </div>
        </div>
    </main>



    <!-- Essential javascripts for application to work-->
    <script src="admin/js/jquery-3.2.1.min.js"></script>
    <script src="admin/js/popper.min.js"></script>
    <script src="admin/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="admin/js/main.js"></script>
    <!-- The javascript plugin to display page loading on top-->
    <script src="admin/js/plugins/pace.min.js"></script>
    <!-- Page specific javascripts-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
    <!-- Data table plugin-->
    <script type="text/javascript" src="admin/js/plugins/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="admin/js/plugins/dataTables.bootstrap.min.js"></script>
    <script type="text/javascript">
                                                $('#sampleTable').DataTable();
                                                //Thời Gian
                                                function time() {
                                                    var today = new Date();
                                                    var weekday = new Array(7);
                                                    weekday[0] = "Sunday";
                                                    weekday[1] = "Monday";
                                                    weekday[2] = "Tuesday";
                                                    weekday[3] = "Wednesday ";
                                                    weekday[4] = "Thursday";
                                                    weekday[5] = "Friday";
                                                    weekday[6] = "Saturday";
                                                    var day = weekday[today.getDay()];
                                                    var dd = today.getDate();
                                                    var mm = today.getMonth() + 1;
                                                    var yyyy = today.getFullYear();
                                                    var h = today.getHours();
                                                    var m = today.getMinutes();
                                                    var s = today.getSeconds();
                                                    m = checkTime(m);
                                                    s = checkTime(s);
                                                    nowTime = h + " : " + m + " : " + s;
                                                    if (dd < 10) {
                                                        dd = '0' + dd
                                                    }
                                                    if (mm < 10) {
                                                        mm = '0' + mm
                                                    }
                                                    today = day + ', ' + dd + '/' + mm + '/' + yyyy;
                                                    tmp = '<span class="date"> ' + today + ' - ' + nowTime +
                                                            '</span>';
                                                    document.getElementById("clock").innerHTML = tmp;
                                                    clocktime = setTimeout("time()", "1000", "Javascript");

                                                    function checkTime(i) {
                                                        if (i < 10) {
                                                            i = "0" + i;
                                                        }
                                                        return i;
                                                    }
                                                }
    </script>
    <script>

        $(document).ready(jQuery(function () {
            jQuery(".trash").click(function () {
                swal({
                    title: "Warning!",
                    text: "Are you sure you want to delete this product?",
                    buttons: ["Cancel", "Yes"],
                })
                        .then((willDelete) => {
                            if (willDelete) {
                                window.location = "productmanager?action=deleteproduct&product_id=" + $(this).attr("value");
                                swal("Deleted successfully.!", {
                                });
                            }
                        });
            });
        }));
    </script>
    <script>
        var myApp = new function () {
            this.printTable = function () {
                var tab = document.getElementById('sampleTable');
                var win = window.open('', '', 'height=700,width=700');
                win.document.write(tab.outerHTML);
                win.document.close();
                win.print();
            }
        }
    </script>
    <script>
        function showToast(type, title) {
            switch (type) {
                case 'success':
                    toastr.success(title, 'Notification');
                    break;
                case 'info':
                    toastr.info(title, 'Notification');
                    break;
                case 'warning':
                    toastr.warning(title, 'Notification');
                    break;
                case 'error':
                    toastr.error(title, 'Notification');
                    break;
                default:
                    break;
            }
        }
    </script>
    <script>
        function confirmDelete(id) {
            if (confirm('Are you sure do delete this news?')) {
                var formDelete = document.getElementById(id);
                if (formDelete) {
                    formDelete.submit();
                }
            }
        }
    </script> 
    <script>
        function submitForm() {
            document.getElementById("myForm").submit();
        }
        function submitForm1(index) {
            var form1 = document.getElementById("myForm1");
            var pageInput = document.getElementById("myPage");
            pageInput.value = index;
            form1.submit();
        }
    </script>
</body>

</html>