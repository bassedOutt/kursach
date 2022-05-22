package com.polytech.kursova.controller;

import com.polytech.kursova.dto.EmployeeDto;
import com.polytech.kursova.dto.mapper.EntityMapper;
import com.polytech.kursova.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
@Slf4j
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository repository;

    private final EntityMapper mapper = EntityMapper.INSTANCE;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDto> findAll() {
        log.info("Retrieving list of customers");
        return repository.findAll().stream()
                .map(mapper::toEmployeeDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDto findById(@PathVariable Integer id) {
        return mapper.toEmployeeDto(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer with id " + id + " not found")));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto save(EmployeeDto entity) {
        return mapper.toEmployeeDto(repository.save(mapper.fromEmployeeDto(entity)));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDto update(EmployeeDto entity) {
        return mapper.toEmployeeDto(repository.save(mapper.fromEmployeeDto(entity)));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
