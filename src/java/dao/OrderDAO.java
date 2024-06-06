/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Order;
import entity.Product;
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
public class OrderDAO extends DBContext {

    public Vector<Order> getAll() {
        String sql = "select * from Order";
        Vector<Order> vector = new Vector<>();
        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int orderId = rs.getInt(1);
                int accountId = rs.getInt(2);
                String firstName = rs.getNString(3);
                String lastName = rs.getNString(4);
                Timestamp Orderdate = rs.getTimestamp(5);
                double total = rs.getDouble(6);
                String line1 = rs.getNString(7);
                String line2 = rs.getNString(8);
                String city = rs.getNString(9);
                String province = rs.getNString(10);
                String countryId = rs.getNString(11);
                Timestamp createdAt = rs.getTimestamp(12);
                Timestamp updateAt = rs.getTimestamp(13);
                String payment = rs.getNString(14);
                String status = rs.getNString(15);

                vector.add(new Order(orderId, accountId, firstName, lastName,
                        Orderdate, total, line1, line2, city, province,
                        countryId, createdAt, updateAt, payment, status));

            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Order getById(int id) {
        String sql = "Select * From Order o Where o.OrderID = ?;";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                int orderId = rs.getInt(1);
                int accountId = rs.getInt(2);
                String firstName = rs.getNString(3);
                String lastName = rs.getNString(4);
                Timestamp Orderdate = rs.getTimestamp(5);
                double total = rs.getDouble(6);
                String line1 = rs.getNString(7);
                String line2 = rs.getNString(8);
                String city = rs.getNString(9);
                String province = rs.getNString(10);
                String countryId = rs.getNString(11);
                Timestamp createdAt = rs.getTimestamp(12);
                Timestamp updateAt = rs.getTimestamp(13);
                String payment = rs.getNString(14);
                String status = rs.getNString(15);

                return new Order(orderId, accountId, firstName, lastName, Orderdate, total, line1, line2, city, province, countryId, createdAt, updateAt, payment, status);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
