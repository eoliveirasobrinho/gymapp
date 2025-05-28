package com.project.gymapp.modules.products.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.project.gymapp.modules.products.models.enums.ProductTypeEnum;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

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
    private ProductDetails productDetails;
    @Future
    private LocalDate valiDate;
    @PastOrPresent
    private LocalDate manufacturingDate;

    public Product(String brand, LocalDate manufacturingDate, String name, BigDecimal price, ProductDetails productDetails, ProductTypeEnum productType, LocalDate valiDate) {
        this.brand = brand;
        this.manufacturingDate = manufacturingDate;
        this.name = name;
        this.price = price;
        this.productDetails = productDetails;
        this.productType = productType;
        this.valiDate = valiDate;
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

    public LocalDate getValiDate() {
        return valiDate;
    }

    public void setValiDate(LocalDate valiDate) {
        this.valiDate = valiDate;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

}
