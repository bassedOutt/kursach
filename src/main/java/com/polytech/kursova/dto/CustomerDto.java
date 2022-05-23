package com.polytech.kursova.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.polytech.kursova.entity.CreditCard;
import com.polytech.kursova.entity.Payment;
import com.polytech.kursova.entity.Subscription;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
public class CustomerDto {
    private Integer id;

    private String name;

    private String lastName;

    private String email;

    private String phoneNumber;

    @JsonIgnore
    private CreditCard creditCardID;

    @JsonIgnore
    private LocalDateTime createdAt;

    @JsonIgnore
    private LocalDateTime updatedAt;

    private Subscription subscriptionID;

    @JsonIgnore
    private Set<Payment> payments = new LinkedHashSet<>();

    @JsonInclude(NON_NULL)
    private Set<CaseDto> cases = new LinkedHashSet<>();

    @JsonProperty("active")
    public String isActive(){
        return subscriptionID.getExpiresAt().isBefore(LocalDateTime.now())?"yes":"no";
    }
}
