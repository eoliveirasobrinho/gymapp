package com.project.gymapp.modules.products.exceptions.models;

public class ProductsErrorResponse {

    private String message;
    private int statusCode;

    public ProductsErrorResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return statusCode;
    }

    public void setCode(int code) {
        this.statusCode = code;
    }

}
