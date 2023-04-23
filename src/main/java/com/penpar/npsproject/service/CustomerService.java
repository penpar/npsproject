package com.penpar.npsproject.service;

import java.util.List;
import java.util.Optional;

import com.penpar.npsproject.domain.Customer;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Optional<Customer> getCustomerById(Long id);

    void addCustomer(Customer customer);

    void updateCustomer(Long id, Customer customer);

    void deleteCustomer(Long id);
    
}