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
import java.util.List;
import java.util.Vector;

/**
 *
 * @author ASUS
 */
//product
public class ProductDetailController extends HttpServlet {

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
        try {
            HttpSession session = request.getSession(true);
            String action = request.getParameter("action");
            if (action.equalsIgnoreCase("productdetail")) {
                int product_id = Integer.parseInt(request.getParameter("product_id"));
                ProductDAO c = new ProductDAO();
                Product products = c.getById(product_id);
                int category_id = c.findCategoryIdByProductId(product_id);
                String categoryName = c.findCategoryByProductId(category_id);
                System.out.println(categoryName);
                request.setAttribute("ProductData", products);
                request.setAttribute("ProductByCategory", categoryName);
                request.getRequestDispatcher("product_detail.jsp").forward(request, response);
            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            System.out.println(e);
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
