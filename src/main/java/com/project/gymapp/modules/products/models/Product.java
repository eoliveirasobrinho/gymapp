package com.project.gymapp.modules.products.models;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.gymapp.modules.products.models.enums.ProductTypeEnum;

import jakarta.validation.constraints.NotBlank;

@Document("PRODUCT")
public class Product {

    @Id
    private String id;
    @NotBlank
    private ProductTypeEnum productType;
    @NotBlank
    private String name;
    @NotBlank
    private String brand;
    @NotBlank
    private BigDecimal price;
    private Integer quantity;
    private ProductDetails productDetails;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private String valiDate;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private String manufacturingDate;

    public Product(String id, String brand, String manufacturingDate, String name, BigDecimal price, Integer quantity, ProductDetails productDetails, ProductTypeEnum productType, String valiDate) {
        this.id = id;
        this.brand = brand;
        this.manufacturingDate = manufacturingDate;
        this.name = name;
        this.price = price;
        this.productDetails = productDetails;
        this.productType = productType;
        this.valiDate = valiDate;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductTypeEnum getProductType() {
        return productType;
    }

    public void setProductType(ProductTypeEnum productType) {
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    public String getValiDate() {
        return valiDate;
    }

    public void setValiDate(String valiDate) {
        this.valiDate = valiDate;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
