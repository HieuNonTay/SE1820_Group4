/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DisCountDAO;
import dao.ProductDAO;
import entity.Discount;
import entity.Product;
import entity.ProductCart;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author Admin
 */
//@WebServlet(name = "ApplyDiscountController", urlPatterns = {"/discount/apply"})
public class ApplyDiscountController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String code = request.getParameter("code");
        DisCountDAO dao = new DisCountDAO();
        Discount d = dao.getDisCountByCode(code);
        if (d != null) {
            Enumeration<String> em = session.getAttributeNames();
            ProductDAO productDao = new ProductDAO();
            Discount d2 = dao.getProductDiscountByCode(code);
            d.setToDate(d2.getToDate());
            d.setProductId(d2.getProductId());
            if (d.getStatus().equals("activate")) {
                //đã dùng rồi -> k được dùng nữa
                request.setAttribute("error", "Không thể dùng mã này do nó đã được dùng");
                request.getRequestDispatcher("/checkOut.jsp").include(request, response);
            } else {
                LocalDate toDate = LocalDate.parse(convertDateTimeFormat(d.getToDate()));

                LocalDate currentDate = LocalDate.now();
                int result = currentDate.compareTo(toDate);
                if (result > 0) {
                    //hết hạn
                    request.setAttribute("error", "Mã này đã hết hạn");
                    request.getRequestDispatcher("/checkOut.jsp").include(request, response);
                } else {
                    boolean canAdd = false;

                    Vector<Integer> listProductCartId = new Vector<>();
                    while (em.hasMoreElements()) {
                        String key = em.nextElement().toString(); //get key
                        if (key.equals("acc") || key.equals("vecKey") || key.equals("products") || key.equals("functionToast")) {
                            continue;
                        } else {
                            ProductCart productCart = (ProductCart) session.getAttribute(key);
                            Product product = productDao.getById(productCart.getProductId());

                            listProductCartId.add(productCart.getProductId());

                        }
                    }
                    if (listProductCartId.contains(d.getProductId())) {
                        canAdd = true;
                    }
                    if (!canAdd) {
                        request.setAttribute("error", "Không sản phẩm nào trong giỏ hàng có thể dùng mã này");
                        request.getRequestDispatcher("/checkOut.jsp").include(request, response);
                    }
                    //apply

                    request.setAttribute("discount", d);
                    request.setAttribute("isAdded", true);
                    request.setAttribute("message", "Đã áp mã giảm");
                    request.getRequestDispatcher("/CartURL?service=checkOut").include(request, response);
                }
            }
        } else {
            // khong co ma nay
            request.setAttribute("error", "Mã này không tồn tại");
            request.getRequestDispatcher("/checkOut.jsp").include(request, response);
        }
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
