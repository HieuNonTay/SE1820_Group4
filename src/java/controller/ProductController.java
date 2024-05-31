package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import dao.ProductDAO;
import entity.Product;
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
//product
public class ProductController extends HttpServlet {

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
        String service = request.getParameter("service");
        String submit = request.getParameter("submit");
        ProductDAO producDao = new ProductDAO();
        Vector<Product> listProduct = producDao.getAll();
        if (submit == null) {
            listProduct = producDao.getAll();
        } else {
            String title = request.getParameter("search");
//            String typeSearch = request.getParameter("typeSearch");
//            if (typeSearch.equals("price")) {
//                listBook = bookDao.getBySql("select * from book where price =" + title + "");
//            } else {
            listProduct = producDao.getBySql("select * from book where title like '%" + title + "%'");
//            }
        }
        if (service == null) {
            service = "product";
        }
        request.setAttribute("listProduct", listProduct);
        if (service.equals("product")) {
            request.getRequestDispatcher("/product.jsp").forward(request, response);
        }
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
