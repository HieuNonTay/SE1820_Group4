/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.*;
import entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;

/**
 *
 * @author DELL
 */
public class OrderController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {

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
        OrderDAO orderDao = new OrderDAO();
        OrderDetailDAO orderDetailDao = new OrderDetailDAO();

        Vector<Order> listOrder = orderDao.getAll();
        Vector<OrderDetail> listOrderDetail = orderDetailDao.getAll();
        String service = request.getParameter("service");
        if (service == null) {
            service = "nothing";
        }

        String searchQuery = request.getParameter("searchOrderId");
        if (searchQuery != null) {
            try {
                int orderId = Integer.parseInt(searchQuery);
                listOrder = orderDao.getBySql("select * from Order where OrderID =" + orderId + ";");
                request.setAttribute("listOrder", listOrder);
                request.getRequestDispatcher("orderManage.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                request.setAttribute("error", "Vui lòng nhập số hợp lệ");
                request.getRequestDispatcher("errorPage.jsp").forward(request, response);
            }
        } else if (service.equals("updateOrder")) {
            int orderId = Integer.parseInt(request.getParameter("id"));
            Order order = orderDao.getById(orderId);
            request.setAttribute("order", order);
            request.getRequestDispatcher("/JSP/update_order.jsp").forward(request, response);
        } else {
            listOrder = orderDao.getAll();
            request.setAttribute("listOrder", listOrder);
            request.getRequestDispatcher("orderManage.jsp").forward(request, response);
        }
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
//        processRequest(request, response);
        OrderDAO orderDao = new OrderDAO();
        OrderDetailDAO orderDetailDao = new OrderDetailDAO();
        Vector<Order> listOrder = orderDao.getAll();
        Vector<OrderDetail> listOrderDetail = orderDetailDao.getAll();
        String service = request.getParameter("service");

        if (service != null && service.equals("updateOrderAction")) {
            String orderIdStr = request.getParameter("orderId");
            String totalStr = request.getParameter("total");
            String city = request.getParameter("city");
            String status = request.getParameter("status");
            System.out.println(orderIdStr);
            try {
                int orderId = Integer.parseInt(orderIdStr);
                double total = Double.parseDouble(totalStr);
                int update = orderDao.updateOrder(orderId, total, city, status);
                if (update > 0) {
                    response.sendRedirect("admin?service=listOrder");
                } else {
                    response.sendRedirect("order?service=updateOrder");
                }
            } catch (NumberFormatException e) {
                request.setAttribute("error", "Vui lòng nhập một số hợp lệ");
                request.getRequestDispatcher("errorPage.jsp").forward(request, response);
            }
        }
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
