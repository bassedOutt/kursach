package com.polytech.kursova.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Employee")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoleID")
    private Role roleID;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "LastName", nullable = false, length = 50)
    private String lastName;

    @Column(name = "Email", nullable = false, length = 50)
    private String email;

    @Column(name = "PhoneNumber", length = 15)
    private String phoneNumber;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "employee")
    private Set<Comment> comments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "employee")
    private Set<EmployeeCase> employeeCases = new LinkedHashSet<>();

    @OneToMany(mappedBy = "employee")
    private Set<Salary> salaries = new LinkedHashSet<>();

    @OneToMany(mappedBy = "employeeID")
    private Set<SoftWarePurchase> softWarePurchases = new LinkedHashSet<>();

}