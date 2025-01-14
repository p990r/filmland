package com.filmland.assessment;

import com.filmland.assessment.Entity.Subscription;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class SubscriptionServiceTest {
    SubscriptionService subscriptionService;

    @Mock
    SubscriptionRepository subscriptionRepository;

    @BeforeEach
    void setUp() {
        subscriptionService = new SubscriptionService(subscriptionRepository);
    }

    @Test
    void findAll() {
        when(subscriptionRepository.findAll()).thenReturn(TestModels.getSubscriptions());
        List<Subscription> list = Lists.newArrayList(subscriptionRepository.findAll());
        assertEquals(1, list.size());
    }

    @Test
    void create() {
    }

    @Test
    void addCustomers() {
    }

    @Test
    void addCategories() {
    }

    @Test
    void addStartDate() {
    }

    @Test
    void addEndDate() {
    }

    @Test
    void getSubscribedCategories() {
    }

    @Test
    void setPaymentDate() {
    }
}