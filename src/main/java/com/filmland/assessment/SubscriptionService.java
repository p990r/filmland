package com.filmland.assessment;

import com.filmland.assessment.Entity.Category;
import com.filmland.assessment.Entity.Customer;
import com.filmland.assessment.Entity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

    public Subscription addCustomers(Long id, List<Customer> customers){
        Optional<Subscription> subscription = subscriptionRepository.findById(id);
        if(subscription.isPresent()){
            for (Customer cus : customers){
                Optional<Customer> customer = customerRepository.findByEmail(cus.getEmail());
                if(customer.isPresent()){
                    subscription.get().addCustomer(customer.get());
                }
            }
            return subscription.get();
        }
        return null;
    }

    public Subscription addCategories(Long id, List<Category> categories){
        Optional<Subscription> subscription = subscriptionRepository.findById(id);
        if(subscription.isPresent()){
            for (Category cat : categories){
                Optional<Category> category = categoryRepository.findByName(cat.getName());
                if(category.isPresent()){
                    subscription.get().addCategory(cat);
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

    public Map<List<Category>,List<Category>> getSubscribedCategories(String email){
        Optional<Customer> customer = customerRepository.findByEmail(email);
        if(customer.isPresent()) {
            Subscription subscription = subscriptionRepository.findByCustomers_email(email);
            List<Category> availableCategories = categoryRepository.findAll();
            List<Category> subscribedCategories = new ArrayList<>();
            List<Category> customerCategories = subscription.getCategories();
            for(Category item:customerCategories){
                Optional<Category> category = categoryRepository.findByName(item.getName());
                if(category.isPresent()) {
                    availableCategories.remove(category.get());
                    subscribedCategories.add(category.get());
                }
            }
            Map<List<Category>,List<Category>> map =new HashMap();
            map.put(availableCategories,subscribedCategories);
            return map;
        }
        return null;
    }
}
