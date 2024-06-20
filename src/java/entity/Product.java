/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Timestamp;

/**
 *
 * @author ASUS
 */
public class Product {

    private int productId;
    private String name;
<<<<<<< Updated upstream
    private int brandId;
    private int catergoryId;
    private String description;
    private double price;
    private int quantity;
    private Timestamp publicationDate;
    private String status;

    public Product() {

    }

    public Product(int productId, String name, int brandId, int catergoryId, String description, double price, int quantity, Timestamp publicationDate, String status) {
        this.productId = productId;
        this.name = name;
        this.brandId = brandId;
        this.catergoryId = catergoryId;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.publicationDate = publicationDate;
        this.status = status;
=======
    private String model;
    private int brandId;
    private int catergoryId;
    private int colorId;
    private int sizeId;
    private String description;
    private double price;
    private int quantity;
    private int sold;
    private int view;
    private Timestamp publicationDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Product() {
    }

    public Product(int productId, String name, String model, int brandId, int catergoryId, int colorId, int sizeId, String description, double price, int quantity, int sold, int view, Timestamp publicationDate, Timestamp createdAt, Timestamp updatedAt) {
        this.productId = productId;
        this.name = name;
        this.model = model;
        this.brandId = brandId;
        this.catergoryId = catergoryId;
        this.colorId = colorId;
        this.sizeId = sizeId;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.sold = sold;
        this.view = view;
        this.publicationDate = publicationDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
>>>>>>> Stashed changes
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

<<<<<<< Updated upstream
=======
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

>>>>>>> Stashed changes
    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getCatergoryId() {
        return catergoryId;
    }

    public void setCatergoryId(int catergoryId) {
        this.catergoryId = catergoryId;
    }

<<<<<<< Updated upstream
=======
    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

>>>>>>> Stashed changes
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

<<<<<<< Updated upstream
=======
    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

>>>>>>> Stashed changes
    public Timestamp getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Timestamp publicationDate) {
        this.publicationDate = publicationDate;
    }

<<<<<<< Updated upstream
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
=======
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
>>>>>>> Stashed changes
    }

    @Override
    public String toString() {
<<<<<<< Updated upstream
        return "Product{" + "productId=" + productId + ", name=" + name + ", brandId=" + brandId + ", catrgoryId=" + catergoryId + ", description=" + description + ", price=" + price + ", quantity=" + quantity + ", publicationDate=" + publicationDate + ", status=" + status + '}';
    }

=======
        return "Product{" + "productId=" + productId + ", name=" + name + ", model=" + model + ", brandId=" + brandId + ", catergoryId=" + catergoryId + ", colorId=" + colorId + ", sizeId=" + sizeId + ", description=" + description + ", price=" + price + ", quantity=" + quantity + ", sold=" + sold + ", view=" + view + ", publicationDate=" + publicationDate + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
    
    
>>>>>>> Stashed changes
}
