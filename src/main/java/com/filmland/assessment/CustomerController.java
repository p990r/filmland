package com.filmland.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.filmland.assessment.Entity.Customer;

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

    @PostMapping("test")
    public Customer create1() {
        Customer customer = new Customer();
        System.out.println(customer);
        customer.setEmail("e@mail.com");
        customer.setPassword("1234");
        System.out.println(customer);
        return this.customerService.create(customer);
    }
}
