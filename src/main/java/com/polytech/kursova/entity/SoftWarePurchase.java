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
public class SoftWarePurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "EmployeeID")
    private Employee employeeID;

    @Column(name = "SoftwareName", nullable = false, length = 50)
    private String softwareName;

    @Column(name = "ActivationKey", nullable = false, length = 256)
    private String activationKey;

    @Column(name = "WebsiteUrl", length = 256)
    private String websiteUrl;

    @JsonIgnore
    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @JsonIgnore
    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "Price", nullable = false)
    private Integer price;

}