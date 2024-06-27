/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.*;
import entity.*;
import java.util.Vector;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
//home
public class HomeController extends HttpServlet {

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        HttpSession session = request.getSession(true);
        ProductDAO productDao = new ProductDAO();
        BrandDAO brandDao = new BrandDAO();
        Vector<Product> listProduct = productDao.getProductTOP5Sold();
        String cartItemCount = (String) request.getAttribute("cartItemCount");
        request.setAttribute("cartItemCount", cartItemCount);
        String service = request.getParameter("service");
        String submit = request.getParameter("submit");
        
        if(service == null){
            service = "home";
        }
        request.setAttribute("listProduct", listProduct);
        if(service.equals("shop")){
            request.getRequestDispatcher("/product_list.jsp").forward(request, response);
        }
        if(service.equals("home")){
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        }
//        request.getRequestDispatcher("/homePage.jsp").forward(request, response);
        
        
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
