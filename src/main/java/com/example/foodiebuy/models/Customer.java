package com.example.foodiebuy.models;

import com.example.foodiebuy.enums.UserRoles;

import javax.persistence.*;

@Entity
@Table
public class Customer {
    @Id
    @SequenceGenerator(
            name="customer_sequence",
            sequenceName= "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    @Column( name = "customer_id", updatable = false)
    private Long customerId;
    @Column( name = "customer_name", nullable = false)
    private String customerName;
    @Column( name = "customer_email", nullable = false)
    private String customerEmail;
    @Column( name = "customer_password", nullable = false)
    private String customerPassword;

    @Column(name = "role", nullable = false)
    private UserRoles role;
    @Column( name = "customer_address", nullable = false)
    private String customerAddress;
    @Column( name = "customer_contact", nullable = false)
    private String customerContact;

    public Customer() {
    }

    public Customer(Long customerId, String customerName, String customerEmail, String customerPassword, UserRoles role, String customerAddress, String customerContact) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.role = role;
        this.customerAddress = customerAddress;
        this.customerContact = customerContact;
    }

    public Customer(String customerName, String customerEmail, String customerPassword, UserRoles role, String customerAddress, String customerContact) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.role = role;
        this.customerAddress = customerAddress;
        this.customerContact = customerContact;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPassword='" + customerPassword + '\'' +
                ", role=" + role +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerContact='" + customerContact + '\'' +
                '}';
    }
}
