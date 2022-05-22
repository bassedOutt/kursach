package com.polytech.kursova.dto;

import com.polytech.kursova.entity.Case;
import com.polytech.kursova.entity.CreditCard;
import com.polytech.kursova.entity.Payment;
import com.polytech.kursova.entity.Subscription;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Data

public class CustomerDto {
    private Integer id;

    private String name;

    private String lastName;

    private String email;

    private String phoneNumber;

    private CreditCard creditCardID;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Subscription subscriptionID;

    private Set<Payment> payments = new LinkedHashSet<>();

    private Set<CaseDto> cases = new LinkedHashSet<>();
}
