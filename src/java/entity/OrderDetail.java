/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class OrderDetail {
<<<<<<< Updated upstream
    private String OrderDetailID, OrderID, ProductID;
    private int Quantity, Price;
=======

    private int OrderDetailID;
    private int OrderID;
    private int ProductID;
    private int Quantity;
    private double Price;

>>>>>>> Stashed changes

    public OrderDetail() {
    }

<<<<<<< Updated upstream
    public OrderDetail(String OrderDetailID, String OrderID, String ProductID, int Quantity, int Price) {
=======
    public OrderDetail(int OrderDetailID, int OrderID, int ProductID, int Quantity, double Price) {
>>>>>>> Stashed changes
        this.OrderDetailID = OrderDetailID;
        this.OrderID = OrderID;
        this.ProductID = ProductID;
        this.Quantity = Quantity;
        this.Price = Price;
    }

<<<<<<< Updated upstream
    public String getOrderDetailID() {
        return OrderDetailID;
    }

    public void setOrderDetailID(String OrderDetailID) {
        this.OrderDetailID = OrderDetailID;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
=======
    public int getOrderDetailID() {
        return OrderDetailID;
    }

    public void setOrderDetailID(int OrderDetailID) {
        this.OrderDetailID = OrderDetailID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
>>>>>>> Stashed changes
        this.ProductID = ProductID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

<<<<<<< Updated upstream
    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }
    
=======
    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "OrderDetailID=" + OrderDetailID + ", OrderID=" + OrderID + ", ProductID=" + ProductID + ", Quantity=" + Quantity + ", Price=" + Price + '}';
    }

    

    

>>>>>>> Stashed changes
}
