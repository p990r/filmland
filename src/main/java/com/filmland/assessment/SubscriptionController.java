package com.filmland.assessment;

import com.filmland.assessment.Entity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
