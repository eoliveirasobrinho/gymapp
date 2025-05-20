package com.project.gymapp.modules.user.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.project.gymapp.modules.user.models.enums.DocumentType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Document(collection = "USER")
public class User {

    @Id
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    private String document;
    @NotBlank
    private DocumentType type;
    @Email
    @NotNull
    private String email;
    @NotBlank
    private Address address;
    @NotNull
    private Boolean isActive;

    public User(String document, String email, String lastName, String name, DocumentType type, Address address, Boolean isActive) {
        this.document = document;
        this.email = email;
        this.lastName = lastName;
        this.name = name;
        this.type = type;
        this.address = address;
        this.isActive = isActive;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
        this.type = type;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}
