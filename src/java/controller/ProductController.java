package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
<<<<<<< Updated upstream
import dao.ProductDAO;
=======
import dao.CategoryDAO;
import dao.ProductDAO;
import entity.Category;
>>>>>>> Stashed changes
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
<<<<<<< Updated upstream
import java.util.Vector;
=======
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import java.util.stream.Collectors;
>>>>>>> Stashed changes

/**
 *
 * @author ASUS
 */
//product
public class ProductController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
<<<<<<< Updated upstream
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

=======
        try {
            HttpSession session = request.getSession(true);
            String service = request.getParameter("service");
            String submit = request.getParameter("submit");
            ProductDAO productDao = new ProductDAO();
            CategoryDAO categoryDAO = new CategoryDAO();
            Vector<Product> listProduct;
            listProduct = productDao.getAll();
            List<Category> categorys = categoryDAO.getAll("select * from Category");

            if (service == null) {
                service = "product";
            }
            String sql = "select * from product";
            if (submit == null) {
                listProduct = productDao.getAll();
            } else {

                String productName = request.getParameter("search");
                listProduct = productDao.searchProduct(productName);
                System.out.println("duoc");
            }
            request.setAttribute("categorys", categorys);
            request.setAttribute("listProduct", listProduct);
            if (service.equals("product")) {
                request.getRequestDispatcher("/product_list.jsp").forward(request, response);
            } else if (service.equals("category")) {
                int product_id = Integer.parseInt(request.getParameter("product_id"));
                int catedoryID = productDao.findCategoryIdByProductId(product_id);
                List<Product> list = productDao.findProductsByCategoryId(catedoryID);
                request.setAttribute("listProduct", list);
                request.getRequestDispatcher("/product_list.jsp").forward(request, response);
            } else if (service.equals("categoryFilter")) {
                String name = request.getParameter("name");
                List<Category> categorys1 = categoryDAO.searchCategory(name);
                int ca_id = categoryDAO.getCategoryIdByName(name);
                List<Product> list = productDao.findProductsByCategoryId(ca_id);
                request.setAttribute("listProduct", list);
                request.getRequestDispatcher("/product_list.jsp").forward(request, response);
            } else if (service.equals("filterPrice")) {
                String sortOrder = request.getParameter("sortOrder");
                double passPrice = Double.parseDouble(request.getParameter("passPrice"));
                System.out.println(passPrice);
                System.out.println("hello");
                System.out.println(sortOrder);
                List<Product> list = productDao.filterProductsByPrice(passPrice, sortOrder);
                request.setAttribute("listProduct", list);
                request.getRequestDispatcher("/product_list.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
>>>>>>> Stashed changes
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
<<<<<<< Updated upstream
//        processRequest(request, response);
        HttpSession session = request.getSession(true);
        String service = request.getParameter("service");
        String submit = request.getParameter("submit");
        ProductDAO productDao = new ProductDAO();
        Vector<Product> listProduct;
        listProduct = productDao.getAll();
        if (service == null) {
            service = "product";
        }
        String sql = "select * from product";
        if (submit == null) {
            listProduct = productDao.getAll();
        } else {

            String productName = request.getParameter("search");
            listProduct = productDao.searchProduct(productName);
            System.out.println("duoc");
        }

        request.setAttribute("listProduct", listProduct);
        if (service.equals("product")) {
            request.getRequestDispatcher("/product_list.jsp").forward(request, response);
        }
=======
        processRequest(request, response);

>>>>>>> Stashed changes
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
