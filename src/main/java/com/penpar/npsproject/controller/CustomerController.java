package com.penpar.npsproject.controller;

import static com.penpar.npsproject.utils.ApiUtils.success;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;

import com.penpar.npsproject.domain.Customer;
import com.penpar.npsproject.dto.CustomerDto;
import com.penpar.npsproject.service.CustomerService;
import com.penpar.npsproject.utils.ApiUtils.ApiResult;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ApiResult<List<CustomerDto>> getAllCustomers() {
        return success(customerService.getAllCustomers().stream()
        .map(CustomerDto::new)
        .collect(Collectors.toList()));

    }

    @GetMapping("/{id}")
    public ApiResult<CustomerDto> getCustomerById(@PathVariable Long id) {
        return success( customerService.getCustomerById(id)
        .map(CustomerDto::new)
        .orElseThrow(() -> new NotFoundException("Could not found product for " + id)));
        
    }

    @PostMapping
    public void addCustomer(@RequestBody CustomerDto customerDto) {
        customerService.addCustomer(new Customer(customerDto));
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(id, new Customer(customerDto));
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }


}
