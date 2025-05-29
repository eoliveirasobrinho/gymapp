package com.project.gymapp.modules.products.models.enums;

public enum ProductType {
    SUPPLEMENT("suplemento"),
    VESTUARY("vestuário"),
    DRINK_FOOD("bebida e comida");

    private final String productType;

    ProductType(String productType
    ) {
        this.productType = productType;
    }

    public String getProductType() {
        return productType;
    }
}
