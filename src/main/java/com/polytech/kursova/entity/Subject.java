package com.polytech.kursova.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SubjectID", nullable = false)
    private Integer id;

    @Column(name = "SubjectName", nullable = false, length = 50)
    private String subjectName;

    @JsonIgnore
    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @JsonIgnore
    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

}