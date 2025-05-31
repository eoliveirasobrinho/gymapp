package com.project.gymapp.modules.user.exceptions;

public class UserAlreadyRegisteredWithEmail extends RuntimeException {

    public UserAlreadyRegisteredWithEmail() {
        super("Usuário já cadastrado para este email");
    }

    public UserAlreadyRegisteredWithEmail(String message) {
        super(message);
    }
}
