package com.filmland.assessment;

import com.filmland.assessment.Entity.Customer;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
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
        Customer customer = getCustomer();
        when(customerRepository.save(any())).thenReturn(customer);

        // When
        Customer saved = customerRepository.save(customer);

        // Then
        verify(customerRepository).save(customer);

        assertEquals(customer, saved);
    }

    @Test
    void login(){
        Customer customer = getCustomer();
        when(customerRepository.findByEmail(any())).thenReturn(Optional.of(customer));
        assertEquals(customerService.login(customer).getStatusCode().toString(), "200 OK");
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