package com.ccabc.controller;

import com.ccabc.model.Customer;
import com.ccabc.payload.ApiSuccessPayload;
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
    public ResponseEntity<ApiSuccessPayload> getAllCustomers() {

        List<Customer> customers=customerService.getAllCustomers();

        ApiSuccessPayload apiSuccessPayload=new ApiSuccessPayload();
        apiSuccessPayload.setMessage("List of Customers");
        apiSuccessPayload.setStatusCode(200);
        apiSuccessPayload.setHttpStatus("OK");
        apiSuccessPayload.setSuccess(true);
        apiSuccessPayload.setException(false);
        apiSuccessPayload.setTimestamp(java.time.LocalDateTime.now());
        apiSuccessPayload.setBody(customers);

        return new ResponseEntity<>(apiSuccessPayload, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiSuccessPayload> getCustomerById(@Positive(message = "Negative Ids are not allowed") @PathVariable(name = "id") int id) {
        Customer customer=customerService.getCustomerById(id);
        HttpStatus status=HttpStatus.OK;
        ApiSuccessPayload apiSuccessPayload=ApiSuccessPayload.build(customer,status,"Customer Found Successfully");
        return new ResponseEntity<>(apiSuccessPayload, status);
    }


    @PostMapping
    public ResponseEntity<ApiSuccessPayload> addCustomer(@RequestBody Customer customer) {
        String result= customerService.addCustomer(customer);
        HttpStatus status=HttpStatus.CREATED;
        ApiSuccessPayload apiSuccessPayload=ApiSuccessPayload.build(result,status,"Customer Added Successfully");
        return new ResponseEntity<>(apiSuccessPayload, status);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiSuccessPayload> deleteCustomer(@PathVariable(name = "id") int id) {
        String result= customerService.deleteCustomer(id);
        HttpStatus status=HttpStatus.valueOf(204);
        ApiSuccessPayload apiSuccessPayload=ApiSuccessPayload.build(result,status,"Customer Deleted Successfully");
        return new ResponseEntity<>(apiSuccessPayload, status);
    }
//    @PostMapping("/login")
//    public ResponseEntity<ApiSuccessPayload> login(@RequestParam String email, @RequestParam String password) {
//        boolean isValidUser = customerService.validateUser(email, password);
//        if (isValidUser) {
//            return ResponseEntity.status(HttpStatus.OK).body("Login Successful");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
//        }
//    }

}