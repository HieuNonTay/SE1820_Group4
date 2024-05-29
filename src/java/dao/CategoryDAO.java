/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import entity.Category;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DBContext;
/**
 *
 * @author DELL
 */
public class CategoryDAO extends DBContext{
    public int insertCategory(Category obj){
        int n = 0;
        String sql = "INSERT INTO [dbo].[Category]\n"
                + "           ([CategoryID]\n"
                + "           ,[CategoryName]\n"
                + "     VALUES(?,?)";
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, obj.getCategoryID());
            pre.setString(2, obj.getCategoryName());
            n = pre.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return n;
    }
    
    public int updateCategory(Category obj){
        int n = 0;
        String sql = "UPDATE [dbo].[Category]\n"
                + "        SET [CategoryID] = ?\n"
                + "           ,[CategoryName] = ?\n"
                + "     WHERE [CategoryID] = ?";
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, obj.getCategoryID());
            pre.setString(2, obj.getCategoryName());
            n = pre.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return n;
    }
    
    public Vector<Category> getAll(String sql){
        Vector<Category> vector = new Vector<>();
        try{
            Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(sql);
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
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
}
