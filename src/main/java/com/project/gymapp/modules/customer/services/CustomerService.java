package com.project.gymapp.modules.customer.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymapp.modules.customer.exceptions.CustomerAlreadyRegisteredException;
import com.project.gymapp.modules.customer.exceptions.CustomerNotFoundException;
import com.project.gymapp.modules.customer.exceptions.CustomersNotFoundException;
import com.project.gymapp.modules.customer.models.Customer;
import com.project.gymapp.modules.customer.models.dtos.CustomerDTO;
import com.project.gymapp.modules.customer.repositories.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() throws Exception {
        List<Customer> customers = customerRepository.findAll();
        if (customers.isEmpty()) {
            throw new CustomersNotFoundException();
        }

        return customers;
    }

    public Optional<Customer> getCustomerById(String id) throws Exception {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new CustomerNotFoundException();
        }

        if (customer == null) {
            throw new NullPointerException();
        }

        return customer;
    }

    public Customer createCustomer(CustomerDTO customerDTO) {
        Optional<Customer> customerId = customerRepository.findById(customerDTO.id());
        if (customerId.isPresent()) {
            throw new CustomerAlreadyRegisteredException();
        }

        if (customerDTO == null) {
            throw new NullPointerException();
        }

        String id = UUID.randomUUID().toString();
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now();
        Customer customerToSave = new Customer(id, customerDTO.address(), customerDTO.birthday(), customerDTO.email(), customerDTO.lastname(), customerDTO.name(), customerDTO.products(), createdAt, updatedAt);
        Customer customer = customerRepository.save(customerToSave);
        return customer;
    }

}
