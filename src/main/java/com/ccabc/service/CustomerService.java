package com.ccabc.service;

import com.ccabc.model.Customer;
import com.ccabc.repository.CustomerRepository;
import com.ccabc.repository.CustomerRepositoryWithoutJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){
     return customerRepository.findAll();
    }

    public Customer getCustomerById(int id){
         Optional<Customer> customerOptional= customerRepository.findById(id);
            if(customerOptional.isPresent()) {
                return customerOptional.get();
            }
            return null;
    }

    public String addCustomer(Customer customer){
       Customer addedCustomer= customerRepository.save(customer);
       if (addedCustomer==null) {
           return "Customer Not Added";
       }
        return "Customer Added Successfully";
    }

    public String deleteCustomer(int id){
        customerRepository.deleteById(id);
        return "Customer Deleted Successfully";
    }

//    public boolean validateUser(String email, String password) {
//        Customer customer = customerRepository.findByEmail(email);
//        if (customer != null && customer.getPassword().equals(password)) {
//            return true;
//        }
//        return false;
//    }


}
