package com.project.gymapp.modules.customer.models.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.project.gymapp.modules.customer.models.Address;
import com.project.gymapp.modules.customer.models.Customer;
import com.project.gymapp.modules.products.models.Product;
import jakarta.annotation.Nullable;

public record CustomerDTO(String name, String lastname, String birthday, String email, Address address, List<Product> products, LocalDateTime createdAt, LocalDateTime updatedAt) {

}
