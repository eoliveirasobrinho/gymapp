package com.project.gymapp.modules.customer.exceptions;

public class CustomersNotFoundException extends RuntimeException {

    public CustomersNotFoundException() {
        super("Nenhum cliente encontrado");
    }

    public CustomersNotFoundException(String message) {
        super(message);
    }
}
