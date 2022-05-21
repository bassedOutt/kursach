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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CustomerID", nullable = false)
    private Customer customerID;

    @Column(name = "Description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PlatformID")
    private Platform platformID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "StatusID", nullable = false)
    private Status statusID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SubjectID", nullable = false)
    private Subject subjectID;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "cases")
    private Set<EmployeeCase> employeeCases = new LinkedHashSet<>();

}