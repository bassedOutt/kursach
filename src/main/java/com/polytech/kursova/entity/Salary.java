package com.polytech.kursova.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Salary {
    @EmbeddedId
    private SalaryId id;
    @MapsId("employeeID")
    @ManyToOne
    @JoinColumn(name = "EmployeeID")
    private Employee employee;

    @Column(name = "WorkedHours", nullable = false)
    private Integer workedHours;

    @Column(name = "Bonus")
    private Double bonus;

    @Column(name = "Fine")
    private Double fine;

    @Column(name = "FinalAmmount", nullable = false)
    private Double finalAmmount;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ManagerID")
    private Employee managerID;

}