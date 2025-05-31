package com.project.gymapp.modules.user.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.gymapp.modules.user.exceptions.UserAlreadyRegisteredWithEmail;
import com.project.gymapp.modules.user.exceptions.UserNotFoundException;
import com.project.gymapp.modules.user.exceptions.UsersListIsEmptyException;
import com.project.gymapp.modules.user.exceptions.models.UserErrorResponse;

@ControllerAdvice
public class UserRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<UserErrorResponse> userNotFoundExceptionHandler(UserNotFoundException exception) {
        UserErrorResponse userErrorResponse = new UserErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userErrorResponse);
    }

    @ExceptionHandler(UsersListIsEmptyException.class)
    private ResponseEntity<UserErrorResponse> usersListIsEmptyExceptionHandler(UsersListIsEmptyException exception) {
        UserErrorResponse userErrorResponse = new UserErrorResponse(exception.getMessage(), HttpStatus.NO_CONTENT);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(userErrorResponse);
    }

    @ExceptionHandler
    private ResponseEntity<UserErrorResponse> userAlreadyRegisteredWithEmail(UserAlreadyRegisteredWithEmail exception) {
        UserErrorResponse userErrorResponse = new UserErrorResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userErrorResponse);
    }
}
