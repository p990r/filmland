package com.filmland.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
