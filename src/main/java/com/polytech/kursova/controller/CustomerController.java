package com.polytech.kursova.controller;

import com.polytech.kursova.entity.Customer;
import com.polytech.kursova.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository repository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findAll(){
        return repository.findAll();
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Customer> findById(@PathVariable Integer id){
        return repository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(Customer entity){
        return repository.save(entity);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Customer update(Customer entity){
        return repository.save(entity);
    }

    @ResponseStatus(HttpStatus.OK)
    public void deleteById(Integer id){
        repository.deleteById(id);
    }

}
