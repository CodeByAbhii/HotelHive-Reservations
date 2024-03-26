package com.OyoApi.services.Impl;

import com.OyoApi.entity.Customer;

import com.OyoApi.repository.CustomerRepository;
import com.OyoApi.services.CustomerService;
import org.springframework.stereotype.Service;

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
        Customer  saveCustomer = customerRepository.save(customer);
        return  saveCustomer;
    }
}
