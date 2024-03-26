package com.OyoApi.controller;


import com.OyoApi.entity.Customer;
import com.OyoApi.repository.CustomerRepository;
import com.OyoApi.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //http://localhost:8080/api/customer
    //create post mapping for customer
    @PostMapping
    public ResponseEntity<Customer> makeCustomer(@RequestBody Customer customer){
        Customer customer1 = customerService.createCustomer(customer);
        return new ResponseEntity<>(customer1, HttpStatus.CREATED);
    }


    //http://localhost:8080/api/customer
    @GetMapping
    public ResponseEntity<List<Customer>>getAllCustomer(){
        List<Customer> allCustomer = customerService.getAllCustomer();
        return new ResponseEntity<>(allCustomer , HttpStatus.OK);
    }
}
