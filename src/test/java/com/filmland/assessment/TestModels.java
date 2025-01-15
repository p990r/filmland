package com.filmland.assessment;

import com.filmland.assessment.Entity.Category;
import com.filmland.assessment.Entity.Customer;
import com.filmland.assessment.Entity.Subscription;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.List;

public class TestModels {
    public static Customer getCustomer() {
        return new Customer("test@test.com", "password");
    }

    public static List<Customer> getCustomers() {
        return Lists.newArrayList(getCustomer());
    }

    public static Category getCategory() {
        return new Category("test", 1, 0.5);
    }

    public static List<Category> getCategories() {
        return Lists.newArrayList(getCategory());
    }

    public static Subscription getSubscription() {
        Date startDate = new Date(2001, Calendar.JANUARY,1);
        Date endDate = new Date(2002,Calendar.JANUARY,1);
        return new Subscription(Lists.newArrayList(), Lists.newArrayList(), startDate, endDate);
    }

    public static List<Subscription> getSubscriptions() {
        return Lists.newArrayList(getSubscription());
    }
}
