package com.project.gymapp.modules.customer.exceptions;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException() {
        super("Cliente com este email não foi encontrado");
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
