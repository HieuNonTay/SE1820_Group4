/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import entity.Brand;
import java.sql.*;
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
public class BrandDAO extends DBContext{
    
    public  int insertBrand(String BrandName){
        int n = 0;
        String sql = "INSERT INTO [dbo].[Brand]\n"
                + "           ([BrandName])\n"
                + "     VALUES(?)";
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            
            pre.setString(1, BrandName);
            n = pre.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return n;
    }
    
    public int updateBrand(int BrandID, String BrandName){
        int n = 0;
        String sql = "UPDATE [dbo].[Brand]\n"
                + "        SET [BrandName] = ?\n"
                + " WHERE [BrandID] = ?";
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, BrandName);
            pre.setInt(2, BrandID);
            n = pre.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return n;
    }
    
    public Vector<Brand> getAll(String sql){
        Vector<Brand> vector = new Vector<>();
        try{
            Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                String BrandID = rs.getString(1);
                String BrandName = rs.getString(2);
                Brand bran = new Brand(BrandID, BrandName);
                vector.add(bran);
            }
        }catch(SQLException ex){
            Logger.getLogger(BrandDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    public Vector<Brand> searchAuthor(String name) {
        // Vector co threadsafe
        Vector<Brand> vector = new Vector<>();
        String sql = "select * from Brand where BrandName like '%"+name+"%'";
        vector = getAll(sql);
        return vector;
    }
    public int removeAuthor(String id){
        int n = 0;
        String sql="delete from Brand where BrandID = '"+id+"'";
        Statement st;
        try {
            st = conn.createStatement();
            n=st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BrandDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    
    public static void main(String[] args) {
        BrandDAO brand = new BrandDAO();
        int add = brand.insertBrand("DuyDung12");
    }
}
