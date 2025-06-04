package com.project.gymapp.modules.user.models;

import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.gymapp.modules.user.models.enums.DocumentType;
import com.project.gymapp.modules.user.models.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Document(collection = "USER")
public class User implements UserDetails {

    @Id
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    private String document;
    @NotBlank
    private DocumentType type;
    @Email
    @NotBlank
    private String email;
    private Boolean isActive;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private Role role;

    public User(String id, String document, String email, String lastName, String name, DocumentType type, Boolean isActive, String username, String password, Role role) {
        this.id = id;
        this.document = document;
        this.email = email;
        this.lastName = lastName;
        this.name = name;
        this.type = type;
        this.isActive = isActive;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == Role.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_CUSTOMER"), new SimpleGrantedAuthority("ROLE_EMPLOYEE"), new SimpleGrantedAuthority("ROLE_MANAGEMENT"));
        }

        if (this.role == Role.EMPLOYEE) {
            return List.of(new SimpleGrantedAuthority("ROLE_EMPLOYEE"), new SimpleGrantedAuthority("ROLE_CUSTOMER"));
        }

        if (this.role == Role.MANAGEMENT) {
            return List.of(new SimpleGrantedAuthority("ROLE_EMPLOYEE"), new SimpleGrantedAuthority("ROLE_MANAGEMENT"), new SimpleGrantedAuthority("ROLE_CUSTOMER"));
        }

        return List.of(new SimpleGrantedAuthority("ROLE_CUSTOMER"));

    }

}
