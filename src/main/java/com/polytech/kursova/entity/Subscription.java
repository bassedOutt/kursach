package com.polytech.kursova.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SubscriptionID", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "SubscriptionTypeID", nullable = false)
    private SubscriptionType subscriptionTypeID;

    @Column(name = "ExpiresAt", nullable = false)
    private LocalDateTime expiresAt;

    @JsonIgnore
    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @JsonIgnore
    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

}