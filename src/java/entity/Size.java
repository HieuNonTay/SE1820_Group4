/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class Size {
    private String SizeID, ColorID;
    private int Quantity, SizeNumber;

    public Size() {
    }

    public Size(String SizeID, String ColorID, int Quantity, int SizeNumber) {
        this.SizeID = SizeID;
        this.ColorID = ColorID;
        this.Quantity = Quantity;
        this.SizeNumber = SizeNumber;
    }

    public String getSizeID() {
        return SizeID;
    }

    public void setSizeID(String SizeID) {
        this.SizeID = SizeID;
    }

    public String getColorID() {
        return ColorID;
    }

    public void setColorID(String ColorID) {
        this.ColorID = ColorID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public int getSizeNumber() {
        return SizeNumber;
    }

    public void setSizeNumber(int SizeNumber) {
        this.SizeNumber = SizeNumber;
    }
    
}
