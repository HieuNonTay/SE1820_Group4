<%-- 
    Document   : customer
    Created on : Oct 19, 2021, 11:20:59 PM
    Author     : Khuong Hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Admin Dashboard | Admin</title>
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
        <link href="admin/css/style.css" rel="stylesheet">
    </head>

    <body onload="time()" class="app sidebar-mini rtl">
        <!-- Navbar-->
        <jsp:include page="Sidebar.jsp"/>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item active"><a href="#"><b>Account Manager</b></a></li>
                </ul>
                <div id="clock"></div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <div class="tile-body">



                            <table class="table table-hover table-bordered js-copytextarea" cellpadding="0" cellspacing="0" border="0"
                                   id="sampleTable">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>Email</th>
                                        <th>Phone</th>
                                        <th>Role</th>
                                        <th>Status</th>
                                        <th width="70">Feature</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listAcc}" var="acc">
                                        <tr>
                                            <td>${acc.accountID}</td>
                                            <td>${acc.fname}</td>
                                            <td>${acc.lname}</td>
                                            <td>${acc.email}</td>
                                            <td>${acc.phone}</td>

                                            <td>
                                                <c:choose>
                                                    <c:when test="${acc.roleID == 1}">
                                                        Admin
                                                    </c:when>
                                                    <c:when test="${acc.roleID == 2}">
                                                        Customer
                                                    </c:when>
                                                    <c:when test="${acc.roleID == 3}">
                                                        Staff News
                                                    </c:when>
                                                    <c:when test="${acc.roleID == 4}">
                                                        Staff Product
                                                    </c:when>
                                                    <c:when test="${acc.roleID == 5}">
                                                        Staff Account
                                                    </c:when>

                                                    <c:otherwise></c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>${acc.status}</td>
                                            <td><button class="btn btn-primary btn-sm edit" type="button" title="Sửa" id="show-emp" data-toggle="modal"
                                                        data-target="#ModalUP${acc.accountID}"><i class="fas fa-edit"></i></button></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
        </main>
        <c:forEach items="${listAcc}" var="acc">           
            <div class="modal fade" id="ModalUP${acc.accountID}" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static"
                 data-keyboard="false">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <form method="POST" action="accountmanager?action=update">
                            <div class="modal-body">
                                <div class="row">
                                    <div class="form-group col-md-12">
                                        <span class="thong-tin-thanh-toan">
                                            <h5>Account Info</h5>
                                        </span>
                                    </div>
                                </div>
                                <p class="text-danger">${mess}</p>
                                <div class="row">
                                    <div class="form-group col-md-12">
                                        <label for="exampleSelect1" class="control-label">Role</label>
                                        <input hidden name="user_id" value="${acc.accountID}">
                                        <select name="role" class="form-control" id="exampleSelect1">                       
                                            <option value="1">Admin</option>
                                            <option value="5">Staff Account</option>
                                            <option value="4">Staff Product</option>
                                            <option value="3">Staff News</option> 
                                            <option value="2">Customer</option>
                                        </select>
                                        <label for="email" class="control-label">Email</label>
                                        <input name="email" readonly value="${acc.email}" class="form-control" required>
                                        <label for="fname" class="control-label">First Name</label>
                                        <input name="fname" type="text" value="${acc.fname}" class="form-control" required>
                                        <label for="lname" class="control-label">Last Name</label>
                                        <input name="lname" type="text" value="${acc.lname}" class="form-control" required> 
                                        <label for="dob" class="control-label">Dob</label>
                                        <input name="dob" type="date" value="${acc.dob}" class="form-control" required>
                                        <label for="phone" class="control-label">Phone</label>
                                        <input name="phone" type="text" value="${acc.phone}" class="form-control" required>
                                        <label for="address" class="control-label">Address</label>
                                        <input name="address"  type="text" value="${acc.address}" class="form-control" required>
                                        <label for="status" class="control-label">Status</label>
                                        <select name="status" class="form-control">
                                            <option value="Active">Active</option>
                                            <option value="Inactive">Inactive</option>
                                        </select>
                                    </div>
                                </div>
                                <br>
                                <button class="btn btn-save" type="submit">Save</button>
                                <a class="btn btn-cancel" data-dismiss="modal" href="#">Exit</a>
                                <br>
                            </div>
                        </form>
                        <div class="modal-footer">
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        <!-- Essential javascripts for application to work-->
        <script src="admin/js/jquery-3.2.1.min.js"></script>
        <script src="admin/js/popper.min.js"></script>
        <script src="admin/js/bootstrap.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="admin/js/main.js"></script>
        <!-- The javascript plugin to display page loading on top-->
        <script src="admin/js/plugins/pace.min.js"></script>
        <!-- Page specific javascripts-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
        <!-- Data table plugin-->
        <script type="text/javascript" src="admin/js/plugins/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="admin/js/plugins/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript">$('#sampleTable').DataTable();</script>
        <script>
            function deleteRow(r) {
                var i = r.parentNode.parentNode.rowIndex;
                document.getElementById("myTable").deleteRow(i);
            }
            jQuery(function () {
                jQuery(".trash").click(function () {
                    swal({
                        title: "Cảnh báo",

                        text: "Bạn có chắc chắn là muốn xóa nhân viên này?",
                        buttons: ["Hủy bỏ", "Đồng ý"],
                    })
                            .then((willDelete) => {
                                if (willDelete) {
                                    swal("Đã xóa thành công.!", {

                                    });
                                }
                            });
                });
            });

            //Thời Gian
            function time() {
                var today = new Date();
                var weekday = new Array(7);
                weekday[0] = "Sunday";
                weekday[1] = "Monday";
                weekday[2] = "Tuesday";
                weekday[3] = "Wensday";
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
                nowTime = h + " giờ " + m + " phút " + s + " giây";
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
            //In dữ liệu
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
