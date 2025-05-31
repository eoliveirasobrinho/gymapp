package com.project.gymapp.modules.products.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.gymapp.modules.products.exceptions.ProductAlreadyRegisteredWithIdException;
import com.project.gymapp.modules.products.exceptions.ProductByTypeNotFoundException;
import com.project.gymapp.modules.products.exceptions.ProductNotFoundException;
import com.project.gymapp.modules.products.exceptions.ProductsNotFoundException;
import com.project.gymapp.modules.products.exceptions.models.ProductsErrorResponse;

@ControllerAdvice
public class RestProductExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductsNotFoundException.class)
    private ResponseEntity<ProductsErrorResponse> productsNotFoundExceptionHandler(ProductsNotFoundException exception) {
        ProductsErrorResponse productNotFoundResponse = new ProductsErrorResponse(exception.getMessage(), 404);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(productNotFoundResponse);
    }

    @ExceptionHandler(ProductAlreadyRegisteredWithIdException.class)
    private ResponseEntity<ProductsErrorResponse> productAlreadyRegisteredExceptionHandler(ProductAlreadyRegisteredWithIdException exception) {
        ProductsErrorResponse productAlreadyRegistered = new ProductsErrorResponse(exception.getMessage(), 500);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(productAlreadyRegistered);
    }

    @ExceptionHandler(ProductByTypeNotFoundException.class)
    private ResponseEntity<ProductsErrorResponse> productByTypeNotFoundExceptionHandler(ProductByTypeNotFoundException exception) {
        ProductsErrorResponse productBytypeErrorResponse = new ProductsErrorResponse(exception.getMessage(), 404);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(productBytypeErrorResponse);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ProductsErrorResponse> productFoundExceptionHandler(ProductNotFoundException exception) {
        ProductsErrorResponse productNotFoundErrorResponse = new ProductsErrorResponse(exception.getMessage(), 404);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(productNotFoundErrorResponse);
    }
}
