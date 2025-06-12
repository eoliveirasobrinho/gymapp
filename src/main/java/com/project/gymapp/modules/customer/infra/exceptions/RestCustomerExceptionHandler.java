package com.project.gymapp.modules.customer.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.gymapp.modules.customer.exceptions.CustomerAlreadyRegisteredException;
import com.project.gymapp.modules.customer.exceptions.CustomerNotFoundException;
import com.project.gymapp.modules.customer.exceptions.CustomerWasNotCreatedException;
import com.project.gymapp.modules.customer.exceptions.CustomersEmptyListExceptionHandler;
import com.project.gymapp.modules.customer.exceptions.models.CustomerErrorResponse;

@ControllerAdvice
public class RestCustomerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    private ResponseEntity<CustomerErrorResponse> customerNotfoundExceptionHandler(Exception exception) {
        CustomerErrorResponse errorResponse = new CustomerErrorResponse(exception.getMessage(), 404);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(CustomersEmptyListExceptionHandler.class)
    private ResponseEntity<CustomerErrorResponse> customersEmptyListExceptionHandler(Exception exception) {
        CustomerErrorResponse errorResponse = new CustomerErrorResponse(exception.getMessage(), 404);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(CustomerAlreadyRegisteredException.class)
    private ResponseEntity<CustomerErrorResponse> customerAlreadyRegisteredExceptionHandler(Exception exception) {
        CustomerErrorResponse errorResponse = new CustomerErrorResponse(exception.getMessage(), 500);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(CustomerWasNotCreatedException.class)
    private ResponseEntity<CustomerErrorResponse> customerWasNotCreatedExceptionHandler(Exception exception) {
        CustomerErrorResponse errorResponse = new CustomerErrorResponse(exception.getMessage(), 500);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
