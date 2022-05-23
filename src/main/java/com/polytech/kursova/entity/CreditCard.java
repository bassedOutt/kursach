package com.polytech.kursova.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @JsonIgnore
    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @JsonIgnore
    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

}