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
        String sql = "select * from [Order]";
        Vector<Order> vector = new Vector<>();
        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int orderId = rs.getInt(1);
                int accountId = rs.getInt(2);
                String firstName = rs.getString(3);
                String lastName = rs.getString(4);
                Timestamp Orderdate = rs.getTimestamp(5);
                double total = rs.getDouble(6);
                String line1 = rs.getString(7);
                String line2 = rs.getString(8);
                String city = rs.getString(9);
                String province = rs.getString(10);
                String countryId = rs.getString(11);
                Timestamp createdAt = rs.getTimestamp(12);
                Timestamp updateAt = rs.getTimestamp(13);
                String payment = rs.getString(14);
                String status = rs.getString(15);

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

    public Vector<Order> getBySql(String sql) {
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
        String sql = "Select * From [Order] o Where o.OrderID = ?;";
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

    public int updateOrder(
            int orderId,
            double total,
            String city,
            String status
    ) {
        int n = 0;
        String sql = "UPDATE [dbo].[Order]\n"
                + "   SET [Total] = ?\n"
                + "      ,[City] = ?\n"
                + "      ,[Status] = ?"
                + " WHERE [OrderId] = ?";
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setDouble(1, total);
            pre.setString(2, city);
            pre.setString(3, status);
            pre.setInt(4, orderId);
            n = pre.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return n;
    }
    public static void main(String[] args) {
        OrderDAO orderDao = new OrderDAO();
        Vector<Order> listOrder = orderDao.getAll();
        for (Order order : listOrder) {
            System.out.println(order);
        }
    }

}
