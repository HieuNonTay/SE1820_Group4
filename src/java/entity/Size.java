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

    private int SizeID, ColorID;
    private int Quantity, SizeNumber;

    public Size() {
    }

    public Size(int sizeID, int size) {
        this.SizeID = sizeID;
        this.ColorID = size;
    }

    public Size(int SizeID, int ColorID, int Quantity, int SizeNumber) {
        this.SizeID = SizeID;
        this.ColorID = ColorID;
        this.Quantity = Quantity;
        this.SizeNumber = SizeNumber;
    }

    public int getSizeID() {
        return SizeID;
    }

    public void setSizeID(int SizeID) {
        this.SizeID = SizeID;
    }

    public int getColorID() {
        return ColorID;
    }

    public void setColorID(int ColorID) {
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
