package com.filmland.assessment.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false, unique = false)
    private String password;
    @Column(name = "paymentdate", nullable = false, unique = false)
    private Date paymentDate;

    public Customer(Long id, String email, String password){
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Customer(String email, String password){
        this.email = email;
        this.password = password;
    }

    public Customer(){
    }

    public Long getId(){
        return this.id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPaymentDate(Date paymentDate){
        this.paymentDate = paymentDate;
    }

    public Date getPaymentDate(){
        return this.paymentDate;
    }
}
