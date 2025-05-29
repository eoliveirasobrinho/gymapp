package com.project.gymapp.modules.products.models.dtos;

import java.math.BigDecimal;

import com.project.gymapp.modules.products.models.ProductDetails;
import com.project.gymapp.modules.products.models.enums.ProductType;

public record ProductDTO(String id, String brand, String manufacturingDate, String name, BigDecimal price, Integer quantity, ProductDetails productDetails, ProductType productType, String valiDate) {

}
