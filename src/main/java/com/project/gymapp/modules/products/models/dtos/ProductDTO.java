package com.project.gymapp.modules.products.models.dtos;

import java.math.BigDecimal;

import com.project.gymapp.modules.products.models.ProductDetails;
import com.project.gymapp.modules.products.models.enums.ProductTypeEnum;

public record ProductDTO(String id, String brand, String manufacturingDate, String name, BigDecimal price, Integer quantity, ProductDetails productDetails, ProductTypeEnum productType, String valiDate) {

}
