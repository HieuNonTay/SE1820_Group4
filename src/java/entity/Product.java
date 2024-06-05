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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

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

    public Timestamp getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Timestamp publicationDate) {
        this.publicationDate = publicationDate;
    }

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
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", name=" + name + ", model=" + model + ", brandId=" + brandId + ", catergoryId=" + catergoryId + ", colorId=" + colorId + ", sizeId=" + sizeId + ", description=" + description + ", price=" + price + ", quantity=" + quantity + ", sold=" + sold + ", view=" + view + ", publicationDate=" + publicationDate + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
    
    
}
