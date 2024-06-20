/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.DBContext;

/**
 *
 * @author quyen
 */
public class AccountDAO {

    Connection conn;  //ket noi
    Statement stm;   //thuc hien cau lenh sql
    PreparedStatement pstm;
    ResultSet rs;    //luu tru va xu ly du lieu

    public void changePassword(String email, String newPass) {
        try {
            conn = new DBContext().conn;
            String strUpdate = "UPDATE [dbo].[Account]\n"
                    + "   SET \n"
                    + "      [passwordHash] = ?\n"
                    + "    \n"
                    + " WHERE [Email] = ?";
            pstm = conn.prepareStatement(strUpdate);
            pstm.setString(1, newPass);
            pstm.setString(2, email);
            pstm.execute();
            conn.close();
        } catch (Exception e) {
            System.out.println("Update: " + e.getMessage());
        }
    }

    public Account getUser(String user) {
        String query = "  SELECT * FROM Account\n"
                + "  where Email =?";
        try {
            conn = new DBContext().conn;
            pstm = conn.prepareStatement(query);
            pstm.setString(1, user);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return new Account(
                        rs.getInt(1),
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
            }
        } catch (Exception e) {
            System.out.println("Login: " + e.getMessage());
        }
        return null;
    }

    public Account loginUser(String user, String password) {
        String query = "  SELECT * FROM Account\n"
                + "  where Email =? and [passwordHash] = ?";
        try {
            conn = new DBContext().conn;
            pstm = conn.prepareStatement(query);
            pstm.setString(1, user);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                if (checkBan(rs.getString(10))) {
                    return new Account(
                            rs.getInt(1),
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

    private boolean checkBan(String account) {
        if (account.equals("Active")) {
            return true;
        } else {
            return false;
        }
    }

    public void signUp(String fname, String lname, String dob, String phone, String address,
            String email, String pass) {
        String query = "INSERT INTO [dbo].[Account] ([firstName], [lastName], [Dob], [Phone], [Email], [passwordHash], [Address]) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = new DBContext().conn; PreparedStatement pstm = conn.prepareStatement(query)) {

            pstm.setString(1, fname);
            pstm.setString(2, lname);
            pstm.setString(3, dob);
            pstm.setString(4, phone);
            pstm.setString(5, email);
            pstm.setString(6, pass);
            pstm.setString(7, address);
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error inserting account: " + e.getMessage());
        }
    }

    public Account checkAccountExist(String user, String phone) {
        String query = "  SELECT * FROM Account\n"
                + "  where Email =? or Phone = ? ";
        try {
            conn = new DBContext().conn;
            pstm = conn.prepareStatement(query);
            pstm.setString(1, user);
            pstm.setString(2, phone);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return new Account(
                        rs.getInt(1),
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
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void Update(String fname, String lname, String dob, String phone, String address, String email) {
        String strUpdate = "UPDATE [dbo].[Account]\n"
                + "SET \n"
                + "   [firstName] = ?,\n"
                + "   [lastName] = ?,\n"
                + "   [Dob] = ?,\n"
                + "   [Phone] = ?,\n"
                + "   [Address] = ?\n"
                + "WHERE [Email] = ?";

        try {
            conn = new DBContext().conn;
            pstm = conn.prepareStatement(strUpdate);
            pstm.setString(1, fname);
            pstm.setString(2, lname);
            pstm.setString(3, dob);
            pstm.setString(4, phone);
            pstm.setString(5, address);
            pstm.setString(6, email);
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error updating account: " + e.getMessage());
        }
    }

    public Account checkPhoneExist(String email, String phone) {
        String query = "  SELECT * FROM Account\n"
                + "  where [Email] = ? and Phone = ? ";
        try {
            conn = new DBContext().conn;
            pstm = conn.prepareStatement(query);
            pstm.setString(1, email);
            pstm.setString(2, phone);
            rs = pstm.executeQuery();
            if (phone.equals(rs.getString(5))) {
                while (rs.next()) {
                    return new Account(
                            rs.getInt(1),
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
                }
            } else {
                return null;
            }

        } catch (Exception e) {
        }
        return null;
    }

}
