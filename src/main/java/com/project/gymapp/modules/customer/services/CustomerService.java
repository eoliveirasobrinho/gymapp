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

    public Customer updateCustomer(CustomerDTO customerDTO, String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new CustomerNotFoundException();
        }

        if (customer.isPresent()) {
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

        }

        Customer customerToUpdate = customer.get();
        Customer customerSaved = customerRepository.save(customerToUpdate);
        return customerSaved;

    }

    public void deleteCustomer(String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new CustomerNotFoundException();
        }

        Customer customerTodelete = customer.get();
        customerRepository.delete(customerTodelete);
    }

}
