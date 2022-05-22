package com.polytech.kursova.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @ManyToOne
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "EmployeeCases",
            joinColumns = {@JoinColumn(name = "EmployeeID")},
            inverseJoinColumns = {@JoinColumn(name = "CaseID"), @JoinColumn(name = "CustomerID")}
    )
    private Set<Case> employeeCases = new LinkedHashSet<>();
}