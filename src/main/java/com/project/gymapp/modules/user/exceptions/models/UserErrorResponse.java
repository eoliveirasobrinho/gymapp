package com.project.gymapp.modules.user.exceptions.models;

import org.springframework.http.HttpStatus;

public class UserErrorResponse {

    private String message;
    private HttpStatus status;

    public UserErrorResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

}
