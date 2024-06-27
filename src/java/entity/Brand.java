/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class Brand {
    private int BrandID;
    private String  BrandName;

    public Brand() {
    }

    public Brand(int BrandID, String BrandName) {
        this.BrandID = BrandID;
        this.BrandName = BrandName;
    }

    public int getBrandID() {
        return BrandID;
    }

    public void setBrandID(int BrandID) {
        this.BrandID = BrandID;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String BrandName) {
        this.BrandName = BrandName;
    }

    @Override
    public String toString() {
        return "Brand{" + "BrandID=" + BrandID + ", BrandName=" + BrandName + '}';
    }

    
    
}
