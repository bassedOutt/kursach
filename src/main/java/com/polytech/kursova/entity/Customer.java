package com.polytech.kursova.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID", nullable = false)
    private Integer id;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "LastName", nullable = false, length = 50)
    private String lastName;

    @Column(name = "Email", nullable = false, length = 50)
    private String email;

    @Column(name = "PhoneNumber", length = 20)
    private String phoneNumber;

    @OneToOne(optional = false)
    @JoinColumn(name = "CreditCardID", nullable = false)
    private CreditCard creditCardID;

    @JsonIgnore
    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @JsonIgnore
    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    @OneToOne(optional = false)
    @JoinColumn(name = "SubscriptionID", nullable = false)
    private Subscription subscriptionID;

    @OneToMany
    @JoinColumn(name = "CustomerID")
    private Set<Payment> payments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customer")
    private Set<Case> cases = new LinkedHashSet<>();
}