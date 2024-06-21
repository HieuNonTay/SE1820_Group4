/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.OrderDAO;
import entity.Account;
import entity.Order;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Vector;

/**
 *
 * @author ASUS
 */
//historyOrder
public class HistoryOrderController extends HttpServlet {

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
        if (s.getAttribute("acc") == null) {
            request.getRequestDispatcher("403.jsp").forward(request, response);
        }
        Account ch = (Account) s.getAttribute("acc");
        if (!(ch.getRoleID() == 2)) {
            request.getRequestDispatcher("403.jsp").forward(request, response);
        }
        OrderDAO orderDao = new OrderDAO();
        Vector<Order> listOrder = orderDao.getByAccountId(ch.getAccountID());
        request.setAttribute("listOrder", listOrder);
        request.getRequestDispatcher("historyOrder.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
