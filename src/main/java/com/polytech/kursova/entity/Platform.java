package com.polytech.kursova.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Platform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PlatformID", nullable = false)
    private Integer id;

    @Column(name = "PlatformName", nullable = false, length = 50)
    private String platformName;

    @JsonIgnore
    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @JsonIgnore
    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

}