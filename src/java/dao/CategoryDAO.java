/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
import entity.Category;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
<<<<<<< Updated upstream
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> Stashed changes
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DBContext;
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
/**
 *
 * @author DELL
 */
<<<<<<< Updated upstream
public class CategoryDAO extends DBContext{
    public int insertCategory(Category obj){
=======
public class CategoryDAO extends DBContext {

    public int insertCategory(Category obj) {
>>>>>>> Stashed changes
        int n = 0;
        String sql = "INSERT INTO [dbo].[Category]\n"
                + "           ([CategoryID]\n"
                + "           ,[CategoryName]\n"
                + "     VALUES(?,?)";
<<<<<<< Updated upstream
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, obj.getCategoryID());
            pre.setString(2, obj.getCategoryName());
            n = pre.executeUpdate();
        }catch(SQLException e){
=======
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, obj.getCategoryID());
            pre.setString(2, obj.getCategoryName());
            n = pre.executeUpdate();
        } catch (SQLException e) {
>>>>>>> Stashed changes
            e.printStackTrace();
        }
        return n;
    }
<<<<<<< Updated upstream
    
    public int updateCategory(Category obj){
=======

    public int updateCategory(Category obj) {
>>>>>>> Stashed changes
        int n = 0;
        String sql = "UPDATE [dbo].[Category]\n"
                + "        SET [CategoryID] = ?\n"
                + "           ,[CategoryName] = ?\n"
                + "     WHERE [CategoryID] = ?";
<<<<<<< Updated upstream
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, obj.getCategoryID());
            pre.setString(2, obj.getCategoryName());
            n = pre.executeUpdate();
        }catch(SQLException e){
=======
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, obj.getCategoryID());
            pre.setString(2, obj.getCategoryName());
            n = pre.executeUpdate();
        } catch (SQLException e) {
>>>>>>> Stashed changes
            e.printStackTrace();
        }
        return n;
    }
<<<<<<< Updated upstream
    
    public Vector<Category> getAll(String sql){
        Vector<Category> vector = new Vector<>();
        try{
=======

    public List<Category> getAll(String sql) {
        List<Category> list = new ArrayList<>();
        try {
>>>>>>> Stashed changes
            Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(sql);
<<<<<<< Updated upstream
            while (rs.next()){
                String CategoryID = rs.getString(1);
                String CategoryName = rs.getString(2);
                Category categorys = new Category(CategoryID, CategoryName);
                vector.add(categorys);
            }
        }catch(SQLException ex){
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    public Vector<Category> searchAuthor(String name) {
        // Vector co threadsafe
        Vector<Category> vector = new Vector<>();
        String sql = "select * from Category where CategoryName like '%"+name+"%'";
        vector = getAll(sql);
        return vector;
    }
    public int removeAuthor(String id){
        int n = 0;
        String sql="delete from Category where CategoryID = '"+id+"'";
        Statement st;
        try {
            st = conn.createStatement();
            n=st.executeUpdate(sql);
=======
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
>>>>>>> Stashed changes
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
<<<<<<< Updated upstream
=======

    public static void main(String[] args) {
        CategoryDAO categoryDAO = new CategoryDAO();
//        List<Category> categorys = categoryDAO.searchCategory("Tops");
//        categorys.stream().forEach(y -> System.out.println(y));

    }
>>>>>>> Stashed changes
}
