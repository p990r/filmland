package com.filmland.assessment.entity;

import com.filmland.assessment.Entity.Customer;
import com.filmland.assessment.TestModels;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    void getEmail() {
        Customer customer = TestModels.getCustomer();
        assertEquals("test@test.com", customer.getEmail());
    }

    @Test
    void getPassword() {
        Customer customer = TestModels.getCustomer();
        assertEquals("password", customer.getPassword());
    }
}
