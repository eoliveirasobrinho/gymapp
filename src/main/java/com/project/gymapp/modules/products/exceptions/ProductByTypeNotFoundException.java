package com.project.gymapp.modules.products.exceptions;

public class ProductByTypeNotFoundException extends RuntimeException {

    public ProductByTypeNotFoundException() {
        super("Os Produtos para este tipo não foram encontrados!");
    }

    public ProductByTypeNotFoundException(String message) {
        super(message);
    }
}
