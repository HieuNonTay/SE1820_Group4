/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

<<<<<<< Updated upstream
=======
import java.sql.Timestamp;

>>>>>>> Stashed changes
/**
 *
 * @author DELL
 */
public class Order {
<<<<<<< Updated upstream
    private String OrderID, AccountID, OrderDate, Total, Address, Status;
=======

    private int orderId;
    private int accountId;
    private String firstName;
    private String lastName;
    private Timestamp Orderdate;
    private String discountCode;
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
>>>>>>> Stashed changes

    public Order() {
    }

<<<<<<< Updated upstream
    public Order(String OrderID, String AccountID, String OrderDate, String Total, String Address, String Status) {
        this.OrderID = OrderID;
        this.AccountID = AccountID;
        this.OrderDate = OrderDate;
        this.Total = Total;
        this.Address = Address;
        this.Status = Status;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String AccountID) {
        this.AccountID = AccountID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
=======
    public Order(int orderId, int accountId, String firstName, String lastName, Timestamp Orderdate, String DiscountCode, double total, String line1, String line2, String city, String province, String countryId, Timestamp createdAt, Timestamp updateAt, String payment, String status) {
        this.orderId = orderId;
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Orderdate = Orderdate;
        this.discountCode = DiscountCode;
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

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
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
        return "Order{" + "orderId=" + orderId + ", accountId=" + accountId + ", firstName=" + firstName + ", lastName=" + lastName + ", Orderdate=" + Orderdate + ", discountCode=" + discountCode + ", total=" + total + ", line1=" + line1 + ", line2=" + line2 + ", city=" + city + ", province=" + province + ", countryId=" + countryId + ", createdAt=" + createdAt + ", updateAt=" + updateAt + ", payment=" + payment + ", status=" + status + '}';
    }

>>>>>>> Stashed changes
}
