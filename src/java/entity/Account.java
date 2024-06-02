/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author quyen
 */
public class Account {
    private String accountID;
    private String Phone;
    private String Email;
    private String Password;
    private int roleID;
    private String Address;
    private String Status;

    public Account() {
    }

    public Account(String accountID, String Phone, String Email, String Password, int roleID, String Address, String Status) {
        this.accountID = accountID;
        this.Phone = Phone;
        this.Email = Email;
        this.Password = Password;
        this.roleID = roleID;
        this.Address = Address;
        this.Status = Status;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
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

    @Override
    public String toString() {
        return "Account{" + "accountID=" + accountID + ", Phone=" + Phone + ", Email=" + Email + ", Password=" + Password + ", roleID=" + roleID + ", Address=" + Address + ", Status=" + Status + '}';
    }
    
}
