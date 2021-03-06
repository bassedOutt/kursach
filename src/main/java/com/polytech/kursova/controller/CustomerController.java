package com.polytech.kursova.controller;

import com.polytech.kursova.dto.CustomerDto;
import com.polytech.kursova.dto.mapper.EntityMapper;
import com.polytech.kursova.entity.Customer;
import com.polytech.kursova.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository repository;

    private final EntityMapper mapper = EntityMapper.INSTANCE;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> findAll() {
        log.info("Retrieving list of customers");
        return repository.findAll().stream()
                .map(mapper::toCustomerDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto findById(@PathVariable Integer id) {
        return mapper.toCustomerDto(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer with id " + id + " not found")));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto save(CustomerDto entity) {
        return mapper.toCustomerDto(repository.save(mapper.fromCustomerDto(entity)));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto update(CustomerDto entity) {
        return mapper.toCustomerDto(repository.save(mapper.fromCustomerDto(entity)));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}
