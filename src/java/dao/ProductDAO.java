/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Category;
import entity.Color;
import entity.Product;
import entity.Size;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DBContext;

/**
 *
 * @author ASUS
 */
public class ProductDAO extends DBContext {

    public Vector<Product> getAll() {
        String sql = "select [ProductID], [Name], [Categoryid], [BrandID], [Description], [model], "
                + "[SizeID], [ColorID], [Quantity], [sold], [view], [PublicationDate],[createdAt],[updatedAt],Price from Product";
        Vector<Product> vector = new Vector<>();
        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int productId = rs.getInt(1);
                String name = rs.getNString(2);
                String model = rs.getNString(3);
                int brandId = rs.getInt(4);
                int categoryId = rs.getInt(5);
                int colorId = rs.getInt(6);
                int sizeId = rs.getInt(7);
                String description = rs.getNString(8);
                double price = rs.getDouble(9);
                int quantity = rs.getInt(10);
                int sold = rs.getInt(11);
                int view = rs.getInt(12);
                Timestamp publicationDate = rs.getTimestamp(13);
                Timestamp createdAt = rs.getTimestamp(14);
                Timestamp updatedAt = rs.getTimestamp(15);

                vector.add(new Product(productId, name, model, brandId, categoryId, colorId, sizeId, description, price, quantity, sold, view, publicationDate, createdAt, updatedAt));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Vector<Product> getBySql(String sql) {
        Vector<Product> vector = new Vector<>();
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int productId = rs.getInt(1);
                String name = rs.getNString(2);
                String model = rs.getNString(3);
                int brandId = rs.getInt(4);
                int categoryId = rs.getInt(5);
                int colorId = rs.getInt(6);
                int sizeId = rs.getInt(7);
                String description = rs.getNString(8);
                double price = rs.getDouble(9);
                int quantity = rs.getInt(10);
                int sold = rs.getInt(11);
                int view = rs.getInt(12);
                Timestamp publicationDate = rs.getTimestamp(13);
                Timestamp createdAt = rs.getTimestamp(14);
                Timestamp updatedAt = rs.getTimestamp(15);

                vector.add(new Product(productId, name, model, brandId, categoryId, colorId, sizeId, description, price, quantity, sold, view, publicationDate, createdAt, updatedAt));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Product getById(int id) {
        String sql = "Select * From Product a Where a.ProductID = ?;";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                int productId = rs.getInt(1);
                String name = rs.getNString(2);
                String model = rs.getNString(3);
                int brandId = rs.getInt(4);
                int categoryId = rs.getInt(5);
                int colorId = rs.getInt(6);
                int sizeId = rs.getInt(7);
                String description = rs.getNString(8);
                double price = rs.getDouble(9);
                int quantity = rs.getInt(10);
                int sold = rs.getInt(11);
                int view = rs.getInt(12);
                Timestamp publicationDate = rs.getTimestamp(13);
                Timestamp createdAt = rs.getTimestamp(14);
                Timestamp updatedAt = rs.getTimestamp(15);

                return new Product(productId, name, model, brandId, categoryId, colorId, sizeId, description, price, quantity, sold, view, publicationDate, createdAt, updatedAt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Vector<Product> searchProduct(String name) {
        Vector<Product> vector = new Vector<>();
        String sql = "select * from product where name like '%" + name + "%'";
        vector = getBySql(sql);
        return vector;
    }

    public List<Size> getSizeByID(int product_id) {
        List<Size> list = new ArrayList<>();
        String sql = "select * from product_size where product_id=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, product_id);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                list.add(new Size(rs.getInt(1), rs.getInt(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Color getColorByID(int product_id) {

        String sql = "select * from Color where ColorID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, product_id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                return new Color(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public String findCategoryByProductId(int productId) {
        String sql = "SELECT c.CategoryName FROM Category c \n"
                + "JOIN Product p ON p.CategoryID = c.CategoryID WHERE p.CategoryID = ?";
        try (PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setInt(1, productId);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                return rs.getString("CategoryName");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Integer findCategoryIdByProductId(int productId) {
        String sql = "SELECT CategoryID FROM Product WHERE ProductID = ?;";
        try (PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setInt(1, productId);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                return rs.getInt("CategoryID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Product> findProductsByCategoryId(int categoryId) {
        String sql = "SELECT * FROM Product WHERE CategoryID = ?;";
        List<Product> products = new ArrayList<>();

        try (PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setInt(1, categoryId);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                int productId = rs.getInt(1);
                String name = rs.getNString(2);
                String model = rs.getNString(3);
                int brandId = rs.getInt(4);
                int categoryID = rs.getInt(5);
                int colorId = rs.getInt(6);
                int sizeId = rs.getInt(7);
                String description = rs.getNString(8);
                double price = rs.getDouble(9);
                int quantity = rs.getInt(10);
                int sold = rs.getInt(11);
                int view = rs.getInt(12);
                Timestamp publicationDate = rs.getTimestamp(13);
                Timestamp createdAt = rs.getTimestamp(14);
                Timestamp updatedAt = rs.getTimestamp(15);

                products.add(new Product(productId, name, model, brandId, categoryID, colorId, sizeId, description, price, quantity, sold, view, publicationDate, createdAt, updatedAt));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return products;
    }

    public List<Product> filterProductsByPrice(double passPrice, String sortOrder) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Product";

        // Add the price condition if passPrice is greater than 0
        if (passPrice > 0) {
            sql += " WHERE Price < ?";
        }

        // Append sorting order to the query if specified
        if ("ascending".equals(sortOrder)) {
            sql += " ORDER BY Price ASC";
        } else if ("decreasing".equals(sortOrder)) {
            sql += " ORDER BY Price DESC";
        }

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Set the price parameter if passPrice is greater than 0
            if (passPrice > 0) {
                pstmt.setDouble(1, passPrice);
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int productId = rs.getInt("ProductID");
                    String name = rs.getNString("Name");
                    String model = rs.getNString("model");
                    int brandId = rs.getInt("BrandID");
                    int categoryId = rs.getInt("CategoryID");
                    int colorId = rs.getInt("ColorID");
                    int sizeId = rs.getInt("SizeID");
                    String description = rs.getNString("Description");
                    double price = rs.getDouble("Price");
                    int quantity = rs.getInt("Quantity");
                    int sold = rs.getInt("sold");
                    int view = rs.getInt("view");
                    Timestamp publicationDate = rs.getTimestamp("PublicationDate");
                    Timestamp createdAt = rs.getTimestamp("createdAt");
                    Timestamp updatedAt = rs.getTimestamp("updatedAt");

                    Product product = new Product(productId, name, model, brandId, categoryId, colorId, sizeId, description, price, quantity, sold, view, publicationDate, createdAt, updatedAt);
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
//        Vector<Product> list = dao.getBySql("Select * From Product a Where a.ProductID = 1;");
//
//        for (Product product : list) {
//            System.out.println(product);
//        }
        List<Product> categorys = dao.filterProductsByPrice(30, "ascending");
        categorys.stream().forEach(y -> System.err.println(y.getPrice()));

    }
}
