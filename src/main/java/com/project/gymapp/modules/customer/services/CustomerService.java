package com.project.gymapp.modules.customer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymapp.modules.customer.exceptions.CustomerNotFoundException;
import com.project.gymapp.modules.customer.exceptions.CustomersNotFoundException;
import com.project.gymapp.modules.customer.models.Customer;
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

}
