/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoryDAO;
import dao.ProductDAO;
import entity.Brand;
import entity.Category;
import entity.Color;
import entity.Product;
import entity.Size;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Vector;
import java.sql.Timestamp;

/**
 *
 * @author Khuong Hung
 */
public class ProductManagerController extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        System.out.println("action");
        System.out.println(action);
        try {

            HttpSession session = request.getSession();

            if (action == null || action.equalsIgnoreCase("back")) {
                ProductDAO productDao = new ProductDAO();
                CategoryDAO categoryDAO = new CategoryDAO();
                List<Product> listProduct;
                List<Brand> brands;
                brands = productDao.getBrands("select * from brand");
                listProduct = productDao.getAllProduct();
                List<Category> category = categoryDAO.getAll("select * from Category");
                request.setAttribute("CategoryData", category);
                request.setAttribute("ProductData", listProduct);
                request.setAttribute("BrandData", brands);
                request.getRequestDispatcher("/admin/product.jsp").forward(request, response);
            } else if (action.equalsIgnoreCase("insert")) {
                List<Brand> brands;
                ProductDAO productDao = new ProductDAO();
                brands = productDao.getBrands("select * from brand");
                CategoryDAO categoryDAO = new CategoryDAO();
                List<Category> category = categoryDAO.getAll("select * from Category");
                request.setAttribute("CategoryData", category);
                request.setAttribute("BrandData", brands);
                request.getRequestDispatcher("/admin/productinsert.jsp").forward(request, response);
            } else if (action.equalsIgnoreCase("deleteproduct")) {
                String product_id = request.getParameter("product_id");
                int id = Integer.parseInt(product_id);
                ProductDAO productDao = new ProductDAO();
                productDao.deleteProductById(id);
                response.sendRedirect("productmanager");
            }
        } catch (Exception e) {
            response.sendRedirect("404.jsp");
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
