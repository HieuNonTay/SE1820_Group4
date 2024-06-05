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
                int brandId = rs.getInt(3);
                int categoryId = rs.getInt(4);
                String description = rs.getNString(5);
                double price = rs.getDouble(6);
                int quantity = rs.getInt(7);
                Timestamp publicationDate = rs.getTimestamp(8);
                String status = rs.getString(9);

                vector.add(new Product(productId, name, brandId, categoryId,
                        description, price, quantity, publicationDate, status));

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
                int brandId = rs.getInt(3);
                int categoryId = rs.getInt(4);
                String description = rs.getNString(5);
                double price = rs.getDouble(6);
                int quantity = rs.getInt(7);
                Timestamp publicationDate = rs.getTimestamp(8);
                String status = rs.getString(9);

                vector.add(new Product(productId, name, brandId, categoryId,
                        description, price, quantity, publicationDate, status));
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
                int brandId = rs.getInt(3);
                int categoryId = rs.getInt(4);
                String description = rs.getNString(5);
                double price = rs.getDouble(6);
                int quantity = rs.getInt(7);
                Timestamp publicationDate = rs.getTimestamp(8);
                String status = rs.getNString(9);

                return new Product(productId, name, brandId, categoryId, description,
                        price, quantity, publicationDate, status);
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
