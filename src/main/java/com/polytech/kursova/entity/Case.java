package com.polytech.kursova.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Cases")
@Getter
@Setter
public class Case {
    @EmbeddedId
    private CaseId id;

    @MapsId("customerID")
    @ManyToOne
    @JoinColumn(name = "CustomerID", nullable = false)
    private Customer customer;

    @Column(name = "Description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "PlatformID")
    private Platform platformID;

    @ManyToOne
    @JoinColumn(name = "StatusID", nullable = false)
    private Status statusID;

    @ManyToOne
    @JoinColumn(name = "SubjectID", nullable = false)
    private Subject subjectID;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    @ManyToMany(mappedBy = "employeeCases")
    private Set<Employee> employees = new LinkedHashSet<>();

    @OneToMany
    @JoinColumn(name = "CaseID")
    @JoinColumn(name = "CustomerID")
    private Set<Comment> comments;
}