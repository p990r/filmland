package com.filmland.assessment;

import com.filmland.assessment.Entity.Category;
import com.filmland.assessment.Entity.Customer;
import com.filmland.assessment.Entity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api/subscriptions")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping
    public Iterable<Subscription> list() {
        return this.subscriptionService.findAll();
    }

    @PostMapping("new")
    public Subscription create(@RequestBody Subscription subscription) {
        return this.subscriptionService.create(subscription);
    }

    @PostMapping("addcustomers")
    public Subscription addCustomers(@RequestBody Long id, List<Customer> customers) {
        return this.subscriptionService.addCustomers(id, customers);
    }

    @PostMapping("addcategories")
    public Subscription addCategories(@RequestBody Long id, List<Category> categories) {
        return this.subscriptionService.addCategories(id, categories);
    }

    @PostMapping("addstartdate")
    public Subscription addStartDate(@RequestBody Long id, Date date) {
        return this.subscriptionService.addStartDate(id, date);
    }

    @PostMapping("addenddate")
    public Subscription addEndDate(@RequestBody Long id, Date date) {
        return this.subscriptionService.addEndDate(id, date);
    }

    @GetMapping("subscribed")
    public Map<List<Category>,List<Category>> getSubscribedCategories(@PathVariable String email){
        return subscriptionService.getSubscribedCategories(email);
    }

    @GetMapping("setpaymentdate")
    public ResponseEntity<Object> setPaymentDate(@PathVariable Long id){
        return subscriptionService.setPaymentDate(id);
    }
}
