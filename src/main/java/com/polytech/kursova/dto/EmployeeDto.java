package com.polytech.kursova.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.polytech.kursova.entity.Role;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
public class EmployeeDto {

    private Integer id;

    private Role roleID;

    private String name;

    private String lastName;

    private String email;

    private String phoneNumber;

    @JsonIgnore
    private LocalDateTime createdAt;

    @JsonIgnore
    private LocalDateTime updatedAt;

    @JsonInclude(NON_NULL)
    private Set<CaseDto> employeeCases = new LinkedHashSet<>();
}
