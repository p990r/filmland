package com.filmland.assessment;

import com.filmland.assessment.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerService(){
    }

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public ResponseEntity<Object> login(Customer customer) {
        Map<String, String> body = new HashMap<>();
        Optional<Customer> customer1 = customerRepository.findByEmail(customer.getEmail());
        if(customer1.isPresent() && customer.getPassword().equals(customer.getPassword())) {
            body.put("status:", "Login successful");
            body.put("message:", "Welcome " + customer.getEmail());
            return new ResponseEntity<>(body, HttpStatus.OK);
        }
        body.put("status:", "Login failed");
        body.put("message:", "Wrong credentials");
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
