package com.penpar.npsproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.penpar.npsproject.dao.CustomerDao;
import com.penpar.npsproject.domain.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
    
    private final CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
        
    }
    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerDao.findById(id);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) { //미구현
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCustomer'");
    }
    @Override
    public void updateCustomer(Long id, Customer customer) { //미구현
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCustomer'");
    }
    
}
