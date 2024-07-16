/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DBContext;

/**
 *
 * @author Dell
 */
public class CategoryDAO extends DBContext {

    Connection cnn; //dùng để kết nối
    Statement stm; //Thực thi các câu lệnh sql
    PreparedStatement pstm;
    ResultSet rs; //Lưu trữ và xử lý dữ liệu

    private void connect() {
        try {
            cnn = (new DBContext()).conn;
            if (cnn != null) {
                System.out.println("Connect category success");
            } else {
                System.out.println("Connect fail");
            }
        } catch (Exception e) {

        }
    }

    public List<Category> getListCategory() {
        List<Category> data = new ArrayList<Category>();
        try {
            connect();
            String strSelect = "select [CategoryID], [CategoryName] from Category";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                int categoryid = rs.getInt(1);
                String cname = rs.getString(2);

                data.add(new Category(categoryid, cname));
            }
            cnn.close();
        } catch (Exception e) {
            System.out.println("getListCategory: " + e.getMessage());
        }
        return data;
    }

    public static void main(String[] args) {
        CategoryDAO cat = new CategoryDAO();
        List<Category> categories = cat.getListCategory();
        for (Category category : categories) {
            System.out.println(category);
        }
    }

    public Category getCategoryByID(int cid) {
        try {
            connect();
            String strSelect = "select [id], [name] from Category where id=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, cid);
            rs = pstm.executeQuery();
            if (rs.next()) {
                int categoryid = rs.getInt(1);
                String cname = rs.getString(2);

                return new Category(categoryid, cname);
            }
            cnn.close();
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());
        }
        return null;
    }
//////-------------------------------------------------------------------------------------------

    public int insertCategory(Category obj) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Category]\n"
                + "           ([CategoryID]\n"
                + "           ,[CategoryName]\n"
                + "     VALUES(?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, obj.getCategoryID());
            pre.setString(2, obj.getCategoryName());
            n = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public int updateCategory(Category obj) {
        int n = 0;
        String sql = "UPDATE [dbo].[Category]\n"
                + "        SET [CategoryID] = ?\n"
                + "           ,[CategoryName] = ?\n"
                + "     WHERE [CategoryID] = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, obj.getCategoryID());
            pre.setString(2, obj.getCategoryName());
            n = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public List<Category> getAll(String sql) {
        List<Category> list = new ArrayList<>();
        try {
            Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int CategoryID = rs.getInt(1);
                String CategoryName = rs.getString(2);
                Category categorys = new Category(CategoryID, CategoryName);
                list.add(categorys);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Category> searchCategory(String name) {
        // Vector co threadsafe
        List<Category> list = new ArrayList<>();
        String sql = "select * from Category where CategoryName like '%" + name + "%'";
        list = getAll(sql);
        return list;
    }

    public int getCategoryIdByName(String categoryName) {
        String sql = "SELECT CategoryID FROM Category WHERE CategoryName = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, categoryName);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("CategoryID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Return -1 or throw an exception if the category is not found
    }

    public int removeAuthor(String id) {
        int n = 0;
        String sql = "delete from Category where CategoryID = '" + id + "'";
        Statement st;
        try {
            st = conn.createStatement();
            n = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

}
