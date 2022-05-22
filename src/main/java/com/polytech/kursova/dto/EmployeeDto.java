package com.polytech.kursova.dto;

import com.polytech.kursova.entity.Role;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class EmployeeDto {

    private Integer id;

    private Role roleID;

    private String name;

    private String lastName;

    private String email;

    private String phoneNumber;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Set<CaseDto> employeeCases = new LinkedHashSet<>();
}
