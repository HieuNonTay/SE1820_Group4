<%-- 
    Document   : product
    Created on : Oct 19, 2021, 11:23:29 PM
    Author     : Khuong Hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Product Manager | Admin dashboard</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="./css/main.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!-- or -->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

        <!-- Font-icon css-->
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">

    </head>

    <body onload="time()" class="app sidebar-mini rtl">
        <!-- Navbar-->
        <header class="app-header">
            <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                            aria-label="Hide Sidebar"></a>
            <!-- Navbar Right Menu-->
            <ul class="app-nav">


                <!-- User Menu-->
                <li><a class="app-nav__item" href="dashboard"><i class='bx bx-log-out bx-rotate-180'></i> </a>

                </li>
            </ul>
        </header>
        <!-- Sidebar menu-->
        <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
        <aside class="app-sidebar">
            <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="admin/images/user.png" width="50px"
                                                alt="User Image">
                <div>
                    <p class="app-sidebar__user-name"><b>images/person_5.jpg</b></p>
                    <p class="app-sidebar__user-designation">Welcome back</p>
                </div>
            </div>
            <hr>
            <ul class="app-menu">
                <li><a class="app-menu__item" href="dashboard"><i class='app-menu__icon bx bx-tachometer'></i><span
                            class="app-menu__label">Dashboard</span></a></li>
                <li><a class="app-menu__item" href="#"><i class='app-menu__icon bx bx-user-voice'></i><span
                            class="app-menu__label">Customer Manager</span></a></li>
                <li><a class="app-menu__item" href="#"><i
                            class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Product Manager</span></a>
                </li>
                <li><a class="app-menu__item" href="#"><i class='app-menu__icon bx bx-task'></i><span
                            class="app-menu__label">Oder Manager</span></a></li>
            </ul>
        </aside>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item active"><a href="#"><b>Product Manager</b></a></li>
                </ul>
                <div id="clock"></div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <div class="tile-body">
                            <div class="row element-button">
                                <div class="col-sm-2">
                                    <a class="btn btn-add btn-sm" href="#" title="Thêm"><i class="fas fa-plus"></i>
                                        Insert a new Product</a>
                                </div>
                                <div class="col-sm-2">
                                    <a class="btn btn-delete btn-sm print-file" type="button" title="In" onclick="myApp.printTable()"><i
                                            class="fas fa-print"></i> Print</a>
                                </div>
                            </div>
                            <form action="productmanager?action=updateproduct" method="POST">
                                <table class="table table-hover table-bordered" id="sampleTable">
                                    <thead>
                                        <tr>
                                            <th>Product ID</th>
                                            <th>Category</th>
                                            <th>Product Name</th>
                                            <th>Price</th>
                                            <th>Size</th>
                                            <th>Color</th>
                                            <th>Description</th>
                                            <th>Quantity</th>
                                            <th>Product Image</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        
                                            <tr>
                                                <td>Sample</td>
                                                <td>Sample</td>
                                                <td>Sample</td>
                                                <td>Sample</td>
                                                <td>Sample</td>
                                                <td>Sample</td>
                                                <td>Sample</td>
                                                <td>Sample</td>
                                                <td>Sample</td>
                                                <td>
                                                    <button class="btn btn-primary btn-sm trash" type="button" title="Delete" "><i
                                                            class="fas fa-trash-alt"></i>
                                                    </button>
                                                    <button class="btn btn-primary btn-sm edit" type="button" title="Edit" id="show-emp"
                                                            data-toggle="modal" data-target="#ModalUP${1}"><i class="fas fa-edit"></i>
                                                    </button>
                                                </td>
                                            </tr>

                                            <!--
                                            MODAL
                                            -->

                                        <div class="modal fade" id="ModalUP${1}" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static"
                                             data-keyboard="false">
                                            <div class="modal-dialog modal-dialog-centered" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-body">
                                                        <div class="row">
                                                            <div class="form-group  col-md-12">
                                                                <span class="thong-tin-thanh-toan">
                                                                    <h5>Edit Product</h5>
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="form-group col-md-6">
                                                                <label class="control-label">Product ID </label>
                                                                <input class="form-control" type="text" readonly name="product_id" value="${1}">
                                                            </div>
                                                            <div class="form-group col-md-6">
                                                                <label for="exampleSelect1" class="control-label">Category</label>
                                                                <select name="category_id" class="form-control" id="exampleSelect1">
                                                                    <option>-- Select Category --</option>
                                                                   
                                                                        <option>Sample</option>
                                                                        <option>Sample</option>
                                                                        <option>Sample</option>
                                                                    
                                                                </select>
                                                            </div>
                                                            <div class="form-group col-md-6">
                                                                <label class="control-label">Product Name</label>
                                                                <input class="form-control" type="text" name="product_name" required>
                                                            </div>
                                                            <div class="form-group col-md-6">
                                                                <label class="control-label">Price</label>
                                                                <input class="form-control" type="number" name="product_price" required>
                                                            </div>
                                                            <div class="form-group col-md-6">
                                                                <label class="control-label">Color</label>
                                                                <input class="form-control" name="product_color" type="text"
                                                                    </div>

                                                                    <div class="form-group col-md-6">
                                                                        <label class="control-label">Size</label>
                                                                        <input class="form-control" name="product_size" type="text">
                                                                    </div>

                                                                    <div class="form-group col-md-6">
                                                                        <label class="control-label">Description</label>
                                                                        <input class="form-control" type="text" name="product_describe">
                                                            </div>

                                                            <div class="form-group col-md-6">
                                                                <label class="control-label">Quantity</label>
                                                                <input class="form-control" type="text" name="product_quantity">
                                                            </div>
                                                            <!--anh san pham-->
                                                            <div class="form-group col-md-12">
                                                                <label class="control-label">Product Image</label>
                                                                <div id="myfileupload">
                                                                    <input type="file" id="uploadfile" name="product_img" onchange="readURL(this);" />
                                                                </div>
                                                                <div id="thumbbox">
                                                                    <img height="450" width="400" alt="Thumb image" id="thumbimage" style="display: none" />
                                                                    <a class="removeimg" href="javascript:"></a>
                                                                </div>
                                                                <div id="boxchoice">
                                                                    <a href="javascript:" class="Choicefile"><i class="fas fa-cloud-upload-alt"></i> Select Image</a>
                                                                    <p style="clear:both"></p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <BR>
                                                        <button class="btn btn-save" type="submit">Save</button>
                                                        <a class="btn btn-cancel" data-dismiss="modal" href="#">Cancel</a>
                                                        <BR>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!--
                                      MODAL
                                        -->
                                    </tbody>
                                </table>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </main>



        <!-- Essential javascripts for application to work-->
        <script src="./js/jquery-3.2.1.min.js"></script>
        <script src="./js/popper.min.js"></script>
        <script src="./js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="./js/main.js"></script>
        <!-- The javascript plugin to display page loading on top-->
        <script src="./js/plugins/pace.min.js"></script>
        <!-- Page specific javascripts-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
        <!-- Data table plugin-->
        <script type="text/javascript" src="./js/plugins/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="./js/plugins/dataTables.bootstrap.min.js"></script>
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
                                                                            nowTime = h + " : " + m + " : " + s ;
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
    </body>

</html>