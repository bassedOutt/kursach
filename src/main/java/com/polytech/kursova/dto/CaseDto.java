package com.polytech.kursova.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.polytech.kursova.entity.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;

@Data
@Builder
public class CaseDto {

    private CaseId id;

    private CustomerDto customer;

    private String description;

    private Platform platformID;

    private Status statusID;

    private Subject subjectID;

    @JsonIgnore
    private LocalDateTime createdAt;

    @JsonIgnore
    private LocalDateTime updatedAt;

    private Set<EmployeeDto> employees;

    @JsonInclude(NON_NULL)
    private Set<CommentDto> comments;

}
