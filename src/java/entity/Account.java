/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author quyen
 */
public class Account {

    private int accountID;
    private String fname;
    private String lname;
    private Date dob;
    private String phone;
    private String email;
    private String password;
    private int roleID;
    private String address;
    private String status;
    private String registerAt;
    private String lastLogin;
    private String lastLogout;
    private String image;

    public Account() {
    }

    public Account(int accountID, String fname, String lname, Date dob, String phone, String email, String password, int roleID, String address, String status, String registerAt, String lastLogin, String lastLogout, String image) {
        this.accountID = accountID;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.roleID = roleID;
        this.address = address;
        this.status = status;
        this.registerAt = registerAt;
        this.lastLogin = lastLogin;
        this.lastLogout = lastLogout;
        this.image = image;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegisterAt() {
        return registerAt;
    }

    public void setRegisterAt(String registerAt) {
        this.registerAt = registerAt;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getLastLogout() {
        return lastLogout;
    }

    public void setLastLogout(String lastLogout) {
        this.lastLogout = lastLogout;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Account{" + "accountID=" + accountID + ", fname=" + fname + ", lname=" + lname + ", dob=" + dob + ", phone=" + phone + ", email=" + email + ", password=" + password + ", roleID=" + roleID + ", address=" + address + ", status=" + status + ", registerAt=" + registerAt + ", lastLogin=" + lastLogin + ", lastLogout=" + lastLogout + ", image=" + image + '}';
    }

}
