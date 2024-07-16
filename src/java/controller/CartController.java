/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DisCountDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import entity.Account;
import entity.Discount;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
        HttpSession s = request.getSession();
//        if (s.getAttribute("acc") == null) {
//            request.getRequestDispatcher("403.jsp").forward(request, response);
//        }
//        Account ch = (Account) s.getAttribute("acc");
//        if (!(ch.getRoleID() == 1 || ch.getRoleID() == 3)) {
//            request.getRequestDispatcher("403.jsp").forward(request, response);
//        }
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
                if (key.equals("acc") || key.equals("vecKey") || key.equals("products") || key.equals("functionToast")) {
                    continue;
                } else {
                    int quantity = Integer.parseInt(request.getParameter(key));
                    ProductCart productCart = (ProductCart) session.getAttribute(key);
                    Product product = dao.getById(productCart.getProductId());
                    if (quantity <= 0) {
                        int id = productCart.getProductId();
                        session.removeAttribute(key);
                        response.sendRedirect("CartURL");
                        return;
                    }
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
            if (s.getAttribute("acc") == null) {
                request.getRequestDispatcher("403.jsp").forward(request, response);
            }
            Account acc = (Account) s.getAttribute("acc");
            if (!(acc.getRoleID() == 2)) {
                request.getRequestDispatcher("403.jsp").forward(request, response);
            } else {

                request.getRequestDispatcher("checkOut.jsp").forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        HttpSession session = request.getSession(true);
        String service = request.getParameter("service");
        ProductDAO productDao = new ProductDAO();
        DisCountDAO dao = new DisCountDAO();
        OrderDAO orderDao = new OrderDAO();
        Enumeration<String> emm = session.getAttributeNames();
        if (service.equals("checkOut")) {
            String submit = request.getParameter("submit");
            if (submit == null) {
                request.getRequestDispatcher("/checkOut.jsp").forward(request, response);
            } else {
                Enumeration<String> em = session.getAttributeNames();
                int accountId = Integer.parseInt(request.getParameter("accountId"));
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String discountCode = request.getParameter("discountCode");
                String line1 = request.getParameter("line1");
                String line2 = request.getParameter("line2");
                String city = request.getParameter("city");
                String province = request.getParameter("province");

                Vector<ProductCart> listProductCart = new Vector<>();
                Vector<Integer> listProductCartId = new Vector<>();
                boolean enoughQuantity = true;

                while (em.hasMoreElements()) {
                    String key = em.nextElement().toString(); //get key
                    if (key.equals("acc") || key.equals("vecKey")) {
                        continue;
                    } else {
                        ProductCart productCart = (ProductCart) session.getAttribute(key);
                        Product product = productDao.getById(productCart.getProductId());
                        if (productCart.getQuantity() > product.getQuantity()) {
                            enoughQuantity = false;
                            request.setAttribute("mess", "Đơn hàng trong kho không đủ để thực hiện yêu cầu");
                        } else {
                            listProductCart.add(productCart);
                            listProductCartId.add(productCart.getProductId());
                        }
                    }
                }
                if (enoughQuantity) {
                    int accountIDD = 2;
                    String payment = "Check";
                    double grandTotal = 0;
                    Discount d = null;
                    if (discountCode != null && !discountCode.trim().equals("")) {
                        //check discount
                        d = dao.getDisCountByCode(discountCode);
                        if (d != null) {
                            Discount d2 = dao.getProductDiscountByCode(discountCode);
                            d.setToDate(d2.getToDate());
                            d.setProductId(d2.getProductId());
                            if (d.getStatus().equals("activate")) {
                                //đã dùng rồi -> k được dùng nữa
                                request.setAttribute("error", "Không thể dùng mã này do nó đã được dùng");
                                request.getRequestDispatcher("/checkOut.jsp").include(request, response);
                                return;
                            } else {
                                LocalDate toDate = LocalDate.parse(convertDateTimeFormat(d.getToDate()));

                                LocalDate currentDate = LocalDate.now();
                                int result = currentDate.compareTo(toDate);
                                if (result > 0) {
                                    //hết hạn
                                    request.setAttribute("error", "Mã này đã hết hạn");
                                    request.getRequestDispatcher("/checkOut.jsp").include(request, response);
                                    return;
                                }
                                if (!listProductCartId.contains(d.getProductId())) {
                                    request.setAttribute("error", "Không sản phẩm nào trong giỏ hàng có thể dùng mã này");
                                    request.getRequestDispatcher("/checkOut.jsp").include(request, response);
                                    return;
                                }
                            }
                        } else {
                            // khong co ma nay
                            request.setAttribute("error", "Mã không tồn tại");
                            request.getRequestDispatcher("/checkOut.jsp").include(request, response);
                            return;
//                            request.getRequestDispatcher("/SE1820_Group4/checkOut.jsp").include(request, response);
                        }
                    }
                    for (ProductCart productCart : listProductCart) {
                        if (d != null && productCart.getProductId() == d.getProductId()) {
                            grandTotal += productCart.getPrice() * productCart.getQuantity() * ((100 - d.getAmount()) / 100);
                        } else {
                            grandTotal += productCart.getPrice() * productCart.getQuantity();
                        }
                    }
                    int checkOut = orderDao.addOrder(accountIDD, listProductCart, firstName, lastName, (discountCode == null || discountCode.trim().equals("")) ? null : discountCode, line1, line2, city, province, payment, grandTotal);
                    if (checkOut > 0) {
                        if (discountCode != null && !discountCode.trim().equals("")) {
                            //update status discount
                            dao.updateStatusDiscount("activate", discountCode);
                        }

                        response.sendRedirect("/SE1820_Group4/home");
                        return;
                    } else {
                        response.sendRedirect("/SE1820_Group4/CartURL?service=checkOut");
                        return;
                    }
                } else {
                    request.getRequestDispatcher("/SE1820_Group4/CartURL?service=checkOut").forward(request, response);
                    return;
                }
            }
        }

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
            if (key.equals("acc") || key.equals("vecKey")) {
                continue;
            } else {
                listBook.add((ProductCart) session.getAttribute(key));
            }

        }
        return listBook;
    }

    private String convertDateTimeFormat(String inputDateTime) {
        if (inputDateTime == null) {
            return null;
        } else {
            DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                java.util.Date date = inputFormat.parse(inputDateTime);
                return outputFormat.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

}
