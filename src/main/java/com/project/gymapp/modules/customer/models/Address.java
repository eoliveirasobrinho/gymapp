package com.project.gymapp.modules.customer.models;

import jakarta.validation.constraints.NotBlank;

public class Address {

    @NotBlank
    private String street;
    @NotBlank
    private String number;
    @NotBlank
    private String neighboorhood;
    @NotBlank
    private String city;
    @NotBlank
    private String zipCode;
    @NotBlank
    private String state;
    @NotBlank
    private String country;

    public Address(String city, String country, String neighboorhood, String number, String state, String street, String zipCode) {
        this.city = city;
        this.country = country;
        this.neighboorhood = neighboorhood;
        this.number = number;
        this.state = state;
        this.street = street;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNeighboorhood() {
        return neighboorhood;
    }

    public void setNeighboorhood(String neighboorhood) {
        this.neighboorhood = neighboorhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
