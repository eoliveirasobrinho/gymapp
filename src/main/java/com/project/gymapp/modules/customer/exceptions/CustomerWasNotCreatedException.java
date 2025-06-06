package com.project.gymapp.modules.customer.exceptions;

public class CustomerWasNotCreatedException extends RuntimeException {

    public CustomerWasNotCreatedException() {
        super("Erro ao criar cliente! Favor tentar novamente");
    }

    public CustomerWasNotCreatedException(String message) {
        super(message);
    }
}
