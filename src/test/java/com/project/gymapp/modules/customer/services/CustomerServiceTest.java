package com.project.gymapp.modules.customer.services;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


import com.project.gymapp.modules.customer.exceptions.CustomerAlreadyRegisteredException;
import com.project.gymapp.modules.customer.models.Customer;
import com.project.gymapp.modules.customer.models.dtos.CustomerDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import org.mockito.*;


import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;

import com.project.gymapp.modules.customer.models.Address;

import com.project.gymapp.modules.customer.repositories.CustomerRepository;


@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;


    @Captor
    private ArgumentCaptor<Customer> customerArgumentCaptor;


    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Nested
    class createCustomer {


        @DisplayName("Should create customer with success")
        @Test
        void shouldCreateCustomerWithSuccess() {
            //arrange
            Address address  = new Address("Porto alegre", "Brasil", "pinheiro","89","RS","beco a","91570123");
            CustomerDTO customerDto = new CustomerDTO(
                    "enio",
                    "oliveira",
                    "05/02/1987",
                    "enio@testing.com",
                    address,
                    null,
                    LocalDateTime.now()
                    ,LocalDateTime.now());
            Customer customerToCreate = new Customer(customerDto);



            //act
            var output = when(customerService.createCustomer(customerDto)).thenReturn(customerToCreate);



            //assert
            assertNotNull(output);

        }

        @DisplayName("should do exception when customer not created with success")
        @Test
        void shouldThrowExceptionWhenCustomerNotCreateWithSuccess() {

        }


    }

}
