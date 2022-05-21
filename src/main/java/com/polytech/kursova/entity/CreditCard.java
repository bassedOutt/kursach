package com.polytech.kursova.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CreditCardID", nullable = false)
    private Integer id;

    @Column(name = "CreditCardNumber", nullable = false, length = 256)
    private String creditCardNumber;

    @Column(name = "CVV", nullable = false, length = 256)
    private String cvv;

    @Column(name = "ExpirationDate", nullable = false)
    private LocalDate expirationDate;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

}