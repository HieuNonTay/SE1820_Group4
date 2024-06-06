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

    private int orderId, accountId;
    private String firstName, lastName;
    private Timestamp Orderdate;
    private double total;
    private String line1, line2, city, province, countryId;
    private Timestamp createdAt, updateAt;
    private String payment, status;

    public Order() {
    }

}
