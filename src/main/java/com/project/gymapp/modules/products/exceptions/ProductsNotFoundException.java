package com.project.gymapp.modules.products.exceptions;

public class ProductsNotFoundException extends RuntimeException {

    public ProductsNotFoundException() {
        super("Não há produtos cadastrados!");
    }

    public ProductsNotFoundException(String message) {
        super(message);
    }
}
