package com.filmland.assessment.Entity;

import jakarta.persistence.*;
//import lombok.Data;

@Entity
//@Data
@Table(name = "customer", uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique=true)
    private String email;
    @Column(unique=true)
    private String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
