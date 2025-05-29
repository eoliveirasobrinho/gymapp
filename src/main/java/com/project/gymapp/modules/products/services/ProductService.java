package com.project.gymapp.modules.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymapp.modules.products.models.Product;
import com.project.gymapp.modules.products.models.dtos.ProductDTO;
import com.project.gymapp.modules.products.repositories.ProductRepository;
import com.project.gymapp.modules.utils.CreateUUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CreateUUID createUUID;

    public ProductService(ProductRepository productRepository, CreateUUID createUUID) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public List<Product> getAllProductsByProductType(String productType) {
        List<Product> productsByProductType = productRepository.findByProductType(productType);
        return productsByProductType;
    }

    public Product createProduct(ProductDTO productDTO) throws Exception {

        Optional<Product> productFounded = productRepository.findById(productDTO.id());
        if (productFounded == null) {
            throw new NullPointerException("Não foi possível Salvar! Favor preencher os campos obrigatórios");
        }

        if (productFounded.isPresent()) {
            throw new Exception("Produto já cadastrado no sistema!");
        }

        String id = createUUID.createUUID();
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
