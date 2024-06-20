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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderDAO orderDao = new OrderDAO();
        OrderDetailDAO orderDetailDao = new OrderDetailDAO();

        Vector<Order> listOrder = orderDao.getAll();
        Vector<OrderDetail> listOrderDetail = orderDetailDao.getAll();
        String service = request.getParameter("service");
        String submit = request.getParameter("submit");
        if (service == null) {
            service = "nothing";
        }

        String searchQuery = request.getParameter("searchOrderId");
        if (searchQuery != null) {
            listOrder = orderDao.searchOrder(searchQuery);
            request.setAttribute("searchQuery", searchQuery);
            request.setAttribute("listOrder", listOrder);
            request.getRequestDispatcher("orderManage.jsp").forward(request, response);

        } else if (service.equals("View")) {
            int orderId = Integer.parseInt(request.getParameter("id"));
            Order order = orderDao.getById(orderId);
            listOrderDetail = orderDetailDao.getBySql("select * from OrderDetail Where OrderID = " + orderId + ";");
            request.setAttribute("order", order);
            request.setAttribute("listOrderDetail", listOrderDetail);
            request.getRequestDispatcher("/JSP/update_order.jsp").forward(request, response);
        } else {
            listOrder = orderDao.getAll();
            request.setAttribute("listOrder", listOrder);
            request.getRequestDispatcher("orderManage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        OrderDAO orderDao = new OrderDAO();
        OrderDetailDAO orderDetailDao = new OrderDetailDAO();
        Vector<Order> listOrder = orderDao.getAll();
        Vector<OrderDetail> listOrderDetail = orderDetailDao.getAll();
        String service = request.getParameter("service");
        if (service == null) {
            service = "nothing";
        }

        if (service != null && service.equals("updateOrderAction")) {
            String orderIdStr = request.getParameter("orderId");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String totalStr = request.getParameter("total");
            String city = request.getParameter("city");
            String status = request.getParameter("status");
            System.out.println(orderIdStr);
            try {
                int orderId = Integer.parseInt(orderIdStr);
                double total = Double.parseDouble(totalStr);
                int update = orderDao.updateStatus(orderId, status);
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
        if (service.equals("updateStatus")) {
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            String status = request.getParameter("status");

            int update = orderDao.updateStatus(orderId, status);
            if (update > 0) {
                System.out.println("duoc");
                response.sendRedirect("order");
            } else {
                System.out.println("chua duoc");
                response.sendRedirect("order");
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
