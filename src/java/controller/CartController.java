/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.OrderDAO;
import dao.ProductDAO;
import entity.Product;
import entity.ProductCart;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author ASUS
 */
//cart
@WebServlet(name = "Cart", urlPatterns = {"/CartURL"})
public class CartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        HttpSession session = request.getSession(true);
        ProductDAO dao = new ProductDAO();
        String service = request.getParameter("service");
        ProductDAO productDao = new ProductDAO();
        OrderDAO orderDao = new OrderDAO();
        Enumeration<String> emm = session.getAttributeNames();
        if (service == null) {
            service = "showCart";
        }
        if (service.equals("addToCart")) {
            String id = (String) request.getParameter("id");
            ProductCart productCart = (ProductCart) session.getAttribute(id);
            if (productCart == null) {
                productCart = new ProductCart();
                int productId = Integer.parseInt(id);
                Vector<Product> vec = productDao.getBySql("select * from product where productID = '" + productId + "'");
                Product product = vec.get(0);
                productCart.setProductId(product.getProductId());
                productCart.setName(product.getName());
                productCart.setPrice(product.getPrice());
                productCart.setQuantity(1);
                session.setAttribute(id, productCart);
            } else {
                productCart.setQuantity(productCart.getQuantity() + 1);
                session.setAttribute(id, productCart);
            }
            response.sendRedirect("product");
        }
        if (service.equals("showCart")) {
            request.getRequestDispatcher("/showCart.jsp").forward(request, response);
        }
        if (service.equals("remove")) {
            String id = request.getParameter("id");
            session.removeAttribute(id);
            request.getRequestDispatcher("showCart.jsp").forward(request, response);
        }
        if (service.equals("removeAll")) {
            Vector<String> vecKey = (Vector<String>) session.getAttribute("vecKey");
            if (vecKey != null) {
                for (String string : vecKey) {
                    session.removeAttribute(string);
                }
            }
            request.getRequestDispatcher("showCart.jsp").forward(request, response);
        }
        if (service.equals("update")) {
            Enumeration<String> em = (Enumeration<String>) session.getAttributeNames();
            while (em.hasMoreElements()) {
                String key = em.nextElement();
                if (key.equals("username") || key.equals("vecKey")) {
                    continue;
                } else {
                    int quantity = Integer.parseInt(request.getParameter(key));
                    ProductCart productCart = (ProductCart) session.getAttribute(key);
                    Product product = dao.getById(productCart.getProductId());

                    if (quantity > product.getQuantity()) {
                        request.setAttribute("mess", "Đơn hàng đã được thêm vào tối đa");
                        productCart.setQuantity(product.getQuantity());
                        session.setAttribute(key, productCart);
                        request.getRequestDispatcher("showCart.jsp").forward(request, response);
                        return;
                    } else {
                        productCart.setQuantity(quantity);
                        session.setAttribute(key, productCart);
                    }
                }
            }
            response.sendRedirect("CartURL");
            return;
        }
        if (service.equals("checkOut")) {
            String submit = request.getParameter("submit");
            System.out.println(submit);
            if (submit == null) {
                System.out.println("khong duoc22");
                request.getRequestDispatcher("/checkOut.jsp").forward(request, response);
            } else {
                Enumeration<String> em = session.getAttributeNames();
                int accountId = Integer.parseInt(request.getParameter("accountId"));
//                Account account = accountDao.getByAccountId(accountId);
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String discountCode = request.getParameter("discountCode");
                String line1 = request.getParameter("line1");
                String line2 = request.getParameter("line2");
                String city = request.getParameter("city");
                String province = request.getParameter("province");
                System.out.println("duoc1");

                Vector<ProductCart> listProductCart = new Vector<>();
                boolean enoughQuantity = true;

                while (em.hasMoreElements()) {
                    String key = em.nextElement().toString(); //get key
                    if (key.equals("username") || key.equals("vecKey")) {
                        continue;
                    } else {
                        ProductCart productCart = (ProductCart) session.getAttribute(key);
                        Product product = productDao.getById(productCart.getProductId());
                        if (productCart.getQuantity() > product.getQuantity()) {
                            enoughQuantity = false;
                            request.setAttribute("mess", "Đơn hàng trong kho không đủ để thực hiện yêu cầu");
                        } else {
                            listProductCart.add(productCart);
                            System.out.println("duoc2");
                        }
                    }
                }
                if (enoughQuantity) {
                    int accountIDD = 1;
                    String payment = "Check";
                    int checkOut = orderDao.addOrder(accountIDD, listProductCart, firstName, lastName, discountCode, line1, line2, city, province, payment);
                    if (checkOut > 0) {
                        System.out.println("duoc3");
                        response.sendRedirect("home");
                    } else {
                        System.out.println("khong duoc3");
                        response.sendRedirect("CartURL?service=checkOut");
                    }
                } else {
                    request.getRequestDispatcher("CartURL?service=checkOut").forward(request, response);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
//        HttpSession session = request.getSession(true);
//        String service = request.getParameter("service");
//        ProductDAO productDao = new ProductDAO();
//        OrderDAO orderDao = new OrderDAO();
//        Enumeration<String> emm = session.getAttributeNames();

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public Vector<ProductCart> getSessionCart(HttpServletRequest request) {

        HttpSession session = request.getSession();
        Vector<ProductCart> listBook = new Vector<>();
        Enumeration<String> em = session.getAttributeNames();
        //BookDAO bookDao = new BookDAO();
        while (em.hasMoreElements()) {
            String key = em.nextElement().toString(); //get key
            if (key.equals("user") || key.equals("vecKey")) {
                continue;
            } else {
                listBook.add((ProductCart) session.getAttribute(key));
            }

        }
        return listBook;
    }

}
