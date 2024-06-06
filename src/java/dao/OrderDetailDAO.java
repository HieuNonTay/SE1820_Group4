/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DBContext;
import entity.Order;
import entity.OrderDetail;
/**
 *
 * @author DELL
 */
public class OrderDetailDAO extends DBContext{
    public Vector<OrderDetail> getAll(){
        String sql = "select * from OrderDetail";
        Vector<OrderDetail> vector = new Vector<>();
        ResultSet rs = getData(sql);
        try{
            while (rs.next()){
                String OrderDetailID = rs.getString(1);
                String OrderID = rs.getString(2);
                String ProductID = rs.getString(3);
                int Quantity = rs.getInt(4);
                int Price = rs.getInt(5);
                vector.add(new OrderDetail(OrderDetailID,OrderID,ProductID,Quantity,Price));
            }
        }
        catch (SQLException ex){
            Logger.getLogger(OrderDetailDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
}
