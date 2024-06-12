/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Order;
import entity.Product;
import entity.ProductCart;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public Order getById(int id) {
        String sql = "Select * From [Order] o Where o.OrderID = ?;";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
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

                return new Order(orderId, accountId, firstName, lastName, Orderdate, total, line1, line2, city, province, countryId, createdAt, updateAt, payment, status);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int addOrder(int accountId, Vector<ProductCart> listProdcut, String firstName, String lastName,
            String DiscountCode, String line1, String line2, String city, String province, String payment) {
        int orderId = 0; // Lưu trữ ID của đơn hàng được thêm vào
        double totalPrice = listProdcut.stream()
                .mapToDouble(ProductCart::getPrice)
                .reduce(0.0, (subtotal, price) -> subtotal + price);
        String sql = "INSERT INTO [dbo].[Order]\n"
                + "           ([AccountID]\n"
                + "           ,[firstName]\n"
                + "           ,[lastName]\n"
                + "           ,[DiscountCode]\n"
                + "           ,[Total]\n"
                + "           ,[line1]\n"
                + "           ,[line2]\n"
                + "           ,[city]\n"
                + "           ,[province]\n"
                + "           ,[payment])\n"
                + "     VALUES"
                + "           (?,?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement pre = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pre.setInt(1, accountId);
            pre.setNString(2, firstName);
            pre.setNString(3, lastName);
            pre.setString(4, DiscountCode);
            pre.setDouble(5, totalPrice);
            pre.setNString(6, line1);
            pre.setNString(7, line2);
            pre.setNString(8, city);
            pre.setNString(9, province);
            pre.setNString(10, payment);

            int rowsAffected = pre.executeUpdate();
            ResultSet rs = pre.getGeneratedKeys();
            if (rs.next()) {
                orderId = rs.getInt(1); // Lấy ID của đơn hàng được thêm vào
            }

            if (orderId != 0) {
                for (ProductCart productCart : listProdcut) {
                    String sql2 = "INSERT INTO [dbo].[OrderDetail]\n"
                            + "           ([OrderID]\n"
                            + "           ,[ProductID]\n"
                            + "           ,[Quantity]\n"
                            + "           ,[Price])\n"
                            + "     VALUES"
                            + "           (?,?,?,?);";
                    PreparedStatement pre2 = conn.prepareStatement(sql2);
                    pre2.setInt(1, orderId);
                    pre2.setInt(2, productCart.getProductId());
                    pre2.setInt(3, productCart.getQuantity());
                    pre2.setDouble(4, productCart.getPrice());

                    pre2.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderId; // Trả về ID của đơn hàng mới được thêm vào
    }

    public int updateOrder(
            int orderId,
            String firstName,
            String lastName,
            double total,
            String city,
            String status
    ) {
        int n = 0;
        String sql = "UPDATE [dbo].[Order]\n"
                + "   SET [firstName] = ?\n"
                + "      ,[lastName] = ?\n"
                + "      ,[Total] = ?\n"
                + "      ,[city] = ?\n"
                + "      ,[Status] = ?"
                + " WHERE [OrderId] = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, firstName);
            pre.setString(2, lastName);
            pre.setDouble(3, total);
            pre.setString(4, city);
            pre.setString(5, status);
            pre.setInt(6, orderId);
            n = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public static void main(String[] args) {
        OrderDAO orderDao = new OrderDAO();
//        int listOrder = orderDao.updateOrder(1, "acc", "add", 1000, "New York", "Delivered");
//        Vector<Order> order = orderDao.getAll();
//        for (Order order1 : order) {
//            System.out.println(order1);
//        }
        Vector<ProductCart> listCart = new Vector<>();
        listCart.add(new ProductCart(2, "Nike", 2, 50000));
        listCart.add(new ProductCart(2, "Nike", 1, 50000));
        listCart.add(new ProductCart(2, "Nike", 1, 50000));
        listCart.add(new ProductCart(5, "Nike", 1, 50000));

        int n = orderDao.addOrder(2, listCart, "bui", "hieu", "A2", "hoa lac 1", "hoa lac 2", "Thach that", "Ha noi", "payment");
        if (n > 0) {
            System.out.println("duoc");
        } else {
            System.out.println("khong duoc");
        }
    }

}
