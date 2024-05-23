<%-- 
    Document   : ShowCart
    Created on : May 23, 2024, 8:56:17 PM
    Author     : DELL
--%>
<%@page import="entity.*, java.util.*, java.text.DecimalFormat" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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
    </body>
</html>
