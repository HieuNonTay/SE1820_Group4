package controller;

import dao.CategoryDAO;
import dao.ProductDAO;
import entity.Category;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author ASUS
 */
//product
public class ProductController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            HttpSession session = request.getSession(true);
            String service = request.getParameter("service");
            String submit = request.getParameter("submit");
            ProductDAO productDao = new ProductDAO();
            CategoryDAO categoryDAO = new CategoryDAO();
//            List<Map<String, Object>> listProduct = null;
            List<Map<String, Object>> product = null;
//            listProduct = productDao.getAll();
            List<Category> categorys = categoryDAO.getAll("select * from Category");

            if (service == null) {
                service = "product";
            }
            String sql = "select * from product";
            if (submit == null) {
                product = productDao.getAllProductImage();
            } else {

                String productName = request.getParameter("search");
                product = productDao.searchProduct(productName);
//                listProduct.stream().forEach(y -> System.err.println(y));
            }
            request.setAttribute("categorys", categorys);
            request.setAttribute("listProduct", product);
            request.setAttribute("productDao", productDao);
            if (service.equals("product")) {
                request.getRequestDispatcher("/product_list.jsp").forward(request, response);
            } else if (service.equals("category")) {
                int product_id = Integer.parseInt(request.getParameter("product_id"));
                int catedoryID = productDao.findCategoryIdByProductId(product_id);
                List<Map<String, Object>> list = productDao.findProductsByCategoryId(catedoryID);
                request.setAttribute("listProduct", list);
                request.getRequestDispatcher("/product_list.jsp").forward(request, response);
            } else if (service.equals("categoryFilter")) {
                String name = request.getParameter("name");
                List<Category> categorys1 = categoryDAO.searchCategory(name);
                int ca_id = categoryDAO.getCategoryIdByName(name);
                List<Map<String, Object>> list = productDao.findProductsByCategoryId(ca_id);
                request.setAttribute("listProduct", list);
                request.getRequestDispatcher("/product_list.jsp").forward(request, response);
            } else if (service.equals("filterPrice")) {
                String sortOrder = request.getParameter("sortOrder");
                double passPrice = Double.parseDouble(request.getParameter("passPrice"));
                List<Map<String, Object>> list = productDao.filterProductsByPrice(passPrice, sortOrder);
                list.stream().forEach(y -> System.err.println(y));
                request.setAttribute("listProduct", list);
                request.getRequestDispatcher("/product_list.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
