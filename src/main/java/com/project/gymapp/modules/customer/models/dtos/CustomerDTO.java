package com.project.gymapp.modules.customer.models.dtos;

import java.util.List;

import com.project.gymapp.modules.customer.models.Address;
import com.project.gymapp.modules.products.models.Product;

public record CustomerDTO(String id, String name, String lastname, String birthday, String email, Address address, List<Product> products) {

}
