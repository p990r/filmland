package com.filmland.assessment.entity;

import com.filmland.assessment.Entity.Subscription;
import com.filmland.assessment.TestModels;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubscriptionTest {

    @Test
    void getCustomers(){
        Subscription subscription = TestModels.getSubscription();
        assertEquals(1, subscription.getCustomers().size());
    }

    @Test
    void getCategories(){
        Subscription subscription = TestModels.getSubscription();
        assertEquals(1, subscription.getCategories().size());
    }

    @Test
    void getStartDate(){
        Subscription subscription = TestModels.getSubscription();
        assertEquals(2001, subscription.getStartDate().getYear());
    }

    @Test
    void getEndDate(){
        Subscription subscription = TestModels.getSubscription();
        assertEquals(2002, subscription.getEndDate().getYear());
    }
}
