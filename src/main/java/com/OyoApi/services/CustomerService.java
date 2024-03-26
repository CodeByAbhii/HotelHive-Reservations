package com.OyoApi.services;

import com.OyoApi.entity.Customer;


import java.util.List;

public interface CustomerService {

    public List<Customer>getAllCustomer();

    Customer createCustomer(Customer customer);
}
