package com.polytech.kursova.repository;

import com.polytech.kursova.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findCustomerByNameAndLastName(String name, String lastName);

    Optional<Customer> findCustomerByEmail(String email);

    Optional<Customer> findCustomerByPhoneNumber(String phoneNumber);
}
