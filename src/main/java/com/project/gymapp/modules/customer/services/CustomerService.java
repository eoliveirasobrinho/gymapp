package com.project.gymapp.modules.customer.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymapp.modules.customer.exceptions.CustomerAlreadyRegisteredException;
import com.project.gymapp.modules.customer.exceptions.CustomerNotFoundException;
import com.project.gymapp.modules.customer.exceptions.CustomersEmptyListExceptionHandler;
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
            throw new CustomersEmptyListExceptionHandler();
        }

        return customers;
    }

    public Optional<Customer> getCustomerById(String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new CustomerNotFoundException();
        }

        return customer;
    }

    public Customer createCustomer(Customer customerData) {

        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now();
        Customer customerToSave = new Customer(customerData.getAddress(), customerData.getBirthday(), customerData.getEmail(), customerData.getLastname(), customerData.getName(), customerData.getProducts(), createdAt, updatedAt);
        return customerRepository.save(customerToSave);
    }

    public Customer updateCustomer(CustomerDTO customerDTO, String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new CustomerNotFoundException();
        }

        if (customerDTO.name() != null && !customerDTO.name().equals(customer.get().getName())) {
            customer.get().setName(customerDTO.name());
        }

        if (customerDTO.address() != null && !customerDTO.address().equals(customer.get().getAddress())) {
            customer.get().setAddress(customerDTO.address());
        }

        if (customerDTO.lastname() != null && !customerDTO.lastname().equals(customer.get().getLastname())) {
            customer.get().setLastname(customerDTO.lastname());
        }

        if (customerDTO.birthday() != null && !customerDTO.birthday().equals(customer.get().getBirthday())) {
            customer.get().setBirthday(customerDTO.birthday());
        }

        if (customerDTO.email() != null && !customerDTO.email().equals(customer.get().getEmail())) {
            customer.get().setEmail(customerDTO.email());
        }

        if (customerDTO.products() != null && !customerDTO.products().equals(customer.get().getProducts())) {
            customer.get().setProducts(customerDTO.products());
        }

        Customer customerToUpdate = customer.get();
        return customerRepository.save(customerToUpdate);

    }

    public void deleteCustomer(String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new CustomerNotFoundException();
        }

        Customer customerDelete = customer.get();
        customerRepository.delete(customerDelete);
    }

}
