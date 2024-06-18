/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DBContext;
import entity.Order;
import entity.OrderDetail;
import java.sql.PreparedStatement;

/**
 *
 * @author DELL
 */
public class OrderDetailDAO extends DBContext {

    public Vector<OrderDetail> getAll() {
        String sql = "select * from OrderDetail";
        Vector<OrderDetail> vector = new Vector<>();
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int OrderDetailID = rs.getInt(1);
                int OrderID = rs.getInt(2);
                int ProductID = rs.getInt(3);
                int Quantity = rs.getInt(4);
                double Price = rs.getDouble(5);
                vector.add(new OrderDetail(OrderDetailID, OrderID, ProductID, Quantity, Price));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Vector<OrderDetail> getBySql(String sql) {

        Vector<OrderDetail> vector = new Vector<>();
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int OrderDetailID = rs.getInt(1);
                int OrderID = rs.getInt(2);
                int ProductID = rs.getInt(3);
                int Quantity = rs.getInt(4);
                double Price = rs.getDouble(5);
                vector.add(new OrderDetail(OrderDetailID, OrderID, ProductID, Quantity, Price));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Vector<OrderDetail> getByOrderId(int id) {
        String sql = "select * from OrderDetail";
        Vector<OrderDetail> vector = new Vector<>();
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int OrderDetailID = rs.getInt(1);
                int OrderID = rs.getInt(2);
                int ProductID = rs.getInt(3);
                int Quantity = rs.getInt(4);
                double Price = rs.getDouble(5);
                vector.add(new OrderDetail(OrderDetailID, OrderID, ProductID, Quantity, Price));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public static void main(String[] args) {
        OrderDetailDAO orderDetailDao = new OrderDetailDAO();
//        Vector<OrderDetail> listOrderDetail = orderDetailDao.getAll();
        Vector<OrderDetail> listOrderDetail = orderDetailDao.getBySql("select * from OrderDetail Where OrderID = " + 2 + ";");
        for (OrderDetail oderDetail : listOrderDetail) {
            System.out.println(oderDetail);
        }
    }
}
