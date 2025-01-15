package com.filmland.assessment;

import com.filmland.assessment.Entity.Subscription;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
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
        Subscription subscription = TestModels.getSubscription();
        when(subscriptionRepository.save(any())).thenReturn(subscription);

        // When
        Subscription saved = subscriptionRepository.save(subscription);

        // Then
        verify(subscriptionRepository).save(subscription);

        assertEquals(subscription, saved);
    }

    @Test
    void addCustomers() {
        Subscription subscription = TestModels.getSubscription();
        assertEquals(0, subscription.getCustomers().size());
        subscription.addCustomer(TestModels.getCustomer());
        assertEquals(1, subscription.getCustomers().size());
    }

    @Test
    void addCategories() {
        Subscription subscription = TestModels.getSubscription();
        assertEquals(0, subscription.getCategories().size());
        subscription.addCategory(TestModels.getCategory());
        assertEquals(1, subscription.getCategories().size());
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