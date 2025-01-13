package com.filmland.assessment;

import com.filmland.assessment.Entity.Customer;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService(customerRepository);
    }

    @Test
    void findAll() {
        when(customerRepository.findAll()).thenReturn(getCustomers());
        List<Customer> list = Lists.newArrayList(customerService.findAll());
        assertEquals(1, list.size());
    }

    @Test
    void create() {

    }

    @Test
    void login(){

    }

    @Test
    void getCustEmail(){

    }

    @Test
    void sharedUser(){

    }

    Customer getCustomer() {
        return new Customer("test@test.com", "password");
    }

    List<Customer> getCustomers() {
        return Lists.newArrayList(getCustomer());
    }
}