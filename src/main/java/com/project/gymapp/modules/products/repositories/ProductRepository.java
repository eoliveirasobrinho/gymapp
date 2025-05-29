package com.project.gymapp.modules.products.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.gymapp.modules.products.models.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    public List<Product> findByProductType(String productType);
}
