/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoryDAO;
import dao.ProductDAO;
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
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Vector;
import java.sql.Timestamp;

@MultipartConfig
public class AddProductController extends HttpServlet {

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
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=UTF-8");
//        String action = request.getParameter("action");
        try {
            String category_id = request.getParameter("category_id");
            String brand_id = request.getParameter("brand_id");
            String product_name = request.getParameter("product_name");
            String product_model = request.getParameter("product_model");
            String product_price = request.getParameter("price");
            String product_size = request.getParameter("size");
            String product_color = request.getParameter("color");
            String product_quantity = request.getParameter("quantity");
            String product_describe = request.getParameter("describe");
            int quantity = Integer.parseInt(product_quantity);
            int brandId = Integer.parseInt(brand_id);
            double price = Double.parseDouble(product_price);
            int cid = Integer.parseInt(category_id);
            ProductDAO productDao = new ProductDAO();
            Timestamp publicationDate = new Timestamp(System.currentTimeMillis());
            Timestamp createdAt = new Timestamp(System.currentTimeMillis());
            Timestamp updatedAt = new Timestamp(System.currentTimeMillis());

//            Part filePart = request.getPart("product_img");
//            String imageFileName = filePart.getSubmittedFileName();
//            String uploadPath = "E:/Ki5/SWP391/NeatBean/SE1820_Group4/web/assets/custom/images" + imageFileName;
//            System.out.println(uploadPath);
//            // Handle file upload
//            File uploadDir = new File(getServletContext().getRealPath("") + "images");
//            if (!uploadDir.exists()) {
//                uploadDir.mkdir();
//            }
            Part file = request.getPart("product_img");
            String imageFileName = file.getSubmittedFileName();
            String uploadPath = "E:/Ki5/SWP391/NeatBean/SE1820_Group4/web/assets/custom/images/" + imageFileName;
            FileOutputStream fos = new FileOutputStream(uploadPath);
            InputStream is = file.getInputStream();
            byte[] data = new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            Product product = new Product(product_name, product_model, brandId, cid, 1, 1, product_describe, price, quantity, 0, 0, publicationDate, createdAt, updatedAt);
            productDao.insertProduct(product, "assets/custom/images/" + imageFileName);
            response.sendRedirect("productmanager?action=back");

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
