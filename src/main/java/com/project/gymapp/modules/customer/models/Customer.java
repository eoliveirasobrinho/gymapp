package com.project.gymapp.modules.customer.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.project.gymapp.modules.products.models.Product;
import com.project.gymapp.modules.user.models.User;

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
    private List<Product> products;
    private User userDetails;
}
