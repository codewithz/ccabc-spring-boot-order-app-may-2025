package com.ccabc.controller;

import com.ccabc.model.Customer;
import com.ccabc.service.CustomerService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;


    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {

        List<Customer> customers=customerService.getAllCustomers();
        return ResponseEntity.ok().body(customers);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@Positive(message = "Negative Ids are not allowed") @PathVariable(name = "id") int id) {
        Customer customer=customerService.getCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }


    @PostMapping
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        String status= customerService.addCustomer(customer);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(status);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(name = "id") int id) {
        String status= customerService.deleteCustomer(id);
        return ResponseEntity.status(204).body(status);
    }
}