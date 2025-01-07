package com.filmland.assessment;

import com.filmland.assessment.Entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Subscription findByCustomers_email(String customer);
}
