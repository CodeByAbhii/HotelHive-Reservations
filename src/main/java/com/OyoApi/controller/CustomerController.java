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
    //http://localhost:8080/api/customer/1
    @DeleteMapping
    public ResponseEntity<String> deleteById(@PathVariable long cId){
        customerService.deleteById(cId);
        return new ResponseEntity<>(" Customer is Deleted!!" , HttpStatus.OK);
    }
    //http://localhost:8080/api/customer?cId=1
    @PutMapping
    public ResponseEntity<Customer> updateById(@RequestParam long cId, @RequestBody Customer customer){
        Customer customer1 = customerService.updateCustomer(cId, customer);
        return new ResponseEntity<>(customer1, HttpStatus.OK);
    }
    //http://localhost:8080/api/customer/1
    @GetMapping("/{cId}")
    public ResponseEntity<Customer> getById(@PathVariable long cId){
        Customer customer = customerService.getById(cId);
        return new ResponseEntity<>(customer , HttpStatus.OK);
    }
}
