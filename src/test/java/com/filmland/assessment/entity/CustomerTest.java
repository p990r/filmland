package com.filmland.assessment.entity;

import com.filmland.assessment.Entity.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void getEmail() {
        Customer customer = getCustomer();
        assertEquals("test@test.com", customer.getEmail());
    }

    @Test
    void getPassword() {
        Customer customer = getCustomer();
        assertEquals("password", customer.getPassword());
    }

    Customer getCustomer() {
        return new Customer("test@test.com", "password");
    }
}
