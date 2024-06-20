/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ASUS
 */
public class Discount {

    private String code, name;
    private double amount;
    private String fromDate, toDate;
    private String description, type;

    private int acocountId, productId, number;
    private String productModel;

    public Discount() {
    }

    public Discount(String code, String fromDate, String toDate, int productId) {
        this.code = code;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.productId = productId;
    }

    public Discount(String code, String name, double amount, String description, String type) {
        this.code = code;
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAcocountId() {
        return acocountId;
    }

    public void setAcocountId(int acocountId) {
        this.acocountId = acocountId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    @Override
    public String toString() {
        return "Discount{" + "code=" + code + ", name=" + name + ", amount=" + amount + ", fromDate=" + fromDate + ", toDate=" + toDate + ", description=" + description + ", type=" + type + ", acocountId=" + acocountId + ", productId=" + productId + ", number=" + number + ", productModel=" + productModel + '}';
    }

}
