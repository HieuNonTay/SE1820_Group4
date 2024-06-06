/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Timestamp;

/**
 *
 * @author DELL
 */
public class Order {

    private int orderId;
    private int accountId;
    private String firstName;
    private String lastName;
    private Timestamp Orderdate;
    private double total;
    private String line1;
    private String line2;
    private String city;
    private String province;
    private String countryId;
    private Timestamp createdAt;
    private Timestamp updateAt;
    private String payment;
    private String status;

    public Order() {
    }

    public Order(int orderId, int accountId, String firstName, String lastName, Timestamp Orderdate, double total, String line1, String line2, String city, String province, String countryId, Timestamp createdAt, Timestamp updateAt, String payment, String status) {
        this.orderId = orderId;
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Orderdate = Orderdate;
        this.total = total;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.province = province;
        this.countryId = countryId;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.payment = payment;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getOrderdate() {
        return Orderdate;
    }

    public void setOrderdate(Timestamp Orderdate) {
        this.Orderdate = Orderdate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", accountId=" + accountId + ", firstName=" + firstName + ", lastName=" + lastName + ", Orderdate=" + Orderdate + ", total=" + total + ", line1=" + line1 + ", line2=" + line2 + ", city=" + city + ", province=" + province + ", countryId=" + countryId + ", createdAt=" + createdAt + ", updateAt=" + updateAt + ", payment=" + payment + ", status=" + status + '}';
    }

}
