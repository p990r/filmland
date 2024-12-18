package com.filmland.assessment;

import io.micrometer.core.ipc.http.HttpSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.filmland.assessment.Entity.Customer;

import java.net.http.HttpResponse;

@CrossOrigin
@RestController
@RequestMapping("api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public Iterable<Customer> list() {
        return this.customerService.findAll();
    }

    @PostMapping("new")
    public Customer create(@RequestBody Customer customer) {
        return this.customerService.create(customer);
    }

    // Hardcoded customer for testing
    @PostMapping("test")
    public Customer create1() {
        Customer customer = new Customer("e@mail.com", "123");
        return this.customerService.create(customer);
    }

    @PostMapping("login")
    public ResponseEntity<Object> login(@RequestBody Customer customer) {
        return this.customerService.login(customer);
    }
}
