package com.polytech.kursova.dto;

import com.polytech.kursova.entity.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
public class CaseDto {

    private CaseId id;

    private CustomerDto customer;

    private String description;

    private Platform platformID;

    private Status statusID;

    private Subject subjectID;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Set<EmployeeDto> employees;
}
