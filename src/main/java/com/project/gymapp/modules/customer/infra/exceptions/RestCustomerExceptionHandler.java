package com.project.gymapp.modules.customer.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.gymapp.modules.customer.exceptions.models.CustomerErrorResponse;

@ControllerAdvice
public class RestCustomerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<CustomerErrorResponse> customerNotfoundExceptionHandler(Exception exception) {
        CustomerErrorResponse errorResponse = new CustomerErrorResponse(exception.getMessage(), 404);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler
    private ResponseEntity<CustomerErrorResponse> customersNotFoundExceptionHandler(Exception exception) {
        CustomerErrorResponse errorResponse = new CustomerErrorResponse(exception.getMessage(), 404);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler
    private ResponseEntity<CustomerErrorResponse> customerAlreadyRegisteredExceptionHandler(Exception exception) {
        CustomerErrorResponse errorResponse = new CustomerErrorResponse(exception.getMessage(), 500);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler
    private ResponseEntity<CustomerErrorResponse> customerWasNotCreatedExceptionHandler(Exception exception) {
        CustomerErrorResponse errorResponse = new CustomerErrorResponse(exception.getMessage(), 500);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
