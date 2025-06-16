package com.project.gymapp.modules.customer.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.gymapp.modules.customer.models.Customer;
import com.project.gymapp.modules.customer.models.dtos.CustomerDTO;
import com.project.gymapp.modules.customer.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/health")
    public String health() {
        return "ok";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers()  {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.status(HttpStatus.OK).body(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable String id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customerToParse = new Customer(customerDTO);
        Customer customer = customerService.createCustomer(customerToParse);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable String id) {
        Customer customer = customerService.updateCustomer(customerDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<Customer>> deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }
}
