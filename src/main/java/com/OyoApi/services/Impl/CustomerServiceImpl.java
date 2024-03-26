package com.OyoApi.services.Impl;

import com.OyoApi.entity.Customer;

import com.OyoApi.repository.CustomerRepository;
import com.OyoApi.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> getAllCusetomer = customerRepository.findAll();
        return getAllCusetomer;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Customer customer1 = new Customer();
        customer1.setCId(customer.getCId());
        customer1.setName(customer.getName());
        customer1.setEmail(customer.getEmail());

        Customer  saveCustomer = customerRepository.save(customer1);
        return  saveCustomer;
    }

    @Override
    public void deleteById(long cId) {
        customerRepository.deleteById(cId);
    }

    @Override
    public Customer getById(long cId) {
        Customer customerNotFound = customerRepository.findById(cId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer not found")
        );
        if (customerNotFound != null) {
            Customer customer = customerRepository.findById(cId).get();
            return customer;
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer not found with ID: " + cId);
        }
    }

    @Override
    public Customer updateCustomer(long cId, Customer customer) {
        // creat update customer
        Customer customerNotFound = customerRepository.findById(cId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer not found")
        );

        if (customerNotFound != null) {
            Customer customer1 = customerRepository.findById(cId).get();
            customer1.setCId(customer.getCId());
            customer1.setName(customer.getName());
            customer1.setEmail(customer.getEmail());
            customer1.setMobile(customer.getMobile());

            Customer saveCustomer = customerRepository.save(customer1);

            return saveCustomer;
            }else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer not found with ID: " + cId);

        }

    }
}
