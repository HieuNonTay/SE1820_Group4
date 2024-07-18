/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Account;
import entity.Role;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.DBContext;

/**
 *
 * @author quyen
 */
public class RoleDAO extends DBContext {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Role> getRoleAccount() {
        String query = "select * from Role";

        List<Role> listRole = new ArrayList<>();

        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                listRole.add(new Role(rs.getInt(1), rs.getString(2)));
            }
            return listRole;
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        return null;
    }
  public List<Account> getAllAccount() {
        String query = "select * from Account";

        List<Account> listAccounts = new ArrayList<>();

        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                listAccounts.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
            }
            return listAccounts;
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        return null;
    }
    public static void main(String[] args) {
        RoleDAO rd = new RoleDAO();
        List<Account> lisst = rd.getAllAccount();
        System.out.println(lisst.get(0).getFname());
    }


}
