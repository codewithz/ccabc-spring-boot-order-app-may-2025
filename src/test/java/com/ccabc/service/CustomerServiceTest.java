package com.ccabc.service;

import com.ccabc.model.Customer;
import com.ccabc.repository.CustomerRepositoryWithoutJPA;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepositoryWithoutJPA customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void validateUserReturnsTrueWhenCredentialsAreValid() {
        Customer customer = new Customer();
        customer.setEmail("test@example.com");
        customer.setPassword("password123");

        when(customerRepository.findByEmail("test@example.com")).thenReturn(customer);

        boolean result = customerService.validateUser("test@example.com", "password123");

        assertTrue(result);
    }

    @Test
    void validateUserReturnsFalseWhenEmailDoesNotExist() {
        when(customerRepository.findByEmail("nonexistent@example.com")).thenReturn(null);

        boolean result = customerService.validateUser("nonexistent@example.com", "password123");

        assertFalse(result);
    }

    @Test
    void validateUserReturnsFalseWhenPasswordIsIncorrect() {
        Customer customer = new Customer();
        customer.setEmail("test@example.com");
        customer.setPassword("password123");

        when(customerRepository.findByEmail("test@example.com")).thenReturn(customer);

        boolean result = customerService.validateUser("test@example.com", "wrongpassword");

        assertFalse(result);
    }

    @Test
    void validateUserReturnsFalseWhenEmailIsNull() {
        boolean result = customerService.validateUser(null, "password123");

        assertFalse(result);
    }

    @Test
    void validateUserReturnsFalseWhenPasswordIsNull() {
        Customer customer = new Customer();
        customer.setEmail("test@example.com");
        customer.setPassword("password123");

        when(customerRepository.findByEmail("test@example.com")).thenReturn(customer);

        boolean result = customerService.validateUser("test@example.com", null);

        assertFalse(result);
    }
}
