/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Product;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
        String sql = "select * from Product";
        Vector<Product> vector = new Vector<>();
        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int productId = rs.getInt(1);
                String name = rs.getNString(2);
                String model = rs.getString(3);
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
                String model = rs.getString(3);
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
                String model = rs.getString(3);
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

    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
//        Vector<Product> list = dao.getBySql("Select * From Product a Where a.ProductID = 1;");
//
//        for (Product product : list) {
//            System.out.println(product);
//        }
        Product pro1 = dao.getById(1);
        System.out.println(pro1);
    }
}
