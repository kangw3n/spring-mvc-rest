package com.kangwen.springmvcrest.services;

import com.kangwen.springmvcrest.domain.Customer;

import java.util.List;

public interface CustomerService {

    Customer findCustomerById(Long id);
    List<Customer> findAllCustomers();

    Customer saveCustomer(Customer customer);
    void deleteCustomer(Long id);
    long size();
}
