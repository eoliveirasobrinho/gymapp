package com.project.gymapp.modules.customer.exceptions;

public class CustomerAlreadyRegisteredException extends RuntimeException {

    public CustomerAlreadyRegisteredException() {
        super("Este cliente já foi registrado");
    }

    public CustomerAlreadyRegisteredException(String message) {
        super(message);
    }
}
