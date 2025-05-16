package com.ccabc.repository;

import com.ccabc.model.Customer;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


public class CustomerRepositoryWithoutJPA {

    private List<Customer> customers=new ArrayList<>();

    public CustomerRepositoryWithoutJPA(){
//        Seeding some dummy customers
        Customer customer1=new Customer(10001,"Tom Smith","tom@gmail.com","tom@1234","998877", LocalDate.of(2023, Month.JULY,12));
        Customer customer2=new Customer(10002,"Alex Li","alex@gmail.com","alex@1234","998879", LocalDate.of(2024, Month.DECEMBER,20));

        customers.add(customer1);
        customers.add(customer2);
    }

    public List<Customer> getAllCustomers(){
        return customers;
    }

    public Customer getCustomerById(int id){
        Customer customer=null;

        for(Customer c:customers){
            if(c.getId()==id){
                customer=c;
                break;
            }
        }
        return customer;
    }

    public String addCustomer(Customer customer){
        customers.add(customer);
        System.out.println(customer);
        return "Customer Added Successfully";
    }

    public String deleteCustomer(int id){
        Customer customerToBeDeleted=getCustomerById(id);
        customers.remove(customerToBeDeleted);
        return "Customer Deleted Successfully";
    }

    public Customer findByEmail(String email) {
        for (Customer customer : customers) {
            if (customer.getEmail().equalsIgnoreCase(email)) {
                return customer;
            }
        }
        return null; // Return null if no customer is found with the given email
    }
}
