package com.polytech.kursova.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "EmployeeCases")
public class EmployeeCase {
    @EmbeddedId
    private EmployeeCaseId id;
    @MapsId("employeeID")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID")
    private Employee employee;

    @MapsId("caseID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "CaseID", referencedColumnName = "CaseID", nullable = false),
            @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID", nullable = false)
    })
    private Case cases;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

}