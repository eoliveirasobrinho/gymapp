package com.project.gymapp.modules.products.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymapp.modules.products.models.Product;
import com.project.gymapp.modules.products.models.dtos.ProductDTO;
import com.project.gymapp.modules.products.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product createProduct(ProductDTO productDTO) {
        String id = UUID.randomUUID().toString();
        Product product = new Product(id, productDTO.brand(), productDTO.manufacturingDate(), productDTO.name(), productDTO.price(), productDTO.quantity(), productDTO.productDetails(), productDTO.productType(), productDTO.valiDate());
        Product productToSave = productRepository.save(product);
        return productToSave;
    }

    public Optional<Product> findById(String id) {
        Optional<Product> product = productRepository.findById(id);
        return product;
    }

    public void deleteById(String id) {
        Optional<Product> product = productRepository.findById(id);
        Product productToDelete = product.get();
        productRepository.delete(productToDelete);
    }
}
