<%-- 
    Document   : update_order
    Created on : 9 thg 6, 2024, 21:03:44
    Author     : DELL
--%>
<%@page import="java.sql.ResultSet, entity.*, dao.*, java.util.*, java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageSize" value="9" />
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Store Order List</title>
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

    </head>

    <body onload="time()" class="app sidebar-mini rtl">
        <!-- Navbar-->
        <jsp:include page="Sidebar.jsp"/>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item active"><a href="#"><b>Order Manager</b></a></li>
                </ul>
                <div id="clock"></div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <div class="tile-body">
                            <div class="container" style="margin-top: 10px">
                                <div class="row mb-3">
                                    <div class="col-md-6">
                                        <form action="order" method="get" class="position-relative">
                                            <div class="input-group">
                                                <input name="searchOrderId" value="${searchQuery}" class="form-control border-secondary py-3 rounded-start" type="text" placeholder="Enter what you want to find">
                                                <button type="submit" value="submit" class="btn btn-primary py-3 px-4 rounded-end">Search</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <table class="table table-hover table-bordered" id="sampleTable">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <table class="table table-bordered table-striped">
                                                <thead class="thead-dark">
                                                    <tr>
                                                        <th scope="col">Account ID</th>
                                                        <th scope="col">First Name</th>
                                                        <th scope="col">Last Name</th>
                                                        <th scope="col">Order Date</th>
                                                        <th scope="col">Phone Number</th>
                                                        <th scope="col">Address</th>
                                                        <th scope="col">City</th>
                                                        <th scope="col">Total</th>
                                                        <th scope="col">Status</th>
                                                        <th scope="col">View</th>
                                                        <th scope="col">Update</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <% 
                                                        Vector<Order> listOrder = (Vector<Order>) request.getAttribute("listOrder");
                                                        DecimalFormat df = new DecimalFormat("#,###");
                                                        for (Order order : listOrder) { 
                                                        
                                                    %>
                                                <form action="order?service=updateStatus" method="post">
                                                    <input type="hidden" name="orderId" value="<%= order.getOrderId()%>">
                                                    <tr>
                                                        <td><%= order.getAccountId()%></td>
                                                        <td><%= order.getFirstName()%></td>
                                                        <td><%= order.getLastName()%></td>
                                                        <td><%= order.getOrderdate()%></td>
                                                        <td><%= order.getLine1()%></td>
                                                        <td><%= order.getLine2()%></td>
                                                        <td><%= order.getCity()%></td>
                                                        <td><%=df.format(order.getTotal()).replace(",", ".")%> VND</td>

                                                        <td>
                                                            <label for="status"></label>
                                                            <select class="form-control" id="status" name="status">
                                                                <option value="Pending" <%= order.getStatus().equals("Pending") ? "selected" : "" %>>Pending</option>
                                                                <option value="Delivering" <%= order.getStatus().equals("Delivering") ? "selected" : "" %>>Delivering</option>
                                                                <option value="Delivered" <%= order.getStatus().equals("Delivered") ? "selected" : "" %>>Delivered</option>
                                                                <option value="Cancelled" <%= order.getStatus().equals("Cancelled") ? "selected" : "" %>>Cancelled</option>
                                                            </select></td>
                                                        <td>
                                                            <a href="order?service=View&id=<%= order.getOrderId()%>" class="btn btn-sm btn-primary">View</a>
                                                        </td>
                                                        <td>
                                                            <button type="submit" class="btn btn-sm btn-primary">Update</button>
                                                        </td>
                                                    </tr>
                                                </form>
                                                <% } %>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
        </main>     



        <!-- Essential javascripts for application to work-->
        <script src="admin/js/jquery-3.2.1.min.js"></script>
        <script src="admin/js/popper.min.js"></script>
        <script src="admin/js/bootstrap.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="admin/js/main.js"></script>
        <!-- The javascript plugin to display page loading on top-->
        <!-- Page specific javascripts-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
        <!-- Data table plugin-->
        <script type="text/javascript" src="admin/js/plugins/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript">$('#sampleTable').DataTable();</script>
        <script>
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
                nowTime = h + " : " + m + " : " + s + "";
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