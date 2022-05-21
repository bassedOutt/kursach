package com.polytech.kursova.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoleID", nullable = false)
    private Integer id;

    @Column(name = "RoleName", nullable = false, length = 30)
    private String roleName;

    @Column(name = "CreatedAt")
    private Instant createdAt;

    @Column(name = "UpdatedAt")
    private Instant updatedAt;

    @Column(name = "HourWage")
    private Double hourWage;

}