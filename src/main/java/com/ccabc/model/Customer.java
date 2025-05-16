package com.ccabc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="customer")
@JsonIgnoreProperties(value = {"password"},allowSetters = true,allowGetters = false)
public class Customer {
    @Id
    @Column(name="id",nullable = false,updatable = false)
    private int id;

    @Column(name="name",nullable = false)
    private String name;
    @Column(name="email",nullable = false,unique = true)
    private String email;
    @Column(name="password",nullable = false)
    private String password;
    @Column(name="phone",nullable = false)
    private String phone;
    @Column(name="date_of_registration",nullable = false)
    private LocalDate dateOfRegistration;

    public Customer() {
    }

    public Customer(int id, String name,  String email,String password, String phone, LocalDate dateOfRegistration) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.dateOfRegistration = dateOfRegistration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(LocalDate dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfRegistration=" + dateOfRegistration +
                '}';
    }
}
