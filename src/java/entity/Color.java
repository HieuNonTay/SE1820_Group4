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
<<<<<<< Updated upstream
    private String ColorID, ProductID, Name;
=======

    private int ColorID, ProductID;

    private String Name;
>>>>>>> Stashed changes
    private int Quantity;

    public Color() {
    }

<<<<<<< Updated upstream
    public Color(String ColorID, String ProductID, String Name, int Quantity) {
=======
    public Color(int id, String color) {
        this.ColorID = id;
        this.Name = color;
    }

    public Color(int ColorID, int ProductID, String Name, int Quantity) {
>>>>>>> Stashed changes
        this.ColorID = ColorID;
        this.ProductID = ProductID;
        this.Name = Name;
        this.Quantity = Quantity;
    }

<<<<<<< Updated upstream
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
=======
    public int getColorID() {
        return ColorID;
    }

    public void setColorID(int ColorID) {
        this.ColorID = ColorID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    
    
=======

>>>>>>> Stashed changes
}
