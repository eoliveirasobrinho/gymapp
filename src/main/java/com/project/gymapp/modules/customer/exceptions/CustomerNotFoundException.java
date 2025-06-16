package com.project.gymapp.modules.customer.exceptions;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException() {
        super("Cliente com este id não foi encontrado");
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
