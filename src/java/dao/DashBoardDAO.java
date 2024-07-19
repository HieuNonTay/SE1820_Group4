/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Brand;
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
public class DashBoardDAO extends DBContext {

    public int getTotalUsers(int roleId) {
        int count = 0;
        String sql = "SELECT COUNT(RoleID) AS TotalUsers\n"
                + "FROM [Account]\n"
                + "WHERE RoleID = ?;";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, roleId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("TotalUsers");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public int getTotalProducts() {
        int count = 0;
        String sql = "SELECT COUNT(ProductID) AS TotalProducts\n"
                + "FROM [Product];";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("TotalProducts");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public int getTotalOrders() {
        int count = 0;
        String sql = "SELECT COUNT(OrderID) AS TotalOrders\n"
                + "FROM [Order];";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("TotalOrders");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public int getTotalOrdersInDay(int day) {
        int count = 0;
        String sql = "SELECT COUNT(OrderID) AS TotalOrders\n"
                + "FROM [Order]\n"
                + "WHERE OrderDate >= DATEADD(DAY, -?, GETDATE());";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, day);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("TotalOrders");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public int insertLastLogin(int accountId) {
        int insert = 0;
        String sql = "UPDATE Account\n"
                + "SET lastLogin = GETDATE()\n"
                + "WHERE accountid = 2;;";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, accountId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                insert = rs.getInt("TotalUsers");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return insert;
    }

    public static void main(String[] args) {
        DashBoardDAO dao = new DashBoardDAO();
        int count = dao.getTotalOrdersInDay(7);
        int countpro = dao.getTotalProducts();
        System.out.println(count);
    }
}
