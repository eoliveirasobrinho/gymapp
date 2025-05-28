package com.project.gymapp.modules.products.models.enums;

public enum ProductTypeEnum {
    SUPPLEMENT("suplemento"),
    VESTUARY("vestuário"),
    DRINK_FOOD("bebida e comida");

    private final String productType;

    ProductTypeEnum(String productType) {
        this.productType = productType;
    }

    public String getProductType() {
        return productType;
    }
}
