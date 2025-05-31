package com.project.gymapp.modules.products.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super("Não há produto cadastrado para esse id!");
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
