package com.project.gymapp.modules.user.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("User not found! Try another one");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
