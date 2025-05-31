package com.project.gymapp.modules.products.exceptions;

public class ProductAlreadyRegisteredWithIdException extends RuntimeException {

    public ProductAlreadyRegisteredWithIdException(String message) {
        super(message);
    }

    public ProductAlreadyRegisteredWithIdException() {
        super("O produto com este id já foi cadastrado");
    }
}
