/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.dashboard;

import dao.AccountDAO;
import dao.DashBoardDAO;
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
//dashboard
public class DashBoardController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DashBoardController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DashBoardController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        DashBoardDAO dashBoardDao = new DashBoardDAO();
        request.setAttribute("countTotalCusomters", dashBoardDao.getTotalUsers(2));
        request.setAttribute("countTotalProducts", dashBoardDao.getTotalProducts());
        request.setAttribute("countTotalOrders", dashBoardDao.getTotalOrders());
        request.setAttribute("countTotalOrdersInDay", dashBoardDao.getTotalOrdersInDay(7));
        Vector<Order> listOrder1Week = dashBoardDao.listOrder1week();
        request.setAttribute("listOrder1Week", listOrder1Week);
        HttpSession session = request.getSession();
        Object role = session.getAttribute("roleID");
        int roleID = (Integer) role;
        AccountDAO accDao = new AccountDAO();
        String roleName = accDao.getRoleName(roleID);
        session.setAttribute("roleName", roleName);
        request.getRequestDispatcher("admin/index.jsp").forward(request, response);
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
