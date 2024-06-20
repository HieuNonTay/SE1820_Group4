/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class Category {
<<<<<<< Updated upstream
    private String CategoryID, CategoryName;
=======

    private int CategoryID;
    private String CategoryName;
>>>>>>> Stashed changes

    public Category() {
    }

<<<<<<< Updated upstream
    public Category(String CategoryID, String CategoryName) {
=======
    public Category(int CategoryID, String CategoryName) {
>>>>>>> Stashed changes
        this.CategoryID = CategoryID;
        this.CategoryName = CategoryName;
    }

<<<<<<< Updated upstream
    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String CategoryID) {
=======
    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
>>>>>>> Stashed changes
        this.CategoryID = CategoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }
<<<<<<< Updated upstream
    
    
=======

>>>>>>> Stashed changes
}
