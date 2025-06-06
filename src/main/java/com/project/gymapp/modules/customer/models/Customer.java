package com.project.gymapp.modules.customer.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.project.gymapp.modules.products.models.Product;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Document("CUSTOMER")
public class Customer {

    @Id
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotBlank
    private String birthday;
    @Email
    @NotBlank
    private String email;
    @NotEmpty
    private Address address;
    @Nullable
    private List<Product> products;

    public Customer(Address address, String birthday, String email, String lastname, String name, List<Product> products) {
        this.address = address;
        this.birthday = birthday;
        this.email = email;
        this.lastname = lastname;
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getId() {
        return id;
    }

}
