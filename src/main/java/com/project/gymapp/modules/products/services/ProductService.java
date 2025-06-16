package com.project.gymapp.modules.products.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymapp.modules.products.exceptions.ProductByTypeNotFoundException;
import com.project.gymapp.modules.products.exceptions.ProductNotFoundException;
import com.project.gymapp.modules.products.exceptions.ProductsNotFoundException;
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
        if (products.isEmpty()) {
            throw new ProductsNotFoundException();
        }
        return products;
    }

    public List<Product> getAllProductsByProductType(String productType) {
        List<Product> productsByProductType = productRepository.findByProductType(productType);
        if (productsByProductType.isEmpty()) {
            throw new ProductByTypeNotFoundException();
        }
        return productsByProductType;
    }

    public Product createProduct(ProductDTO productDTO) {

        Product product = new Product(productDTO.brand(), productDTO.manufacturingDate(), productDTO.name(), productDTO.price(), productDTO.quantity(), productDTO.productDetails(), productDTO.productType(), productDTO.valiDate());

        return productRepository.save(product);
    }

    public Optional<Product> findById(String id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException();
        }
        return product;
    }

    public void deleteById(String id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException();
        }
        Product productToDelete = product.get();
        productRepository.delete(productToDelete);
    }

    public Product updateProduct(ProductDTO productDTO, String id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isEmpty()) {
            throw new ProductNotFoundException();
        }

        if (productDTO.name() != null && !productDTO.name().equals(product.get().getName())) {
            product.get().setName(productDTO.name());
        }

        if (productDTO.brand() != null && !productDTO.brand().equals(product.get().getBrand())) {
            product.get().setBrand(productDTO.brand());
        }

        if (productDTO.price() != null && !productDTO.price().equals(product.get().getPrice())) {
            product.get().setPrice(productDTO.price());
        }

        if (productDTO.manufacturingDate() != null && !productDTO.manufacturingDate().equals(product.get().getManufacturingDate())) {
            product.get().setManufacturingDate(productDTO.manufacturingDate());
        }

        if (productDTO.valiDate() != null && !productDTO.valiDate().equals(product.get().getValiDate())) {
            product.get().setValiDate(productDTO.valiDate());
        }

        if (productDTO.productDetails() != null && !productDTO.productDetails().equals(product.get().getProductDetails())) {
            product.get().setProductDetails(productDTO.productDetails());
        }

        if (productDTO.productType() != null && !productDTO.productType().equals(product.get().getProductType())) {
            product.get().setProductType(productDTO.productType());
        }

        if (productDTO.quantity() != null && !productDTO.quantity().equals(product.get().getQuantity())) {
            product.get().setQuantity(productDTO.quantity());
        }

        Product productToSave = product.get();
        return productRepository.save(productToSave);
    }

}