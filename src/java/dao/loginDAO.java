/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Account;
import model.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class loginDAO extends DBContext {

    Connection cnn;  //ket noi
    Statement stm;   //thuc hien cau lenh sql
    PreparedStatement pstm;
    ResultSet rs;    //luu tru va xu ly du lieu

    public Account loginUser(String user, String password) {
        String query = "  SELECT * FROM Account\n"
                + "  where Email =? and [Password] = ?";
        try {
            conn = new DBContext().conn;
            pstm = conn.prepareStatement(query);
            pstm.setString(1, user);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                if (checkAccountRole(rs.getInt(8)) && checkBan(rs.getString(9))) {
                    return new Account(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getInt(8),
                            rs.getString(9),
                            rs.getString(10),
                            rs.getString(11),
                            rs.getString(12),
                            rs.getString(13));
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            System.out.println("Login: " + e.getMessage());
        }
        return null;
    }

    private boolean checkAccountRole(int accRole) {
        if (accRole == 2) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkBan(String account) {
        if (account.equals("Active")) {
            return true;
        } else {
            return false;
        }
    }
}
