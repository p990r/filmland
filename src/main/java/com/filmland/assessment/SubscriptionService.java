package com.filmland.assessment;

import com.filmland.assessment.Entity.Category;
import com.filmland.assessment.Entity.Customer;
import com.filmland.assessment.Entity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public SubscriptionService(){
    }

    public Iterable<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    public Subscription create(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public Subscription addCustomers(Long id, List<String> customers){
        Optional<Subscription> subscription = subscriptionRepository.findById(id);
        if(subscription.isPresent()){
            for (String email : customers){
                Optional<Customer> customer = customerRepository.findByEmail(email);
                if(customer.isPresent()){
                    subscription.get().addCustomer(customer.get());
                }
            }
            return subscription.get();
        }
        return null;
    }

    public Subscription addCategories(Long id, List<Long> categories){
        Optional<Subscription> subscription = subscriptionRepository.findById(id);
        if(subscription.isPresent()){
            for (Long catid : categories){
                Optional<Category> category = categoryRepository.findById(catid);
                if(category.isPresent()){
                    subscription.get().addCategory(category.get());
                }
            }
            return subscription.get();
        }
        return null;
    }

    public Subscription addStartDate(Long id, Date date){
        Optional<Subscription> subscription = subscriptionRepository.findById(id);
        if(subscription.isPresent()){
            subscription.get().setStartDate(date);
            return subscription.get();
        }
        return null;
    }

    public Subscription addEndDate(Long id, Date date){
        Optional<Subscription> subscription = subscriptionRepository.findById(id);
        if(subscription.isPresent()){
            subscription.get().setEndDate(date);
            return subscription.get();
        }
        return null;
    }
    //TODO:
    //send customer email, return list with unsubscribed (available) categories
    // and list with subscribed categories
}
