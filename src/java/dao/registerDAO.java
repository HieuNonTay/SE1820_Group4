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
public class registerDAO extends DBContext {

    Connection cnn;  //ket noi
    Statement stm;   //thuc hien cau lenh sql
    PreparedStatement pstm;
    ResultSet rs;    //luu tru va xu ly du lieu

//    public Account signUp(String fname, String lname, String phone, String address,
//            String email, String pass) {
//        String query = "INSERT INTO [dbo].[Account]\n"
//                + "           ([firstName]\n"
//                + "           ,[lastName]\n"
//                + "           ,[Dob]\n"
//                + "           ,[Phone]\n"
//                + "           ,[Email]\n"
//                + "           ,[passwordHash]\n"
//                + "           ,[RoleID]\n"
//                + "           ,[Address]\n"
//                + "           )\n"
//                + "     VALUES\n"
//                + "          (?, ?, ?, ?, ?, ?, ?, ?)";
//        try {
//            conn = new DBContext().conn;
//            pstm = conn.prepareStatement(query);
//            pstm.setString(1, fname);
//            pstm.setString(2, lname);
//            pstm.setString(3, pass);
//            pstm.setString(4, dob);
//            pstm.setString(5, address);
//            pstm.setString(6, name);
//            pstm.execute();
//            cnn.close();
//        } catch (Exception e) {
//        }
//
//        return null;
//    }
//    public Account checkAccountExist(String user) {
//        String query = "  SELECT * FROM Account\n"
//                + "  where Email =? ";
//        try {
//            conn = new DBContext().conn;
//            pstm = conn.prepareStatement(query);
//            pstm.setString(1, user);
//            rs = pstm.executeQuery();
//            while (rs.next()) {
//                return new Account(rs.getString(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getInt(5),
//                        rs.getString(6),
//                        rs.getString(7),
//                        rs.getString(8));
//            }
//        } catch (Exception e) {
//        }
//        return null;
//    }
}
