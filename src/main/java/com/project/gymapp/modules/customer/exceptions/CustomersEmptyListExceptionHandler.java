package com.project.gymapp.modules.customer.exceptions;

public class CustomersEmptyListExceptionHandler extends RuntimeException {

    public CustomersEmptyListExceptionHandler() {
        super("Nenhum cliente encontrado");
    }

    public CustomersEmptyListExceptionHandler(String message) {
        super(message);
    }
}
