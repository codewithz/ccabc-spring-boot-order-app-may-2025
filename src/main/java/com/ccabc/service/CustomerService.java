package com.ccabc.service;

import com.ccabc.model.Customer;
import com.ccabc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){
     return customerRepository.getAllCustomers();
    }

    public Customer getCustomerById(int id){
        return customerRepository.getCustomerById(id);
    }

    public String addCustomer(Customer customer){
        return customerRepository.addCustomer(customer);
    }

    public String deleteCustomer(int id){
        return customerRepository.deleteCustomer(id);
    }

    public boolean validateUser(String email, String password) {
        Customer customer = customerRepository.findByEmail(email);
        if (customer != null && customer.getPassword().equals(password)) {
            return true;
        }
        return false;
    }


}
