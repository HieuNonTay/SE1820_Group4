<%-- 
    Document   : product
    Created on : May 24, 2024, 8:06:14 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.ResultSet, entity.*, dao.*, java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">BrandID</th>
                    <th scope="col">CategoryID</th>
                    <th scope="col">getDescription</th>
                    <th scope="col">getPrice</th>
                    <th scope="col">getQuantity</th>
                    <th scope="col">getPublicationDate</th>
                    <th scope="col">Status</th>
                    <th>update</th>
                    <th>delete</th>
                    <th>add2Card</th>

                </tr>
            </thead>
            <tbody>
                <% Vector<Product> listProduct = (Vector<Product>) request.getAttribute("listProduct");
                for (Product product : listProduct) {
                %>
                <tr>
                    <td><%= product.getProductId()%></td>
                    <td><%= product.getName()%></td>
                    <td><%= product.getBrandId()%></td>
                    <td><%= product.getCatergoryId()%></td>
                    <td><%= product.getDescription()%></td>
                    <td><%= product.getPrice()%></td>
                    <td><%= product.getQuantity()%></td>
                    <td><%= product.getPublicationDate()%></td>
                    <td><%= product.getStatus()%></td>

                    <td><a href="product?service=update&id=<%=product.getProductId()%>">update</a></td>
                    <td><a href="product?service=delete&id=<%=product.getProductId()%>">delete</a></td>
                    <td><a href="cart?service=addToCart&id=<%=product.getProductId()%>">add2Card</a></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>
