package com.filmland.assessment.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Category {
    @Id
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "availableContent", nullable = false, unique = false)
    private int availableContent;
    @Column(name = "price", nullable = false, unique = false)
    private double price;
    @Column(name = "startDate", nullable = true, unique = false)
    private Date startDate;

    public Category(String name, int availableContent, double price, Date startDate){
        this.name = name;
        this.availableContent = availableContent;
        this.price = price;
        this.startDate = startDate;
    }

    public Category(String name, int availableContent, double price){
        this.name = name;
        this.availableContent = availableContent;
        this.price = price;
    }

    public Category(String name){
        this.name = name;
    }

    public Category(){
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAvailableContent(int availableContent) {
        this.availableContent = availableContent;
    }

    public int getAvailableContent(){
        return this.availableContent;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice(){
        return this.price;
    }

    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }

    public Date getStartDate(){
        return this.startDate;
    }
}
