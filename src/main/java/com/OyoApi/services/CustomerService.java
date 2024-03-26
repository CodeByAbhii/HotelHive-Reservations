package com.OyoApi.services;

import com.OyoApi.entity.Customer;


import java.util.List;

public interface CustomerService {

    public List<Customer>getAllCustomer();

    Customer createCustomer(Customer customer);

    void deleteById(long cId);
    Customer getById(long cId) ;

    Customer updateCustomer( long cId , Customer customer);


}
