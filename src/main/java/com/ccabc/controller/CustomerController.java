package com.ccabc.controller;

import com.ccabc.model.Customer;
import com.ccabc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing customers.
 * Provides endpoints for CRUD operations on Customer entities.
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    /**
     * Sets the CustomerService instance via dependency injection.
     *
     * @param customerService the service to handle customer operations
     */
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Retrieves a list of all customers.
     *
     * @return a list of Customer objects
     */
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    /**
     * Retrieves a customer by their ID.
     *
     * @param id the ID of the customer to retrieve
     * @return the Customer object with the specified ID
     */
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable(name = "id") int id) {
        return customerService.getCustomerById(id);
    }

    /**
     * Adds a new customer.
     *
     * @param customer the Customer object to add
     * @return a confirmation message
     */
    @PostMapping
    public String addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    /**
     * Deletes a customer by their ID.
     *
     * @param id the ID of the customer to delete
     * @return a confirmation message
     */
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable(name = "id") int id) {
        return customerService.deleteCustomer(id);
    }
}