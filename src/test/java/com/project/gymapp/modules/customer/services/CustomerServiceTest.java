package com.project.gymapp.modules.customer.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;

import com.project.gymapp.modules.customer.models.Address;
import com.project.gymapp.modules.customer.models.Customer;
import com.project.gymapp.modules.customer.repositories.CustomerRepository;
import com.project.gymapp.modules.products.models.Product;
import com.project.gymapp.modules.products.models.ProductDetails;
import com.project.gymapp.modules.products.models.enums.ProductType;

@ActiveProfiles("test")
@DataMongoTest
@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should create a customer in database successfully")
    void testCreateCustomerSuccess() {

        Customer customerCreated = this.createCustomerToTest();
        doReturn(customerCreated).when(customerRepository).save(any());
        Customer customer = customerService.createCustomer(customerCreated);

        assertNotNull(customer, "Customer cannot be empty");

        assertEquals("4343208932", customer.getId());

    }

    @Test
    @DisplayName("Should not create a customer in database")
    void testNotCreateCustomerSuccess() {
        Customer customerCreated = this.createCustomerToTest();
        doReturn(customerCreated).when(customerRepository).save(any());
        Customer customer = customerService.createCustomer(customerCreated);

        assertNotNull(customer, "Customer cannot be empty");

        assertNotEquals("37643246327", customer.getId());
    }

    @Test
    @DisplayName("Should delete customer successfully")
    void testDeleteCustomerSuccessfully() {

    }

    @Test
    @DisplayName("Should not delete customer successfully")
    void testNotDeleteCustomerSuccessfully() {

    }

    @Test
    void testGetAllCustomers() {

    }

    @Test
    void testGetCustomerById() {
        Customer customerCreated = this.createCustomerToTest();
        doReturn(customerCreated).when(customerRepository).save(any());
        Optional<Customer> foundedCustomerToCompare = customerService.getCustomerById("4343208932");
        Customer customerParsed = foundedCustomerToCompare.get();
        assertEquals("4343208932", customerParsed.getId());
    }

    @Test
    void testUpdateCustomer() {

    }

    private Customer createCustomerToTest() {
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now();
        Address address = new Address("porto alegre", "Brasil", "Lomba do pinheiro", "09", "Rio Grande do sul", "beco A", "91570123");
        ProductDetails productDetailsShirt = new ProductDetails("60cm", "0", "120g", "30cm");
        ProductDetails productDetailsDrink = new ProductDetails("60cm", "0", "120g", "30cm");
        Product product1 = new Product("Integral", "12/05/2023", "Camisa Integral Oversized", BigDecimal.valueOf(119), 1, productDetailsShirt, ProductType.VESTUARY, "22/12/2013");
        Product product2 = new Product("Red Bull", "12/12/2024", "Energético Red Bull basic", BigDecimal.valueOf(9.90), 1, productDetailsDrink, ProductType.DRINK_FOOD, "12/10/2025");
        List<Product> products = new ArrayList<>(List.of(product1, product2));
        Customer customer = new Customer(address, "05/02/1987", "enio@test.com", "oliveira", "enio", products, createdAt, updatedAt);
        customerRepository.save(customer);
        return customer;
    }
}
