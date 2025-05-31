package com.project.gymapp.modules.user.exceptions;

public class UsersListIsEmptyException extends RuntimeException {

    public UsersListIsEmptyException() {
        super("Não foi encontrado nenhum usuário na base de dados");
    }

    public UsersListIsEmptyException(String message) {
        super(message);
    }
}
