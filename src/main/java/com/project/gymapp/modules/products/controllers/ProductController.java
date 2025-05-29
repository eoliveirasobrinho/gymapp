package com.project.gymapp.modules.products.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.gymapp.modules.products.models.Product;
import com.project.gymapp.modules.products.models.dtos.ProductDTO;
import com.project.gymapp.modules.products.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/health")
    public String health() {
        return "ok";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return products.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/product-type/{productType}")
    public ResponseEntity<List<Product>> getProductByProductType(@PathVariable String productType) {
        List<Product> products = productService.getAllProductsByProductType(productType);
        return products.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductDTO productDto) throws Exception {
        Product product = productService.createProduct(productDto);
        return product.getId().isEmpty() ? ResponseEntity.status(HttpStatus.BAD_REQUEST).build() : ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable String id) {
        Optional<Product> product = productService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<Product>> deleteProductById(@PathVariable String id) {
        productService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody @Valid ProductDTO productDTO, @PathVariable String id) {
        Product product = productService.updateProduct(productDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

}
