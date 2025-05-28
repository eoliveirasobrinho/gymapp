package com.project.gymapp.modules.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymapp.modules.products.models.Product;
import com.project.gymapp.modules.products.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }
}
