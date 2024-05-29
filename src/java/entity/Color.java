/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class Color {
    private String ColorID, ProductID, Name;
    private int Quantity;

    public Color() {
    }

    public Color(String ColorID, String ProductID, String Name, int Quantity) {
        this.ColorID = ColorID;
        this.ProductID = ProductID;
        this.Name = Name;
        this.Quantity = Quantity;
    }

    public String getColorID() {
        return ColorID;
    }

    public void setColorID(String ColorID) {
        this.ColorID = ColorID;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    
    
}
