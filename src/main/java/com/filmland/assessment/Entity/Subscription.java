package com.filmland.assessment.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table
public class Subscription {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name = "customers", nullable = true, unique = false)
    List<Customer> customers;
    @Column(name = "categories", nullable = true, unique = false)
    List<Category> categories;
    @Column(name = "startDate", nullable = true, unique = false)
    private Date startDate;
    @Column(name = "endDate", nullable = true, unique = false)
    private Date endDate;

    public Subscription(Long id, List<Customer> customers, List<Category> categories,
                        Date startDate, Date endDate){
        this.id = id;
        this.customers = customers;
        this.categories = categories;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Subscription(Long id, List<Customer> customers, List<Category> categories,
                        Date startDate){
        this.id = id;
        this.customers = customers;
        this.categories = categories;
        this.startDate = startDate;
    }

    public Subscription(Long id, List<Customer> customers, List<Category> categories){
        this.id = id;
        this.customers = customers;
        this.categories = categories;
    }

    public Subscription(Long id){
        this.id = id;
    }

    public Subscription(List<Customer> customers, List<Category> categories,
                        Date startDate, Date endDate){
        this.customers = customers;
        this.categories = categories;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Subscription(List<Customer> customers, List<Category> categories,
                        Date startDate){
        this.customers = customers;
        this.categories = categories;
        this.startDate = startDate;
    }

    public Subscription(List<Customer> customers, List<Category> categories){
        this.customers = customers;
        this.categories = categories;
    }

    public Subscription(){
    }

    public Long getId(){
        return this.id;
    }

    public void setCustomers(List<Customer> customers){
        this.customers = customers;
    }

    public List<Customer> getCustomers(){
        return this.customers;
    }

    public void setCategories(List<Category> categories){
        this.categories = categories;
    }

    public List<Category> getCategories(){
        return this.categories;
    }

    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }

    public Date getStartDate(){
        return this.startDate;
    }

    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }

    public Date getEndDate(){
        return this.endDate;
    }
}
